/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package testlibrary;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.table.DefaultTableModel;

public class MyBookPage extends javax.swing.JFrame {

    //DATABASE
    Connection con;
    PreparedStatement pst;
    ResultSet rs, rc;
    ResultSet rm;
    ArrayList<Integer> showBookID = new ArrayList<Integer>();

    //OBJECT
    Ebook eb;
    User user;
    Rent r;

    public MyBookPage() {
        initComponents();
        con = DB_Connection.dbConnection();
        user = new User(000004, "nakasen", "123", "nakasen@gmail.com");
        txtUsername.setText(user.getUsername());
        txtEmailAddress.setText(user.getEmailAddress());
        LoadProductNo();

    }

    public MyBookPage(User user) {
        this.user = user;
        initComponents();
        con = DB_Connection.dbConnection();
        txtUsername.setText(user.getUsername());
        txtEmailAddress.setText(user.getEmailAddress());
        LoadProductNo();
    }

    public void LoadProductNo() {
        DefaultTableModel d = (DefaultTableModel) resultTable.getModel();
        d.setRowCount(0);

        try {
            pst = con.prepareStatement("SELECT bookID FROM rent WHERE userID = ? AND isActive = true");
            pst.setInt(1, user.getUserID());
            rs = pst.executeQuery();

            while (rs.next()) {
                int bookID = rs.getInt("bookID");

                // Use a single PreparedStatement for the second query
                pst = con.prepareStatement("SELECT * FROM ebook WHERE bookID = ?");
                pst.setInt(1, bookID);
                rm = pst.executeQuery();

                while (rm.next()) {
                    Vector<Object> v2 = new Vector<>();
                    v2.add(rm.getInt("bookID"));
                    v2.add(rm.getString("bookName"));
                    v2.add(rm.getString("bookAuthor"));
                    v2.add(rm.getString("bookType"));
                    v2.add(rm.getString("genre"));
                    v2.add(rm.getString("subject"));
                    v2.add(rm.getDouble("price"));

                    d.addRow(v2);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(EbookRegisterPage.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Close resources (PreparedStatement and ResultSet) in a finally block
            // to ensure they are closed even if an exception occurs
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rm != null) {
                    rm.close();
                }
            } catch (SQLException e) {
                e.printStackTrace(); // Handle or log the exception as needed
            }
        }
    }

    public String getGenPasswordForBook(Ebook eb) {
        String genPassword = null;

        try {
            pst = con.prepareStatement("SELECT genPassword FROM rent WHERE bookID = ? AND isActive = true");
            pst.setInt(1, eb.getBookID());
            rs = pst.executeQuery();

            if (rs.next()) {
                genPassword = rs.getString("genPassword");
            } else {
                System.out.println("No matching record found for book with bookID: " + eb.getBookID());
            }
        } catch (SQLException ex) {
            Logger.getLogger(EbookRegisterPage.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Close resources (PreparedStatement and ResultSet) in a finally block
            // to ensure they are closed even if an exception occurs
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException e) {
                e.printStackTrace(); // Handle or log the exception as needed
            }
        }

        return genPassword;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtEmailAddress = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtSelectedBook = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        btnSend = new javax.swing.JButton();
        txtAccessUsername = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnRead = new javax.swing.JButton();
        btnBrowsePage = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Username");

        txtUsername.setEditable(false);
        txtUsername.setFocusable(false);
        txtUsername.setRequestFocusEnabled(false);

        jLabel2.setText("Email Address");

        txtEmailAddress.setEditable(false);
        txtEmailAddress.setFocusable(false);
        txtEmailAddress.setRequestFocusEnabled(false);

        resultTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Title", "Author", "Type", "Genre", "Subject"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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

        txtSelectedBook.setEditable(false);
        txtSelectedBook.setColumns(20);
        txtSelectedBook.setRows(5);
        txtSelectedBook.setFocusable(false);
        txtSelectedBook.setRequestFocusEnabled(false);
        jScrollPane2.setViewportView(txtSelectedBook);

        jLabel4.setText("Selected book:");

        btnSend.setText("Send this book");
        btnSend.setFocusable(false);
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        jLabel3.setText("Username");

        btnRead.setText("Read");
        btnRead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReadActionPerformed(evt);
            }
        });

        btnBrowsePage.setText("Browse Page");
        btnBrowsePage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowsePageActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtEmailAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBrowsePage)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(btnRead)
                        .addComponent(btnSend)
                        .addComponent(txtAccessUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)))
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBrowsePage)
                        .addGap(52, 52, 52)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRead)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAccessUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSend))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtEmailAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1)))
                .addGap(32, 32, 32))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBrowsePageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowsePageActionPerformed
        UsernameBrowsePage ubp = new UsernameBrowsePage(user);
        ubp.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnBrowsePageActionPerformed

    public User getUserFromDB(int userID) {
        User user = null;
        try {
            pst = con.prepareStatement("select * from register where id=?");
            pst.setInt(1, userID);
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

    public User getUserFromDB(String username) {
        User user = null;
        try {
            pst = con.prepareStatement("select * from register where username=?");
            pst.setString(1, username);
            rs = pst.executeQuery();

            if (rs.next()) {

                user = new User(
                        rs.getInt("id"), // Adjust field names and types based on your schema
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("emailAddress"),
                        rs.getString("role")
                );
            }

        } catch (Exception e) {

        }

        return user;
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

    public Rent getRentFromDB(int userID, int bookID) {
        Rent rent = null;
        try {
            pst = con.prepareStatement("SELECT * FROM rent WHERE userID = ? AND bookID = ?");

            pst.setInt(1, userID);
            pst.setInt(2, bookID);

            rc = pst.executeQuery();

            if (rc.next()) {
                int accessUserID = rc.getInt("userID");
                User user = getUserFromDB(accessUserID);

                int accessEbookID = rc.getInt("bookID");
                Ebook eb = getBookFromDB(accessEbookID);

                String rentalDate = rc.getString("rentalDate");
                LocalDate localRentalDate = LocalDate.parse(rentalDate);

                String dueDate = rc.getString("dueDate");
                LocalDate localDueDate = LocalDate.parse(dueDate);

                Double price = rc.getDouble("price");

                String dbPassword = rc.getString("genPassword");

                rent = new Rent(user, eb, localRentalDate, localDueDate, price, dbPassword);

            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle or log the exception as needed
        } finally {
            // Close resources (PreparedStatement and ResultSet) in a finally block
            // to ensure they are closed even if an exception occurs
            try {
                if (rc != null) {
                    rc.close();
                }
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException e) {
                e.printStackTrace(); // Handle or log the exception as needed
            }
        }
        return rent;
    }

    public void uploadRentToDB(Rent rent) {
        try {

            pst = con.prepareStatement("INSERT INTO rent (userID,bookID,rentalDate,dueDate,price,genPassword,isActive) VALUES (?,?,?,?,?,?,?)");
            pst.setInt(1, rent.getUser().getUserID());
            pst.setInt(2, rent.getBook().getBookID());
            pst.setString(3, rent.getRentalDate()+"");
            pst.setString(4, rent.getDueDate()+"");
            pst.setDouble(5, rent.getRentPrice());
            pst.setString(6, rent.getGenPassword());
            pst.setBoolean(7, true);

            int k = pst.executeUpdate();

            if (k == 1) {
                JOptionPane.showMessageDialog(this, "Rent Success!");
            } else {
                JOptionPane.showMessageDialog(this, "Rent failed, please try again!!!");
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserRegisterPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateFalseStatusToDB(Rent rent) {
    try {
        pst = con.prepareStatement("UPDATE rent SET isActive = ? WHERE userID = ? AND bookID = ?");
        pst.setBoolean(1, false);
        pst.setInt(2, rent.getUser().getUserID());
        pst.setInt(3, rent.getBook().getBookID());

        // Execute the update statement
        int rowsAffected = pst.executeUpdate();

        if (rowsAffected > 0) {
            System.out.println("Update successful. Rows affected: " + rowsAffected);
        } else {
            System.out.println("No rows were updated. Check your conditions.");
        }
    } catch (SQLException ex) {
        Logger.getLogger(UserRegisterPage.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        // Close resources (PreparedStatement) in a finally block
        // to ensure they are closed even if an exception occurs
        try {
            if (pst != null) {
                pst.close();
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle or log the exception as needed
        }
    }
}
    
//    public void updatefalseStatusToDB(Rent rent){
//        try{
//            pst = con.prepareCall("UPDATE rent isActive=? where userID = ? and bookID = ?");
//            pst.setBoolean(1, false );
//            pst.setInt(2, rent.getUser().getUserID());
//            pst.setInt(3, rent.getBook().getBookID());
//        } catch (SQLException ex) {
//            Logger.getLogger(UserRegisterPage.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//    }

    private void LoadProductNo(User user) {

    }

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
        /* 
        0. CHECK IF THE USERNAME MATCH ANY OR IS EMPTY
        1. GET USER FROM DB BY STRING USERNAME
        1. THE BOOK IS ALREADY ASSIGN FROM CLICK
        2. GET THE RENT FROM DB INORDER TO DUPE
        2. NEW RENT() FOR THE USERNAME THAT IS IN THE INPUT
        3. UPDATE THE OLD RENT TO FALSE ISACTIVE
        
         */

        String username = null;
        User receiver;
        if (txtAccessUsername.getText().equals("")) {
        } else {
            receiver = getUserFromDB(txtAccessUsername.getText());
            if (receiver == null) {
                JOptionPane.showMessageDialog(null, "Username not found");
            } else {
                /* EBOOK IS ASSIGN BY CLICK */
                //REVEIVER DONE
                Rent proRent = getRentFromDB(user.getUserID(), eb.getBookID());
                Rent dupeRent = new Rent(receiver, eb, proRent.getRentalDate(), proRent.getDueDate(), proRent.getRentPrice());
                updateFalseStatusToDB(proRent);
                uploadRentToDB(dupeRent);
                LoadProductNo();
            }
        }
        

    }//GEN-LAST:event_btnSendActionPerformed

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

        eb = getBookFromDB(id);
        System.out.println("STATUS OK : BOOK ASSIGN FLAG");
        String genPass = getGenPasswordForBook(eb);
        txtSelectedBook.setText("Title: " + bookName + "\n"
                + "Author: " + author + "\n"
                + "Genre: " + genre + "\n"
                + "\nPassword: " + genPass + "\n");
    }//GEN-LAST:event_resultTableMouseClicked

    private void btnReadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReadActionPerformed
        /*
        1. CLICK
        2. SHOW AN INPUT DIALOGUE
        3. CHECK PASSWORD OF THIS GUI ACCESS
        4. SHOW SUCCESS DIALOGUE
         */

        Rent rent = getRentFromDB(user.getUserID(), eb.getBookID());
        String dbPassword = rent.getGenPassword();
        System.out.println("password: " + dbPassword);
        String ipPassword = JOptionPane.showInputDialog("Enter book password");
        if (ipPassword.isEmpty()) {

        } else {
            if ((!ipPassword.equals(dbPassword))) {
                JOptionPane.showMessageDialog(null, "Wrong password");
            } else {
                JOptionPane.showMessageDialog(null, "Read Book success");
            }
        }


    }//GEN-LAST:event_btnReadActionPerformed

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
            java.util.logging.Logger.getLogger(MyBookPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MyBookPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MyBookPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MyBookPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MyBookPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBrowsePage;
    private javax.swing.JButton btnRead;
    private javax.swing.JButton btnSend;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable resultTable;
    private javax.swing.JTextField txtAccessUsername;
    private javax.swing.JTextField txtEmailAddress;
    private javax.swing.JTextArea txtSelectedBook;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
