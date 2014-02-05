package Main;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import Forms.EnterUsnForm;
import Forms.MainForm;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import run.DBConnect;

public class DownloadMarksTask extends SwingWorker<Integer, Integer> {

    PreparedStatement pstmt, pstmtMain;

    public DownloadMarksTask() {
        //initialize 
        Connection con = DBConnect.connection;

        // String sql = " DELETE from RESULTTABLE ";
        //String query = "INSERT INTO RESULTTABLE values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        String query = "Insert into sub_table values (?,?,?,?,?,?)";
        String queryMain = "Insert into main values (?,?,?,?)";
        try {
            pstmt = con.prepareStatement(query);
            System.out.println("pstmt");
        } catch (SQLException ex) {
            Logger.getLogger(DownloadMarksTask.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            pstmtMain = con.prepareStatement(queryMain);
            System.out.println("pstmtMain");
        } catch (SQLException ex) {
            Logger.getLogger(DownloadMarksTask.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public Integer doInBackground() throws InterruptedException {
        MainForm.curUsnDownloadLabel.show();
        resultFetch r = new resultFetch();
        if (MainForm.stopFlag == true) {
            stopFetching();
        }
        try {
            for (int i = 0; i < MainForm.usnList.size() && MainForm.stopFlag == false; i++) {
                int colCount = 1;
                setProgress((i + 1) * 100 / MainForm.usnList.size());
                MainForm.setCurStatusLabel("Downloading USN :" + MainForm.usnList.get(i));
                System.out.println(MainForm.usnList.get(i));

                if ((r.FetchTheresult(MainForm.usnList.get(i), EnterUsnForm.sem))) { //&& r.fetchSubjectNames(MainForm.usnList.get(i), EnterUsnForm.sem)) {
                    //display marks

                    //      pstmt.setString(colCount++, MainForm.usnList.get(i));
                    //     pstmt.setString(colCount++, r.name);
                    pstmtMain.setString(1, MainForm.usnList.get(i));
                    pstmtMain.setString(2, r.name);
                    pstmtMain.setInt(3, Integer.parseInt(r.totalmarks));
                    pstmtMain.setString(4, r.mk);
                    pstmtMain.execute();
                    pstmt.setString(1, MainForm.usnList.get(i));
                    for (int x = 0; x < 8; x++) {
                        //         pstmt.setInt(colCount++, r.marks[x][1]);
                        //         pstmt.setInt(colCount++, r.marks[x][0]);
                        //         pstmt.setInt(colCount++, r.marks[x][2]);
                        //         pstmt.setString(colCount++, r.res[x]);

                        pstmt.setString(2, r.subjects[x]);
                        pstmt.setInt(3, r.marks[x][1]);
                        pstmt.setInt(4, r.marks[x][0]);
                        pstmt.setInt(5, r.marks[x][2]);
                        pstmt.setString(6, r.res[x]);
                        pstmt.execute();
                    }
                    //        pstmt.setInt(colCount++, Integer.parseInt(r.totalmarks));
                    //        pstmt.setString(colCount++, r.mk);

                }
            }

        } catch (Exception e) {
            System.out.println("Error:" + e);
            JOptionPane.showMessageDialog(null, e + " Download marks task");
            System.out.println("Exception is here");
        }
        return 1;
    }

    @Override
    protected void process(List<Integer> chunks) {

    }

    @Override
    protected void done() {
        // MainForm.objCopy.usnProgressBar.hide();
        MainForm.objCopy.clickStop();
        System.out.println("DONE!!!");
        MainForm.log("Download Completed.");
        MainForm.log("Please check download details to see list of USN failed to fetch.");
        MainForm.setCurStatusLabel("DOWNLOAD COMPLETE");
        if (MainForm.autoRetry && MainForm.stopFlag == false) {
            MainForm.objCopy.clickRestart();
        }

    }

    public void stopFetching() {
        this.cancel(true);
    }
}
