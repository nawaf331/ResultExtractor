package Forms;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import Main.DownloadMarksTask;
import java.awt.Color;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.DefaultCaret;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import run.DBConnect;
import static run.DBConnect.connection;
import run.DBInterface;
import static run.DBInterface.STUDENT_DETAILS;
import static run.DBInterface.ST_NAME;
import static run.DBInterface.ST_RESULT;
import static run.DBInterface.ST_TOTAL;
import static run.DBInterface.ST_USN;
import static run.DBInterface.SUBJECT_DETAILS;
import static run.DBInterface.SUB_EXTERNAL;
import static run.DBInterface.SUB_INTERNAL;
import static run.DBInterface.SUB_RESULT;
import static run.DBInterface.SUB_SUBNAME;
import static run.DBInterface.SUB_TOTAL;
import static run.DBInterface.SUB_USN;

public class MainForm extends javax.swing.JFrame implements DBInterface {

    public static int timeout = 25;
    public static boolean autoRetry = true;
    public static int retrylimit = 10;
    public static Vector<String> usnList = new Vector<String>();
    public static Vector<String> subNamesV = new Vector<String>();
    public static Vector<String> RetryList = new Vector<String>();
    public static boolean stopFlag = true;
    public static DownloadDetailsForm DF ;
    private final int fetchCount;
    public static MainForm objCopy;
    DownloadMarksTask task;
    boolean subjectFetched = false; // this is again initialized in start button
    int subjectFetchTries = 5;  // this value is again initialized in start button action

