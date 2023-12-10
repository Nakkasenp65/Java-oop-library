/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package testlibrary;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nakka
 */
public class BrowsePage extends javax.swing.JFrame {

    /*
     * Select the data from Ebook table to show all ebook
     * ID,Name,Author,genre,subject
     * when click the item inside the resultTable
     * set the txtSelectedBook to the book detail
     */
    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    public BrowsePage() {
        initComponents();
        con = DB_Connection.dbConnection();
        LoadProductNo();
    }
    
    public void LoadProductNo(String title, String author) {

        int c;

        try {
            pst = con.prepareStatement("SELECT * FROM ebook WHERE bookName LIKE ? AND bookAuthor LIKE ?");
            pst.setString(1,"%" + title + "%");
            pst.setString(2,"%" + author + "%" );
            rs = pst.executeQuery();

            java.sql.ResultSetMetaData rsd = rs.getMetaData();
            c = rsd.getColumnCount();

            DefaultTableModel d = (DefaultTableModel) resultTable.getModel();
            d.setRowCount(0);

            while (rs.next()) {

                Vector v2 = new Vector();

                for (int i = 1; i <= c; i++) {
                    v2.add(rs.getString("bookID"));
                    v2.add(rs.getString("bookName"));
                    v2.add(rs.getString("bookAuthor"));
                    v2.add(rs.getString("bookType"));
                    v2.add(rs.getString("genre"));
                    v2.add(rs.getString("subject"));
                    v2.add(rs.getDouble("price"));
                }

                d.addRow(v2);
            }

        } catch (SQLException ex) {
            Logger.getLogger(EbookRegisterPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void LoadProductNo() {

        int c;

        try {
            pst = con.prepareStatement("SELECT * FROM ebook");
            rs = pst.executeQuery();

            java.sql.ResultSetMetaData rsd = rs.getMetaData();
            c = rsd.getColumnCount();

            DefaultTableModel d = (DefaultTableModel) resultTable.getModel();
            d.setRowCount(0);

            while (rs.next()) {

                Vector v2 = new Vector();

                for (int i = 1; i <= c; i++) {
                    v2.add(rs.getString("bookID"));
                    v2.add(rs.getString("bookName"));
                    v2.add(rs.getString("bookAuthor"));
                    v2.add(rs.getString("bookType"));
                    v2.add(rs.getString("genre"));
                    v2.add(rs.getString("subject"));
                    v2.add(rs.getDouble("price"));
                }

                d.addRow(v2);
            }

        } catch (SQLException ex) {
            Logger.getLogger(EbookRegisterPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultTable = new javax.swing.JTable();
        btnRent = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtBookName = new javax.swing.JTextField();
        txtAuthor = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtSelectedBook = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        btnResult = new javax.swing.JButton();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JTextField();
        btnLogin = new javax.swing.JButton();
        btnRegister = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));

        resultTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Title", "Author", "Type", "Genre", "Subject", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        resultTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resultTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(resultTable);

        btnRent.setForeground(new java.awt.Color(0, 0, 0));
        btnRent.setText("Rent this book");
        btnRent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRentMouseClicked(evt);
            }
        });
        btnRent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRentActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Book name");

        txtBookName.setForeground(new java.awt.Color(0, 0, 0));

        txtAuthor.setForeground(new java.awt.Color(0, 0, 0));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Author");

        jScrollPane2.setForeground(new java.awt.Color(255, 255, 255));

        txtSelectedBook.setEditable(false);
        txtSelectedBook.setColumns(20);
        txtSelectedBook.setRows(5);
        jScrollPane2.setViewportView(txtSelectedBook);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Selected book:");

        btnResult.setForeground(new java.awt.Color(0, 0, 0));
        btnResult.setText("Result");
        btnResult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResultActionPerformed(evt);
            }
        });

        txtUsername.setForeground(new java.awt.Color(0, 0, 0));
        txtUsername.setToolTipText("username");

        txtPassword.setForeground(new java.awt.Color(0, 0, 0));

        btnLogin.setForeground(new java.awt.Color(0, 0, 0));
        btnLogin.setText("LOGIN");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        btnRegister.setForeground(new java.awt.Color(0, 0, 0));
        btnRegister.setText("REGISTER");
        btnRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegisterMouseClicked(evt);
            }
        });
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Usrname");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Password");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(799, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRegister)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel1)
                                .addComponent(txtBookName)
                                .addComponent(txtAuthor)
                                .addComponent(jLabel2)
                                .addComponent(btnRent)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4)
                            .addComponent(btnResult))
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPane1)))
                .addGap(32, 32, 32))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel3, jLabel5});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnLogin, btnRegister});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(btnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBookName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnResult)
                        .addGap(54, 54, 54)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRent))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnLogin, btnRegister, txtPassword, txtUsername});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegisterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegisterMouseClicked

    }//GEN-LAST:event_btnRegisterMouseClicked

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        UserRegisterPage urp = new UserRegisterPage();
        urp.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void btnRentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRentMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRentMouseClicked

    private void resultTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resultTableMouseClicked

        DefaultTableModel d1 = (DefaultTableModel) resultTable.getModel();
        int selectIndex = resultTable.getSelectedRow();
        int id = Integer.parseInt(d1.getValueAt(selectIndex, 0).toString());
        String bookName = d1.getValueAt(selectIndex, 1).toString();
        String author = d1.getValueAt(selectIndex, 2).toString();
        String genre = d1.getValueAt(selectIndex, 3).toString();;
        String subject = d1.getValueAt(selectIndex, 4).toString();;
        String type = d1.getValueAt(selectIndex, 5).toString();;
        String price = d1.getValueAt(selectIndex, 6).toString();;

        Ebook eb = getBookFromDB(bookName);

        txtSelectedBook.setText(eb.getBookDetails());
    }//GEN-LAST:event_resultTableMouseClicked

    private void btnRentActionPerformed(java.awt.event.ActionEvent evt) {
        JOptionPane.showMessageDialog(rootPane, "Please register first",
                "Notification", JOptionPane.OK_OPTION);
    }

    private void btnResultActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnResultActionPerformed
        String title = txtBookName.getText();
        String author = txtAuthor.getText();
        LoadProductNo(title, author);
    }

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnResultActionPerformed
        // TODO add your handling code here:
        String username = txtUsername.getText();
        String password = txtPassword.getText();
