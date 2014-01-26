/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import Main.extractUSN;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Ashu
 */
public class EnterUsnForm extends javax.swing.JFrame {

    public static Vector<String> localUsnList = new Vector<>();
    public static int sem = 0;
    DefaultListModel list = new DefaultListModel();
    extractUSN e;
    public static String usnMatcher = "";

    /**
     * Creates new form EnterUsnForm
     */
    public EnterUsnForm() {
        initComponents();
        this.setLocationRelativeTo(null);
        if (MainForm.usnList.size() == 0) {
            usnMatcher = "";
        }

        list.clear();
        for (int i = 0; i < MainForm.usnList.size(); i++) {
            System.out.println(MainForm.usnList.get(i));
            list.addElement(MainForm.usnList.get(i));
        }
        List_Usn.setModel(list);
        System.out.println("usn matcher is " + usnMatcher);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        B_multipleAdd = new javax.swing.JButton();
        TF_from = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TF_to = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        TF_SingleUsn = new javax.swing.JTextField();
        B_singleAdd = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        ipFileButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        Lab_filename = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        List_Usn = new javax.swing.JList();
        B_done = new javax.swing.JButton();
        bDelete = new javax.swing.JButton();
        bClearAll = new javax.swing.JButton();
        B_cancel = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        Combo_sem = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Analyser - Add USN");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Choose Method", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 10))); // NOI18N

        B_multipleAdd.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        B_multipleAdd.setText("Add");
        B_multipleAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_multipleAddActionPerformed(evt);
            }
        });

        TF_from.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TF_from.setText("4PA10CS001");
        TF_from.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_fromActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("to");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Add a range of USN :");

        TF_to.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TF_to.setText("4PA10CS085");

        jLabel2.setText("USN :");

        B_singleAdd.setText("Add");
        B_singleAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_singleAddActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Enter individual Usn :");

        ipFileButton.setText("Select");
        ipFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ipFileButtonActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Load From file :");

        Lab_filename.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ipFileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Lab_filename, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(B_multipleAdd)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(TF_from, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TF_to, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator2)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(9, 9, 9)
                        .addComponent(TF_SingleUsn, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(B_singleAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TF_SingleUsn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(B_singleAdd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TF_from, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(TF_to, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(B_multipleAdd)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(Lab_filename, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(ipFileButton))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "USN LIST", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 10))); // NOI18N

        jScrollPane1.setViewportView(List_Usn);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
                .addContainerGap())
        );

        B_done.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        B_done.setText("Done");
        B_done.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_doneActionPerformed(evt);
            }
        });

        bDelete.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bDelete.setText("Delete");
        bDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDeleteActionPerformed(evt);
            }
        });

        bClearAll.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bClearAll.setText("Clear All");
        bClearAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bClearAllActionPerformed(evt);
            }
        });

        B_cancel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        B_cancel.setText("Cancel");
        B_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_cancelActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Choose Semester :");

        Combo_sem.setEditable(true);
        Combo_sem.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Combo_sem.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(B_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(B_done, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel3)
                        .addGap(22, 22, 22)
                        .addComponent(Combo_sem, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bClearAll, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bClearAll, bDelete});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {B_cancel, B_done});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(Combo_sem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(B_done, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(B_cancel, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(bDelete, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(bClearAll, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TF_fromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_fromActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TF_fromActionPerformed

    private void B_multipleAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_multipleAddActionPerformed
        String fromUsn = TF_from.getText();
        String toUsn = TF_to.getText();
        //Pattern p = Pattern.compile("4[pP][aA][0-9]{2}[a-zA-Z]{2}[0-9]{3}");
        Pattern p = Pattern.compile("4[a-zA-Z][a-zA-Z][0-9]{2}[a-zA-Z]{2}[0-9]{3}");
        Matcher mFr = p.matcher(fromUsn);
        Matcher mTo = p.matcher(toUsn);

        String trimedFr = fromUsn.substring(0, 7);
        String trimmedTo = toUsn.substring(0, 7);

        if (fromUsn.equals("") || toUsn.equals("")) {
            JOptionPane.showMessageDialog(null, "Please Enter The USN Range ");
        } else if (!mFr.matches() || !mTo.matches()) {
            JOptionPane.showMessageDialog(null, "Invalid USN Format");
        } else if (!trimmedTo.equalsIgnoreCase(trimedFr) || (!usnMatcher.equals("") && !trimmedTo.equalsIgnoreCase(usnMatcher))) {
            JOptionPane.showMessageDialog(null, "Invalid USN Range");
        } else {

            if (usnMatcher.equals("")) {
                usnMatcher = fromUsn.substring(5, 7);
                System.out.println("usn set in multiple");
            }
            int start = Integer.parseInt(fromUsn.substring(7));
            int stop = Integer.parseInt(toUsn.substring(7));

            System.out.println("start " + start);
            System.out.println("stop " + stop);

            for (int i = start; i <= stop; i++) {
                localUsnList.add(trimedFr + String.format("%03d", i));
            }

            for (int i = 0; i < localUsnList.size(); i++) {
                System.out.println(localUsnList.get(i));
                list.addElement(localUsnList.get(i));

            }
            List_Usn.setModel(list);
        }
        System.out.println("usn matcher is " + usnMatcher);
    }//GEN-LAST:event_B_multipleAddActionPerformed

    private void B_singleAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_singleAddActionPerformed
        // Pattern p = Pattern.compile("4[pP][aA][0-9]{2}[a-zA-Z]{2}[0-9]{3}");
        Pattern p = Pattern.compile("4[a-zA-Z][a-zA-Z][0-9]{2}[a-zA-Z]{2}[0-9]{3}");
        String Str_singleUsn = TF_SingleUsn.getText();
        String trimmedUsn = null;
        Matcher m = p.matcher(Str_singleUsn);
        if (!Str_singleUsn.equals("")) {
            trimmedUsn = Str_singleUsn.substring(0, 7);
            System.out.println("trimmed usn = " + trimmedUsn);
        }
        if (Str_singleUsn.equals("")) {
            JOptionPane.showMessageDialog(null, "Please Enter The USN ");
        } else if (!m.matches()) {
            JOptionPane.showMessageDialog(null, "Invalid USN Format");
        } else if (!usnMatcher.equals("") && !trimmedUsn.substring(5, 7).equalsIgnoreCase(usnMatcher)) {
            JOptionPane.showMessageDialog(null, "Invalid USN .Make sure all The USN correspond to same branch");
        } else {

            if (usnMatcher.equals("")) {
                usnMatcher = trimmedUsn.substring(5, 7);
                System.out.println("usn set in single");
            }
            list.addElement(Str_singleUsn);
            List_Usn.setModel(list);
        }
        System.out.println("usn matcher is " + usnMatcher);
    }//GEN-LAST:event_B_singleAddActionPerformed

    private void ipFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ipFileButtonActionPerformed
        //extractUSN.usnList.clear();
        //Create a file chooser
        JFileChooser fc = null;
        String inFile;
        try {
            fc = new JFileChooser(previousDirectory());
        } catch (IOException ex) {
            Logger.getLogger(EnterUsnForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        //In response to a button click:
        int returnVal = fc.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            Lab_filename.setText(file.getName());
            //This is where a real application would open the file.
            inFile = file.getAbsolutePath();
            saveCurrentDirectory(file.getParentFile().getAbsolutePath());
            e = new extractUSN(inFile);
            list.clear();
            for (int i = 0; i < localUsnList.size(); i++) {
                System.out.println(localUsnList.get(i));
                list.addElement(localUsnList.get(i));
            }
            List_Usn.setModel(list);

        } else {
            System.out.println("Open command cancelled by user.");
        }
    }//GEN-LAST:event_ipFileButtonActionPerformed

    private void B_doneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_doneActionPerformed
            sem = Integer.parseInt(Combo_sem.getSelectedItem().toString());
            for (int i = 0; i < list.size(); i++) {
                MainForm.usnList.add(list.getElementAt(i).toString());
            this.dispose();
            }
    }//GEN-LAST:event_B_doneActionPerformed

    private void B_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_cancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_B_cancelActionPerformed

    private void bClearAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bClearAllActionPerformed
        list.removeAllElements();
        MainForm.usnList.clear();
        usnMatcher = "";
    }//GEN-LAST:event_bClearAllActionPerformed

    private void bDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDeleteActionPerformed
        list.removeElementAt(List_Usn.getSelectedIndex());
    }//GEN-LAST:event_bDeleteActionPerformed

    private void saveCurrentDirectory(String absolutePath) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(".previouslySelectedDirectory.txt"));
            writer.write(absolutePath);
            writer.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            System.out.println("Error:" + e);
        }
    }

    public String previousDirectory() throws IOException {
        BufferedReader br = null;
        String line = "";
        try {
            br = new BufferedReader(new FileReader(".previouslySelectedDirectory.txt"));
            line = br.readLine();
        } catch (Exception e) {

            System.out.println("Error: " + e);
        } finally {
            if (br != null) {
                br.close();
            }
        }
        return line;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EnterUsnForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EnterUsnForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EnterUsnForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EnterUsnForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EnterUsnForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton B_cancel;
    private javax.swing.JButton B_done;
    private javax.swing.JButton B_multipleAdd;
    private javax.swing.JButton B_singleAdd;
    private javax.swing.JComboBox Combo_sem;
    private javax.swing.JLabel Lab_filename;
    private javax.swing.JList List_Usn;
    private javax.swing.JTextField TF_SingleUsn;
    private javax.swing.JTextField TF_from;
    private javax.swing.JTextField TF_to;
    private javax.swing.JButton bClearAll;
    private javax.swing.JButton bDelete;
    private javax.swing.JButton ipFileButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables

}