    public MainForm() {
        initComponents();
        this.setLocationRelativeTo(null);
        DefaultCaret caret = (DefaultCaret) textAreaLog.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

        stopbtn.setEnabled(false);
        b_retry.setEnabled(false);
        menuAutoRetry.setSelected(true);

        fetchCount = 0;
        run.DBConnect.getConnection();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BGinput = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        submitButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        bView = new javax.swing.JButton();
        stopbtn = new javax.swing.JButton();
        B_UsnSelect = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        bSubjectWise = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btn_save = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        b_retry = new javax.swing.JButton();
        usnProgressBar = new javax.swing.JProgressBar(0,100);
        jLabel3 = new javax.swing.JLabel();
        TF_usn = new javax.swing.JTextField();
        B_GetResult = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textAreaLog = new javax.swing.JTextPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        menuNew = new javax.swing.JMenuItem();
        menuAboutUs = new javax.swing.JMenuItem();
        menuExit = new javax.swing.JMenuItem();
        menuTools = new javax.swing.JMenu();
        menuAutoRetry = new javax.swing.JCheckBoxMenuItem();
        menuSetProxy = new javax.swing.JMenuItem();
        menuSetTimeOut = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Vtu Marks Downloader");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Class Result", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        submitButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        submitButton.setText("Start");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Start Downloading :");

        bView.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bView.setText("View");
        bView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bViewActionPerformed(evt);
            }
        });

        stopbtn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        stopbtn.setText("Stop");
        stopbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopbtnActionPerformed(evt);
            }
        });

        B_UsnSelect.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        B_UsnSelect.setText("Select");
        B_UsnSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_UsnSelectActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Select USN List  :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("View Results :");

        bSubjectWise.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bSubjectWise.setText("Subject Wise");
        bSubjectWise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSubjectWiseActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Save results :");

        btn_save.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btn_save.setText("Save");
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton1.setText("Details");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        b_retry.setText("Retry");
        b_retry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_retryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel5))
                            .addGap(48, 48, 48)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btn_save)
                                .addComponent(bView, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(B_UsnSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(bSubjectWise, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(43, 43, 43))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(stopbtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(b_retry)
                        .addGap(24, 24, 24))))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {B_UsnSelect, bView, btn_save, submitButton});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(B_UsnSelect)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(submitButton)
                    .addComponent(stopbtn)
                    .addComponent(b_retry))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(bView)
                    .addComponent(bSubjectWise))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(btn_save))
                .addContainerGap(64, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Enter USN :");

        TF_usn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        B_GetResult.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        B_GetResult.setText("Get Result");
        B_GetResult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_GetResultActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Details ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        textAreaLog.setBackground(new java.awt.Color(0, 0, 0));
        jScrollPane2.setViewportView(textAreaLog);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
        );

        menuFile.setText("File");

        menuNew.setText("New");
        menuNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNewActionPerformed(evt);
            }
        });
        menuFile.add(menuNew);

        menuAboutUs.setText("About Us");
        menuAboutUs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAboutUsActionPerformed(evt);
            }
        });
        menuFile.add(menuAboutUs);

        menuExit.setText("Exit");
        menuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuExitActionPerformed(evt);
            }
        });
        menuFile.add(menuExit);

        jMenuBar1.add(menuFile);

        menuTools.setText("Tools");

        menuAutoRetry.setSelected(true);
        menuAutoRetry.setText("Auto Retry");
        menuAutoRetry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAutoRetryActionPerformed(evt);
            }
        });
        menuTools.add(menuAutoRetry);

        menuSetProxy.setText("Set Proxy");
        menuSetProxy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSetProxyActionPerformed(evt);
            }
        });
        menuTools.add(menuSetProxy);

        menuSetTimeOut.setText("Set Time Out");
        menuSetTimeOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSetTimeOutActionPerformed(evt);
            }
        });
        menuTools.add(menuSetTimeOut);

        jMenuBar1.add(menuTools);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(TF_usn, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(B_GetResult, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(usnProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TF_usn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B_GetResult)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(usnProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void B_UsnSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_UsnSelectActionPerformed
        EnterUsnForm u = new EnterUsnForm();
        u.setVisible(true);
    }//GEN-LAST:event_B_UsnSelectActionPerformed

    private void stopbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopbtnActionPerformed
        logError("Result Fetching Interrupted");
        stopbtn.setEnabled(false);
        stopFlag = true;
        clickStop();
    }//GEN-LAST:event_stopbtnActionPerformed

    private void bViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bViewActionPerformed
        new DisplayForm().setVisible(true);
    }//GEN-LAST:event_bViewActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        
        DF = new DownloadDetailsForm();
        log("Result fetching started ...");
        log("Please wait till fetching has compleeted.");

        usnProgressBar.setValue(usnProgressBar.getMinimum());

        if (usnList.size() == 0) {
            logError("Please Add atleast 1 USN to fetch result");
            JOptionPane.showMessageDialog(null, "Please Add at least 1 USN");
        } else {
            stopFlag = false;
            submitButton.setEnabled(false);
            stopbtn.setEnabled(true);
            updateProgress();
        }

    }//GEN-LAST:event_submitButtonActionPerformed

    private void menuSetProxyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSetProxyActionPerformed
        new ProxyForm().setVisible(true);
    }//GEN-LAST:event_menuSetProxyActionPerformed

    private void menuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menuExitActionPerformed

    private void B_GetResultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_GetResultActionPerformed
        String resultUrl = "http://results.vtu.ac.in";
        Pattern p = Pattern.compile("4[a-zA-Z][a-zA-Z][0-9]{2}[a-zA-Z]{2}[0-9]{3}");
        String Str_singleUsn = TF_usn.getText();
        Matcher m = p.matcher(Str_singleUsn);
        if (Str_singleUsn.equals("")) {
            JOptionPane.showMessageDialog(null, "Please Enter The USN ");
        } else if (!m.matches()) {
            JOptionPane.showMessageDialog(null, "Invalid USN Format");
        } else {

            resultUrl = "http://results.vtu.ac.in/vitavi.php?submit=true&rid=" + TF_usn.getText();

            Runtime rt = Runtime.getRuntime();
            try {
                Process clientProcess = rt.exec(new String[]{"C:\\Program Files\\Mozilla Firefox\\firefox.exe", "-new-window", resultUrl});
                //Process clientProcess = rt.exec(new String[]{"START /max iexplore.exe", "-new-window", resultUrl});

                clientProcess.waitFor();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_B_GetResultActionPerformed

    private void bSubjectWiseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSubjectWiseActionPerformed
        SubjectWiseResult frame = new SubjectWiseResult();
        frame.setVisible(true);
    }//GEN-LAST:event_bSubjectWiseActionPerformed

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        /*int count = 0;
         DisplayForm df = new DisplayForm("Dummy");
         //   initComponents();
         df.retrieveSubjectNames();
         DefaultTableModel model = new DefaultTableModel();
         try {
         model.addColumn("USN");
         model.addColumn("NAME");
         model.addColumn(MainForm.subNamesV.get(0));
         model.addColumn(MainForm.subNamesV.get(1));
         model.addColumn(MainForm.subNamesV.get(2));
         model.addColumn(MainForm.subNamesV.get(3));
         model.addColumn(MainForm.subNamesV.get(4));
         model.addColumn(MainForm.subNamesV.get(5));
         model.addColumn(MainForm.subNamesV.get(6));
         model.addColumn(MainForm.subNamesV.get(7));
         model.addColumn("TOTAL");
         model.addColumn("RESULT");
         ResultSet r = df.getDetails("SOME");

         while (r.next()) {
         model.insertRow(count++, new Object[]{r.getString(1), r.getString(2), r.getInt(5), r.getInt(9), r.getInt(13), r.getInt(17), r.getInt(21), r.getInt(25), r.getInt(29), r.getInt(33), r.getInt(35), r.getString(36)});

         }
         SaveTable ST = new SaveTable(model);
         } catch (SQLException ex) {
         //  Logger.getLogger(MainForm.class
         //          .getName()).log(Level.SEVERE, null, ex);
         JOptionPane.showMessageDialog(this, "Couldn't save any data ", "Error!", JOptionPane.ERROR_MESSAGE);
         } catch (Exception ex) {
         //  Logger.getLogger(MainForm.class
         //          .getName()).log(Level.SEVERE, null, ex);
         JOptionPane.showMessageDialog(this, "Failed to save :  " + ex.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
         }
         */
    }//GEN-LAST:event_btn_saveActionPerformed

    private void menuAboutUsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAboutUsActionPerformed
        new AboutUs().setVisible(true);
    }//GEN-LAST:event_menuAboutUsActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DF.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void menuSetTimeOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSetTimeOutActionPerformed
        Object[] timeArray = {"5", "10", "15", "20", "25"};

        Object str = JOptionPane.showInputDialog(null, "Select the timeout (in seconds) : ", "Set time out", JOptionPane.QUESTION_MESSAGE, null, timeArray, timeArray[4]);

        if (str != null) {
            System.out.println("str is : " + str);
            timeout = Integer.parseInt(str.toString());
            if (timeout == 0) {
                timeout = 25;
            }
        } else {
            System.out.println("cancelled");
        }
    }//GEN-LAST:event_menuSetTimeOutActionPerformed

    private void b_retryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_retryActionPerformed
        clickRestart();
    }//GEN-LAST:event_b_retryActionPerformed

    private void menuAutoRetryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAutoRetryActionPerformed
        // TODO add your handling code here:
        if (menuAutoRetry.isSelected()) {
            autoRetry = true;
            Object[] limitArray = {"1", "3", "5", "10", "20", "INF"};

            Object str = JOptionPane.showInputDialog(null, "Select Number of retry Attempts : ", "Set Retry Attempts", JOptionPane.QUESTION_MESSAGE, null, limitArray, limitArray[3]);

            if (str != null) {
                MainForm.log("Auto Retry Attempts set to : " + str);
                if (str.equals("INF")) {
                    retrylimit = 999;
                } else {
                    retrylimit = Integer.parseInt(str.toString());
                }
                if (retrylimit == 0) {
                    timeout = 10;
                }

            } else {
                System.out.println("cancelled");
            }

            log("Auto retry is Enabled. USN failed to fetch will be retried automatically");
        } else {
            autoRetry = false;
            log("Auto retry is Disabled. Please Click retry to fetch failed USN list");
        }
    }//GEN-LAST:event_menuAutoRetryActionPerformed

    private void menuNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNewActionPerformed
        int x = JOptionPane.showConfirmDialog(null, "This will delete all your previous records\nAre you sure you want to continue ?", "New database", JOptionPane.OK_CANCEL_OPTION);
        if (x == 0) {
            log("Deleting previous records !");
            Connection con = DBConnect.connection;
            Statement stmtSt, stmtSub;
            String querySt = " DROP TABLE " + STUDENT_DETAILS;
            String querySub = "DROP TABLE " + SUBJECT_DETAILS;
            try {
                stmtSt = con.createStatement();
                stmtSub = con.createStatement();
                stmtSt.executeUpdate(querySt);
                stmtSub.executeUpdate(querySub);

            } catch (SQLException ex) {
                log(ex.getMessage());
                Logger.getLogger(DownloadMarksTask.class.getName()).log(Level.SEVERE, null, ex);
            }

            Statement stmt, stmt1;

            String query1 = "CREATE TABLE " + SUBJECT_DETAILS + " ('" + SUB_USN + "' VARCHAR NOT NULL , '" + SUB_SUBNAME + "' VARCHAR NOT NULL , '" + SUB_INTERNAL + "' INTEGER, '" + SUB_EXTERNAL + "' INTEGER, '" + SUB_TOTAL + "' INTEGER, '" + SUB_RESULT + "' CHAR, PRIMARY KEY (" + SUB_USN + ", " + SUB_SUBNAME + "))";
            String query2 = "CREATE TABLE " + STUDENT_DETAILS + " ('" + ST_USN + "' VARCHAR, '" + ST_NAME + "' VARCHAR, '" + ST_TOTAL + "' INTEGER, '" + ST_RESULT + "' VARCHAR, PRIMARY KEY (" + ST_USN + "))";
            try {
                stmt = connection.createStatement();
                stmt1 = connection.createStatement();

                stmt.executeUpdate(query1);
                stmt1.executeUpdate(query2);
                MainForm.log("Initializing Database : Successfull");
            } catch (SQLException ex) {
                // Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
                MainForm.log("Table already exists .");
            }
        }
    }//GEN-LAST:event_menuNewActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
            java.util.logging.Logger.getLogger(MainForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            JOptionPane.showMessageDialog(null, ex);
            java.util.logging.Logger.getLogger(MainForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            JOptionPane.showMessageDialog(null, ex);
            java.util.logging.Logger.getLogger(MainForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            JOptionPane.showMessageDialog(null, ex);
            java.util.logging.Logger.getLogger(MainForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                objCopy = new MainForm();
                objCopy.setVisible(true);
                log("Welcome to Result extractor.");
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup BGinput;
    private javax.swing.JButton B_GetResult;
    private javax.swing.JButton B_UsnSelect;
    private javax.swing.JTextField TF_usn;
    private javax.swing.JButton bSubjectWise;
    private javax.swing.JButton bView;
    private javax.swing.JButton b_retry;
    private javax.swing.JButton btn_save;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem menuAboutUs;
    private javax.swing.JCheckBoxMenuItem menuAutoRetry;
    private javax.swing.JMenuItem menuExit;
    private javax.swing.JMenu menuFile;
    private javax.swing.JMenuItem menuNew;
    private javax.swing.JMenuItem menuSetProxy;
    private javax.swing.JMenuItem menuSetTimeOut;
    private javax.swing.JMenu menuTools;
    private javax.swing.JButton stopbtn;
    private javax.swing.JButton submitButton;
    private javax.swing.JTextPane textAreaLog;
    public javax.swing.JProgressBar usnProgressBar;
    // End of variables declaration//GEN-END:variables

    private void updateProgress() {
        usnProgressBar.setMinimum(0);
        usnProgressBar.setMaximum(100);

        task = new Main.DownloadMarksTask();
        task.addPropertyChangeListener(
                new PropertyChangeListener() {

                    public void propertyChange(PropertyChangeEvent evt) {
                        if ("progress".equals(evt.getPropertyName())) {
                            usnProgressBar.setValue((Integer) evt.getNewValue());
                        }
                    }
                });

        task.execute();
    }

    public void clickStop() {
        submitButton.setEnabled(true);
        // stopbtn.setEnabled(false);
        task.stopFetching();
        b_retry.setEnabled(true);
    }

    public void clickRestart() {
        b_retry.setEnabled(false);
        log("Retrying to fetch Failed Usn list.");
        log("Please Wait !");
        System.out.println("retrying !!");
        usnList.clear();
        for (int i = 0; i < RetryList.size(); i++) {
            System.out.println(RetryList.get(i));
            usnList.add(RetryList.get(i));
        }
        RetryList.clear();
        usnProgressBar.setValue(usnProgressBar.getMinimum());
        stopFlag = false;
        submitButton.setEnabled(false);
        stopbtn.setEnabled(true);
        updateProgress();
    }

    public static void log(String text) {  // normal log with black text
        objCopy.appendToPane("> " + text + "\n", Color.BLACK);
    }

    public static void logError(String text) { // error log with red text
        objCopy.appendToPane("> " + text + "\n", Color.RED);
    }

    private void appendToPane(String msg, Color c) { // used by error log to make text red        
        StyleContext sc = StyleContext.getDefaultStyleContext();
        AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, c);
        aset = sc.addAttribute(aset, StyleConstants.FontFamily, "Lucida Console");
        aset = sc.addAttribute(aset, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);
        int len = textAreaLog.getDocument().getLength();
        textAreaLog.setCaretPosition(len);
        textAreaLog.setCharacterAttributes(aset, false);
        textAreaLog.replaceSelection(msg);
    }
}