//        String option = comboRole.getSelectedItem().toString();
        User user;

        if (username.equals("") || password.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Some Fields are empty", "Error", 1);
        } else {
//            try {
//
//                pst = con.prepareStatement("select * from register where username=? and password=?");
//                pst.setString(1, username);
//                pst.setString(2, password);
//                rs = pst.executeQuery();
//
//                if (rs.next()) {
//
//                    String s1 = rs.getString("role");
//                    String un = rs.getString("username");
//                    user = getUserFromDB(un);
//                    System.out.println(user.getUserDetails());
//
//                    if (option.equalsIgnoreCase("Admin") && s1.equalsIgnoreCase("admin")) {
//                        AdminMainMenuPage ad = new AdminMainMenuPage();
//                        ad.setVisible(true);
//                        setVisible(false);
//                    } else if (option.equalsIgnoreCase("User") && s1.equalsIgnoreCase("user")) {
//                        UsernameBrowsePage ubp = new UsernameBrowsePage(user);
//                        ubp.setVisible(true);
//                        setVisible(false);
//                    }
//                } else {
//                    JOptionPane.showMessageDialog(rootPane, "Username or Password Not Match", "Login Error", 1);
//                }
//
//            } catch (Exception ex) {
//                System.out.println("" + ex);
//            }
                boolean isMatch = isMatch = loginCheck(username, password);
                if(!isMatch){
                    JOptionPane.showMessageDialog(null, "Wrong password",
                "Notification", JOptionPane.ERROR_MESSAGE);
                } else {
                    user = getUserFromDB(username);
                String role = user.getRole().toUpperCase();
                
                switch(role){
                    case "ADMIN":
                        AdminMainMenuPage admin = new AdminMainMenuPage();
                        admin.setVisible(true);
                        dispose();
                        break;
                    case "USER":
                        UsernameBrowsePage up = new UsernameBrowsePage(user);
                        up.setVisible(true);
                        dispose();
                        break;
                    default: System.out.println("LOGIN SWITCH ROLE ERROR");
                }
                }
                

        }
    }// GEN-LAST:event_btnResultActionPerformed.

    private boolean loginCheck(String username, String password){
        User user = getUserFromDB(username);
        String dbPassword = user.getPassword();
        String role = user.getRole();
        if(!password.equals(dbPassword)){
            return false;
        } else {
            return true;
        }
        
    }
    
    /**
     * @param args the command line arguments
     */
    public User getUserFromDB(String username) {
        User user = null;
        try {
            pst = con.prepareStatement("select * from register where username=?");
            pst.setString(1, username);
            rs = pst.executeQuery();

            if (rs.next()) {
                // Assuming you have a User class with appropriate constructors
                user = new User(
                        rs.getInt("id"), // Adjust field names and types based on your schema
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("emailAddress"),
                        rs.getString("role")
                // Add more fields as needed
                );
            }

        } catch (Exception e) {

        }

        return user;
    }

    public Ebook getBookFromDB(String bookName) {

        Ebook eb = null;

        try {

            int ID;
            String title, author, type, genre, subject;
            double price;
            pst = con.prepareStatement("select * from ebook where bookName=?");
            pst.setString(1, bookName);
            rs = pst.executeQuery();

            if (rs.next()) {
                ID = rs.getInt("bookID");
                title = rs.getString("bookName");
                author = rs.getString("bookAuthor");
                type = rs.getString("bookType").toUpperCase();
                genre = rs.getString("genre");
                subject = rs.getString("subject");
                price = rs.getDouble("price");
                switch (type) {
                    case "JOURNAL":
                        eb = new Journal(ID, title, author, subject);
                        break;
                    case "BOOK":
                        eb = new Book(ID, title, author, genre);
                        break;
                    default:
                        eb = new Ebook(ID, title, author, genre, price);
                }
            }
        } catch (Exception e) {

        }

        return eb;
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
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
            java.util.logging.Logger.getLogger(BrowsePage.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BrowsePage.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BrowsePage.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BrowsePage.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BrowsePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnRegister;
    private javax.swing.JButton btnRent;
    private javax.swing.JButton btnResult;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable resultTable;
    private javax.swing.JTextField txtAuthor;
    private javax.swing.JTextField txtBookName;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextArea txtSelectedBook;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
