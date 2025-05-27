/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package my.FinalProject;

import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LiamBrady
 */
public class TeacherMenu extends javax.swing.JFrame {

    private final String teacherLogin;

    /**
     * Creates new form TeacherMenu
     */
    public TeacherMenu(String login) {
        initComponents();
        this.teacherLogin = login;

    }

    private TeacherMenu() {
        throw new UnsupportedOperationException(
                "You need to login first");
    }

    public String getTeacherLogin() {
        return teacherLogin;
    }

// showAuthorization: greets the teacher on login
    private void showAuthorization() {
        // SQL to get the teacher’s name and email from the teacher table
        String sql
                = "SELECT firstName, surname, email "
                + "FROM teacher "
                + "WHERE login = ?";
        try (
                // connect to the database
                Connection con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/gtirecords",
                        "root", "root"); PreparedStatement pst = con.prepareStatement(sql)) {
            // bind the login value
            pst.setString(1, teacherLogin);
            try (ResultSet rs = pst.executeQuery()) {
                // if we found a matching teacher
                if (rs.next()) {
                    String fn = rs.getString("firstName");
                    String sn = rs.getString("surname");
                    String em = rs.getString("email");
                    // show a welcome message
                    JOptionPane.showMessageDialog(
                            this,
                            "Authorized in the system as:\n"
                            + fn + " " + sn
                            + "\nEmail: " + em,
                            "Welcome",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                } else {
                    // no teacher with that login
                    JOptionPane.showMessageDialog(
                            this,
                            "No teacher record found for login:\n" + teacherLogin,
                            "Lookup failed",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        } catch (SQLException ex) {
            // show any database error
            JOptionPane.showMessageDialog(
                    this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE
            );
        }
    }

// loadStudentsForModule: fills the student table with all students in your module
    private void loadStudentsForModule() {
        // get the table model and clear old rows
        DefaultTableModel model = (DefaultTableModel) jTableStudent.getModel();
        model.setRowCount(0);

        // SQL to get each student’s info and their grades,
        // only for the module you teach
        String sql
                = "SELECT "
                + "  student.studentID, "
                + "  student.firstName, "
                + "  student.surname, "
                + "  course.courseName, "
                + "  classGroup.classGroupCode, "
                + "  module_assessment.assessment_1_marks, "
                + "  module_assessment.assessment_2_marks, "
                + "  module_assessment.exam_marks, "
                + "  module_assessment.award "
                + "FROM teacher_module "
                + "  INNER JOIN module_assessment "
                + "    ON teacher_module.moduleCode = module_assessment.moduleCode "
                + "  INNER JOIN student "
                + "    ON module_assessment.studentID = student.studentID "
                + "  INNER JOIN classGroup "
                + "    ON student.classGroupCode = classGroup.classGroupCode "
                + "  INNER JOIN course "
                + "    ON classGroup.courseCode = course.courseCode "
                + "WHERE teacher_module.login = ?";

        try (
                // connect and prepare
                Connection con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/gtirecords", "root", "root"); PreparedStatement pst = con.prepareStatement(sql)) {
            // bind your login to filter only your module
            pst.setString(1, teacherLogin);

            try (ResultSet rs = pst.executeQuery()) {
                // for each student row we get
                while (rs.next()) {
                    // add a row to the table model
                    model.addRow(new Object[]{
                        rs.getInt("studentID"),
                        rs.getString("firstName"),
                        rs.getString("surname"),
                        rs.getString("courseName"),
                        rs.getString("classGroupCode"),
                        rs.getInt("assessment_1_marks"),
                        rs.getInt("assessment_2_marks"),
                        rs.getInt("exam_marks"),
                        rs.getString("award")
                    });
                }
            }
        } catch (SQLException ex) {
            // show a friendly error if something goes wrong
            JOptionPane.showMessageDialog(
                    this, ex.getMessage()
            );
        }
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
        jTextFieldStudentID = new javax.swing.JTextField();
        jButtonSearch = new javax.swing.JButton();
        jLabelStudentID = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableStudent = new javax.swing.JTable();
        jButtonShowAll = new javax.swing.JButton();
        jButtonLogout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Teacher Menu");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jTextFieldStudentID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldStudentID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldStudentIDMouseClicked(evt);
            }
        });
        jTextFieldStudentID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldStudentIDKeyTyped(evt);
            }
        });

        jButtonSearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonSearch.setText("SEARCH");
        jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchActionPerformed(evt);
            }
        });

        jLabelStudentID.setText("Student ID:");

        jTableStudent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Student ID", "Name", "Surname", "Course", "Class", "A1 Marks", "A2 Marks", "Exam Marks", "Award"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableStudent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableStudentMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableStudent);

        jButtonShowAll.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonShowAll.setText("Show All Students");
        jButtonShowAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonShowAllActionPerformed(evt);
            }
        });

        jButtonLogout.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonLogout.setText("Logout");
        jButtonLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonLogout)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonShowAll))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelStudentID)
                                .addGap(44, 44, 44)
                                .addComponent(jTextFieldStudentID)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonSearch))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1141, Short.MAX_VALUE))))
                .addGap(39, 39, 39))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldStudentID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSearch)
                    .addComponent(jLabelStudentID))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonShowAll)
                    .addComponent(jButtonLogout))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldStudentIDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldStudentIDMouseClicked

    }//GEN-LAST:event_jTextFieldStudentIDMouseClicked

    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchActionPerformed
        // 1) get the text from the ID field
        String txt = jTextFieldStudentID.getText().trim();
        // 2) if empty, show warning and stop
        if (txt.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Please enter a Student ID to search for.",
                    "No ID Entered",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        int studentID;
        // 3) try to turn the text into a number
        try {
            studentID = Integer.parseInt(txt);
        } catch (NumberFormatException e) {
            // 4) if that fails, show error and stop
            JOptionPane.showMessageDialog(this,
                    "Invalid Student ID format.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        // 5) clear any old rows in the table
        DefaultTableModel model = (DefaultTableModel) jTableStudent.getModel();
        model.setRowCount(0);

        // 6) build the SQL to load just this student if you teach them
        String sql
                = "SELECT "
                + "  student.studentID, "
                + "  student.firstName, "
                + "  student.surname, "
                + "  course.courseName, "
                + "  classGroup.classGroupCode, "
                + "  module_assessment.assessment_1_marks, "
                + "  module_assessment.assessment_2_marks, "
                + "  module_assessment.exam_marks, "
                + "  module_assessment.award "
                + "FROM teacher_module "
                + "  INNER JOIN module_assessment "
                + "    ON teacher_module.moduleCode = module_assessment.moduleCode "
                + "  INNER JOIN student "
                + "    ON module_assessment.studentID = student.studentID "
                + "  INNER JOIN classGroup "
                + "    ON student.classGroupCode = classGroup.classGroupCode "
                + "  INNER JOIN course "
                + "    ON classGroup.courseCode = course.courseCode "
                + "WHERE teacher_module.login = ? "
                + "  AND student.studentID = ?";

        // 7) open connection and prepare statement
        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/gtirecords", "root", "root"); PreparedStatement pst = con.prepareStatement(sql)) {

            // 8) bind your login and the student ID
            pst.setString(1, teacherLogin);
            pst.setInt(2, studentID);

            // 9) run the query
            try (ResultSet rs = pst.executeQuery()) {
                // 10) if no result, you don’t teach that student
                if (!rs.next()) {
                    JOptionPane.showMessageDialog(this,
                            "You don’t teach a student with ID " + studentID + ".",
                            "Not Authorized",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }

                // 11) otherwise, add the one row into the table
                model.addRow(new Object[]{
                    rs.getInt("studentID"),
                    rs.getString("firstName"),
                    rs.getString("surname"),
                    rs.getString("courseName"),
                    rs.getString("classGroupCode"),
                    rs.getInt("assessment_1_marks"),
                    rs.getInt("assessment_2_marks"),
                    rs.getInt("exam_marks"),
                    rs.getString("award")
                });
            }
        } catch (SQLException ex) {
            // 12) if any DB error happens, show it
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_jButtonSearchActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        showAuthorization();
        loadStudentsForModule();
    }//GEN-LAST:event_formWindowOpened

    private void jButtonShowAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonShowAllActionPerformed
        loadStudentsForModule();
    }//GEN-LAST:event_jButtonShowAllActionPerformed

    private void jButtonLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogoutActionPerformed
        int response = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to log out?",
                "Loggin Out",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
        );

        if (response == JOptionPane.YES_OPTION) {
            Login f = new Login();
            f.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_jButtonLogoutActionPerformed

    private void jTableStudentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableStudentMouseClicked
        // only do something on double‐click
        if (evt.getClickCount() != 2) {
            return;
        }

        // find the clicked row
        int row = jTableStudent.getSelectedRow();
        if (row < 0) {
            return;
        }

        DefaultTableModel model = (DefaultTableModel) jTableStudent.getModel();
        int studentID = (Integer) model.getValueAt(row, 0);

        // ask user for new marks
        String a1Str = JOptionPane.showInputDialog(
                this,
                "Enter new A1 marks (0–30):",
                model.getValueAt(row, 5)
        );
        String a2Str = JOptionPane.showInputDialog(
                this,
                "Enter new A2 marks (0–30):",
                model.getValueAt(row, 6)
        );
        String examStr = JOptionPane.showInputDialog(
                this,
                "Enter new Exam marks (0–40):",
                model.getValueAt(row, 7)
        );
        // if user pressed Cancel, stop
        if (a1Str == null || a2Str == null || examStr == null) {
            return;
        }

        // make sure inputs are numbers
        if (!a1Str.matches("\\d+")
                || !a2Str.matches("\\d+")
                || !examStr.matches("\\d+")) {
            JOptionPane.showMessageDialog(
                    this,
                    "Marks must be whole numbers (no decimals or letters).",
                    "Invalid Input",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        // convert to int
        int a1 = Integer.parseInt(a1Str);
        int a2 = Integer.parseInt(a2Str);
        int exam = Integer.parseInt(examStr);

        // check ranges
        if (a1 < 0 || a1 > 30
                || a2 < 0 || a2 > 30
                || exam < 0 || exam > 40) {
            JOptionPane.showMessageDialog(
                    this,
                    "Out of range:\n"
                    + "A1 and A2 must be 0–30.\n"
                    + "Exam must be 0–40.",
                    "Invalid Marks",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        // compute total and award
        int total = a1 + a2 + exam;
        String award;
        if (total < 50) {
            award = "Fail";
        } else if (total < 65) {
            award = "Pass";
        } else if (total < 80) {
            award = "Merit";
        } else {
            award = "Distinction";
        }

        // update table display
        model.setValueAt(a1, row, 5);
        model.setValueAt(a2, row, 6);
        model.setValueAt(exam, row, 7);
        model.setValueAt(award, row, 8);

        // save changes to database
        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/gtirecords", "root", "root"); PreparedStatement pst = con.prepareStatement(
                        "UPDATE module_assessment "
                        + "SET assessment_1_marks = ?, assessment_2_marks = ?, "
                        + "    exam_marks = ?, award = ? "
                        + "WHERE studentID = ? "
                        + "  AND moduleCode = ("
                        + "      SELECT moduleCode "
                        + "        FROM teacher_module "
                        + "       WHERE login = ?)"
                )) {
            pst.setInt(1, a1);
            pst.setInt(2, a2);
            pst.setInt(3, exam);
            pst.setString(4, award);
            pst.setInt(5, studentID);
            pst.setString(6, teacherLogin);
            pst.executeUpdate();
        } catch (SQLException sqe) {
            // show error if save fails
            JOptionPane.showMessageDialog(
                    this, sqe.getMessage()
            );
        }
    }//GEN-LAST:event_jTableStudentMouseClicked

    private void jTextFieldStudentIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldStudentIDKeyTyped
        char key = evt.getKeyChar();
        String searchidtext = jTextFieldStudentID.getText();
        if (!(Character.isDigit(key)) || searchidtext.length() >= 3) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldStudentIDKeyTyped

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
            java.util.logging.Logger.getLogger(TeacherMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TeacherMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TeacherMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TeacherMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TeacherMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonLogout;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JButton jButtonShowAll;
    private javax.swing.JLabel jLabelStudentID;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableStudent;
    private javax.swing.JTextField jTextFieldStudentID;
    // End of variables declaration//GEN-END:variables
}
