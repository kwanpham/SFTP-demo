/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author MyPC
 */
public class NewJFrame extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public NewJFrame() throws IOException {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() throws IOException {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnSendFile = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnGetReport = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("OpenPGP");
        //getContentPane().setBackground(new Color(239,240,241));
        setResizable(false);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));


        ImageIcon img = new ImageIcon("src/main/resources/logo.jpg");
        setIconImage(img.getImage());
        setLocationByPlatform(true);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText(" G SEF Program");
        jLabel1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        try {
            fileCountInDoc = CheckFolderDoc.fileCount();
            if (fileCountInDoc < 1) {
                jLabel3.setText("You don't have any file need to send");
            } else {
                jLabel3.setText("You  have " + fileCountInDoc + " file(s) need to send");
            }
        }catch (IOException e) {
            JOptionPane.showMessageDialog(rootPane , "Can't read dir " + Constant.docPath);

        }


        btnSendFile.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnSendFile.setText("Send now");


        btnSendFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               sendFile();
            }
        });


        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("Last Result : ");



        jLabel4.setText("_______________________________________________________________________________");

        btnGetReport.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnGetReport.setText("Get report file");

        btnGetReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getReportFile();
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("File will save in : D:.SFTP/Report");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setText("Last Result : ");

        jLabel7.setText("_______________________________________________________________________________");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel8.setText("Copyright InfoPlus ltd.");

        jLabel9.setText("Support team info Mr Anh (+84 972975001)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel6)
                                                        .addComponent(jLabel5)
                                                        .addComponent(jLabel2)
                                                        .addComponent(btnGetReport)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel3)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(btnSendFile)
                                                                .addGap(61, 61, 61))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel9)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(btnSendFile))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(btnGetReport)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6)
                                .addGap(35, 35, 35)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel9))
                                .addContainerGap())
        );

        pack();
//        FileWorker fileWorker = new FileWorker(jLabel3 , fileCountInDoc);
//        fileWorker.addPropertyChangeListener(new PropertyChangeListener() {
//            @Override
//            public void propertyChange(PropertyChangeEvent evt) {
//                if ("progress".equals(evt.getPropertyName())) {
//                    jLabel3.setText(String.valueOf(evt.getNewValue()));
//                }
//            }
//        });
//        fileWorker.execute();


        File directory = new File(Constant.docPath);
        final DefaultListModel<File> model = new DefaultListModel<File>();
        for (File file : directory.listFiles()) {
            model.addElement(file);
        }
        final FileWorker2 worker = new FileWorker2(directory , fileCountInDoc);
        PropertyChangeListener l = new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (FileWorker2.FILE_DELETED == evt.getPropertyName()) {
                    model.removeElement(evt.getNewValue());
                    jLabel3.setText(model.toString());
                } else if (FileWorker2.FILE_CREATED == evt.getPropertyName()) {
                    jLabel3.setText(model.toString());
                    model.addElement((File) evt.getNewValue());
                } else if (evt.getPropertyName().equals("count")){
                    long count = (long)evt.getNewValue();
                    if (count < 1) {
                        jLabel3.setText("You don't have any file need to send ");
                    } else {
                        jLabel3.setText("You  have " + count + " file(s) need to send");
                    }

                }
            }
        };
        worker.addPropertyChangeListener(l);
        worker.execute();

    }// </editor-fold>

    private void getReportFile() {
        try {
            btnGetReport.setCursor(new java.awt.Cursor(Cursor.WAIT_CURSOR));
            long count  = new RecieveFile().recieve();
            String message = count > 0 ? "Get sussess " + count + " report(s)" : "Don't have any report";
            JOptionPane.showMessageDialog(rootPane , message);
            jLabel6.setText("Last Result : "+message);
        } catch (Exception e) {
            e.printStackTrace();
            jLabel6.setText("Last Result : Get Report Error");
            JOptionPane.showMessageDialog(rootPane , e.getMessage());
        } finally {
            btnGetReport.setCursor(new java.awt.Cursor(Cursor.DEFAULT_CURSOR));
        }
    }

    private void sendFile() {
        try {
            btnSendFile.setCursor(new java.awt.Cursor(Cursor.WAIT_CURSOR));
            long countFile = new SendFile().send();
            String message = countFile<1 ? "There is no file in " + Constant.docPath + " or file type is not txt": "Encrypt and send " +countFile+ " file(s) sussess";
            jLabel2.setText("Last Result : "+message);
            JOptionPane.showMessageDialog(rootPane ,message);
        } catch (Exception e) {
            jLabel2.setText("Last Result : Encrypt Or Send File Error");
            e.printStackTrace();
            JOptionPane.showMessageDialog(rootPane , e.getMessage());
        } finally {
            btnSendFile.setCursor(new java.awt.Cursor(Cursor.DEFAULT_CURSOR));
        }
    }



    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws IOException {
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
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                try {
                    new NewJFrame().setVisible(true);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

//        new CheckFolderDoc().checkDocPath(fileCountInDoc);


    }

    // Variables declaration - do not modify
    private javax.swing.JButton btnSendFile;
    private javax.swing.JButton btnGetReport;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration

    private static long fileCountInDoc =0;
}
