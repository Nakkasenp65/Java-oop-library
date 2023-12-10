/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package testlibrary;

import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class UsernameBrowsePage extends javax.swing.JFrame {

    User user;
    Ebook eb;

    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    int bookCount;
    

    public UsernameBrowsePage(User user) {
        initComponents();
        con = DB_Connection.dbConnection();
        LoadProductNo();
        this.user = user;
        txtUsername.setText(user.getUsername());
        bookCount = getCountBookFromDB(user);
    }

    public UsernameBrowsePage() {
    }
    
    public Ebook getBookFromDB(int bookID) {
        Ebook eb = null;

        try {
            int ID;
            String title, author, type, genre, subject;
            double price;

            pst = con.prepareStatement("select * from ebook where bookID=?");
            pst.setInt(1, bookID);
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
                        System.out.println("JOURNAL CHECK FLAG");
                        break;
                    case "BOOK":
                        eb = new Book(ID, title, author, genre);
                        System.out.println("BOOK CHECK FLAG");
                        break;
                    default:
                        eb = new Ebook(ID, title, author, genre, price);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return eb;
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
                        System.out.println("JOURNAL CHECK FLAG");
                        break;
                    case "BOOK":
                        eb = new Book(ID, title, author, genre);
                        System.out.println("BOOK CHECK FLAG");
                        break;
                    default:
                        eb = new Ebook(ID, title, author, genre, price);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return eb;
    }

    public void LoadProductNo(String title, String author) {

        int c;

        try {
            pst = con.prepareStatement("SELECT * FROM ebook WHERE bookName LIKE ? AND bookAuthor LIKE ?");
            pst.setString(1, "%" + title + "%");
            pst.setString(2, "%" + author + "%");
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

    public int getCountBookFromDB(User user) {
        int userID = user.getUserID();

        Ebook eb = null;
        try {
            pst = con.prepareStatement("SELECT COUNT(*) AS bookCount FROM rent WHERE userID = ? and isActive =?");
            pst.setInt(1, userID);
            pst.setBoolean(2, true);
            rs = pst.executeQuery();
            if (rs.next()) {
                if (rs.getString("bookCount").equals("0")) {
                    bookCount = 0;
                } else {
                    bookCount = Integer.parseInt(rs.getString("bookCount"));
                    System.out.println("book count: " + bookCount);
                }
            } else {
                System.out.println("Error no book from");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookCount;
    }

    public boolean isRentedSameBook(User user, Ebook eb){
        boolean flag = false;
        try {
            int bookID = eb.getBookID();
            pst = con.prepareStatement("SELECT * FROM rent WHERE userID = ? and bookID =?");
            pst.setInt(1, user.getUserID());
            pst.setInt(2, eb.getBookID());
            rs = pst.executeQuery();
            if (rs.next()) {
//                int rentbookID = rs.getInt("bookID");
                Ebook renteb = getBookFromDB(bookID);
                String bookName = rs.getString("bookName");
                String rentBook = eb.getBookName();
                if (bookName.equalsIgnoreCase(rentBook)) {
                    flag = true;
                } else {
                    flag = false;
                }
            } else {
                System.out.println("Error CHECK BOOK SAME");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btnResult = new javax.swing.JButton();
        txtUsername = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultTable = new javax.swing.JTable();
        btnRent = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtBookName = new javax.swing.JTextField();
        txtAuthor = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtSelectedBook = new javax.swing.JTextArea();
        btnMyBook = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Selected book:");

        btnResult.setForeground(new java.awt.Color(0, 0, 0));
        btnResult.setText("Result");
        btnResult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResultActionPerformed(evt);
            }
        });

        txtUsername.setEditable(false);
        txtUsername.setBackground(new java.awt.Color(0, 0, 0));
        txtUsername.setForeground(new java.awt.Color(255, 255, 255));
        txtUsername.setToolTipText("username");
        txtUsername.setCaretColor(new java.awt.Color(0, 0, 0));
        txtUsername.setFocusable(false);
        txtUsername.setRequestFocusEnabled(false);

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
        btnRent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRentActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Book name");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Author");

        txtSelectedBook.setEditable(false);
        txtSelectedBook.setColumns(20);
        txtSelectedBook.setRows(5);
        jScrollPane2.setViewportView(txtSelectedBook);

        btnMyBook.setForeground(new java.awt.Color(0, 0, 0));
        btnMyBook.setText("myBook");
        btnMyBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMyBookActionPerformed(evt);
            }
        });

        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Log out");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Username");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMyBook)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 761, Short.MAX_VALUE)))
                .addGap(32, 32, 32))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(btnMyBook, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtUsername, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRent))
                    .addComponent(jScrollPane1))
                .addGap(32, 32, 32))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnMyBook, jButton1});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnResultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResultActionPerformed
        String title = txtBookName.getText();
        String author = txtAuthor.getText();
        LoadProductNo(title, author);
    }//GEN-LAST:event_btnResultActionPerformed

    private void btnRentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRentActionPerformed
        // TODO add your handling code here:
        if (txtSelectedBook.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please select any book",
                    "Notification", JOptionPane.OK_OPTION);
        } else if (bookCount >= 5) {
            JOptionPane.showMessageDialog(null, "You already reach 5 book limit");
        } else if(isRentedSameBook(user,eb)){
            JOptionPane.showMessageDialog(null, "You already have this book in rent");
        }
        
        else {
            PayPage p = new PayPage(user, eb);
            p.setVisible(true);
            setVisible(false);
        }

    }//GEN-LAST:event_btnRentActionPerformed

    private void resultTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resultTableMouseClicked
        // TODO add your handling code here:
        DefaultTableModel d1 = (DefaultTableModel) resultTable.getModel();
        int selectIndex = resultTable.getSelectedRow();
        int id = Integer.parseInt(d1.getValueAt(selectIndex, 0).toString());
        String bookName = d1.getValueAt(selectIndex, 1).toString();
        String author = d1.getValueAt(selectIndex, 2).toString();
        String genre = d1.getValueAt(selectIndex, 3).toString();;
        String subject = d1.getValueAt(selectIndex, 4).toString();;
        String type = d1.getValueAt(selectIndex, 5).toString();;
        String price = d1.getValueAt(selectIndex, 6).toString();;

        eb = getBookFromDB(bookName);

        txtSelectedBook.setText(eb.getBookDetails());
    }//GEN-LAST:event_resultTableMouseClicked

    private void btnMyBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMyBookActionPerformed
        MyBookPage mbp = new MyBookPage(user);
        mbp.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnMyBookActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        BrowsePage bp = new BrowsePage();
        bp.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(UsernameBrowsePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UsernameBrowsePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UsernameBrowsePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UsernameBrowsePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UsernameBrowsePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMyBook;
    private javax.swing.JButton btnRent;
    private javax.swing.JButton btnResult;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable resultTable;
    private javax.swing.JTextField txtAuthor;
    private javax.swing.JTextField txtBookName;
    private javax.swing.JTextArea txtSelectedBook;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
