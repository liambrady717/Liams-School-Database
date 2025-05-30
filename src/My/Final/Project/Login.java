/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package my.FinalProject;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author LiamBrady
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanelWhite = new javax.swing.JPanel();
        jLabelTitle = new javax.swing.JLabel();
        jLabelLogin = new javax.swing.JLabel();
        jLabelPassword = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jPasswordFieldPassword = new javax.swing.JPasswordField();
        jButtonLogin = new javax.swing.JButton();
        jRadioButtonTeacher = new javax.swing.JRadioButton();
        jRadioButtonAdmin = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");

        jPanelWhite.setBackground(new java.awt.Color(255, 255, 255));

        jLabelTitle.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabelTitle.setText("Login");

        jLabelLogin.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelLogin.setText("Email:");

        jLabelPassword.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelPassword.setText("Password:");

        jTextFieldEmail.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jPasswordFieldPassword.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jButtonLogin.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButtonLogin.setText("Login");
        jButtonLogin.setFocusPainted(false);
        jButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoginActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButtonTeacher);
        jRadioButtonTeacher.setText("Teacher");
        jRadioButtonTeacher.setFocusable(false);

        buttonGroup1.add(jRadioButtonAdmin);
        jRadioButtonAdmin.setText("Admin");
        jRadioButtonAdmin.setFocusable(false);

        javax.swing.GroupLayout jPanelWhiteLayout = new javax.swing.GroupLayout(jPanelWhite);
        jPanelWhite.setLayout(jPanelWhiteLayout);
        jPanelWhiteLayout.setHorizontalGroup(
            jPanelWhiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelWhiteLayout.createSequentialGroup()
                .addGroup(jPanelWhiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelWhiteLayout.createSequentialGroup()
                        .addGap(400, 400, 400)
                        .addComponent(jLabelTitle))
                    .addGroup(jPanelWhiteLayout.createSequentialGroup()
                        .addGap(183, 183, 183)
                        .addGroup(jPanelWhiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanelWhiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanelWhiteLayout.createSequentialGroup()
                                .addComponent(jRadioButtonTeacher)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jRadioButtonAdmin))
                            .addComponent(jTextFieldEmail)
                            .addComponent(jPasswordFieldPassword)
                            .addComponent(jButtonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(291, Short.MAX_VALUE))
        );
        jPanelWhiteLayout.setVerticalGroup(
            jPanelWhiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelWhiteLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabelTitle)
                .addGap(74, 74, 74)
                .addGroup(jPanelWhiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelLogin)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanelWhiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPassword)
                    .addComponent(jPasswordFieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanelWhiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonTeacher)
                    .addComponent(jRadioButtonAdmin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jButtonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelWhite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelWhite, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoginActionPerformed
        // 1) read the email and password the user typed
        String email = jTextFieldEmail.getText();
        String password = new String(jPasswordFieldPassword.getPassword());

        // 2) make sure they chose either Admin or Teacher role
        if (!jRadioButtonAdmin.isSelected() && !jRadioButtonTeacher.isSelected()) {
            JOptionPane.showMessageDialog(this,
                    "Please select a role (Admin or Teacher).",
                    "Role Not Selected",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            // 3) connect to our gtirecords database
            String url = "jdbc:mysql://localhost:3306/gtirecords";
            String dbUser = "root";
            String dbPass = "root";
            Connection con = DriverManager.getConnection(url, dbUser, dbPass);

            // 4) SQL query to check if the login & password match
            //    - we look in the login table for a row where:
            //        login = ?  (the email the user entered)
            //      AND password = ?  (the password they entered)
            //    - if a row exists, we get back its credentials column ('A' or 'T')
            String sql = "SELECT credentials FROM login WHERE login=? AND password=?";
            PreparedStatement prest = con.prepareStatement(sql);
            prest.setString(1, email);
            prest.setString(2, password);

            // 5) run the query
            ResultSet rs = prest.executeQuery();

            if (rs.next()) {
                // 6) we found a matching row, read its credentials value
                String credentials = rs.getString("credentials");

                if (credentials.equals("A")) {
                    // 7) they have admin credentials
                    if (jRadioButtonAdmin.isSelected()) {
                        // correct role chosen -> go to admin panel
                        ChoiceAdmin adminPanel = new ChoiceAdmin();
                        adminPanel.setVisible(true);
                        dispose();
                    } else {
                        // they picked Teacher but have Admin creds
                        JOptionPane.showMessageDialog(this,
                                "You have entered admin credentials but selected teacher role.",
                                "Invalid Role Selection",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } else if (credentials.equals("T")) {
                    // 8) they have teacher credentials
                    if (jRadioButtonTeacher.isSelected()) {
                        // correct role chosen -> open TeacherMenu, pass email
                        TeacherMenu t = new TeacherMenu(email);
                        t.setVisible(true);
                        dispose();
                    } else {
                        // they picked Admin but have Teacher creds
                        JOptionPane.showMessageDialog(this,
                                "You are not authorized as an admin.",
                                "Unauthorized as an admin",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else {
                // 9) no matching row -> wrong email or password
                JOptionPane.showMessageDialog(this,
                        "Invalid email or password.",
                        "Login Failed",
                        JOptionPane.ERROR_MESSAGE);
            }

            // 10) clean up database resources
            rs.close();
            prest.close();
            con.close();

        } catch (SQLException ex) {
            // 11) show any connection or SQL error
            JOptionPane.showMessageDialog(this,
                    ex.getMessage(),
                    "Connection Error",
                    JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButtonLoginActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonLogin;
    private javax.swing.JLabel jLabelLogin;
    private javax.swing.JLabel jLabelPassword;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JPanel jPanelWhite;
    private javax.swing.JPasswordField jPasswordFieldPassword;
    private javax.swing.JRadioButton jRadioButtonAdmin;
    private javax.swing.JRadioButton jRadioButtonTeacher;
    private javax.swing.JTextField jTextFieldEmail;
    // End of variables declaration//GEN-END:variables
}
