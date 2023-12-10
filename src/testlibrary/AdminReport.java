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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nakka
 */
public class AdminReport extends javax.swing.JFrame {
    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    public AdminReport() {
        initComponents();
        con = DB_Connection.dbConnection();
        LoadProductNo();
    }
    
    public void LoadProductNo() {
        int c;
        double avenue = 0;
        
        String[] month = {
            "January",
            "February",
            "March",
            "April",
            "May",
            "June",
            "July",
            "August",
            "September",
            "October",
            "November",
            "December"
        };
        
        try {
            
            // Check if a specific month is selected
            if (cmbMonth.getSelectedIndex() > 0) {
                // Filter by month if a specific month is selected
                pst = con.prepareStatement("SELECT * FROM rent WHERE MONTH(rentalDate) = ?");
                pst.setInt(1, cmbMonth.getSelectedIndex());  // Index 1 corresponds to January
            } else {
                // If no specific month is selected, retrieve all rent
                pst = con.prepareStatement("SELECT * FROM rent");
            }
            
            rs = pst.executeQuery();
            
            java.sql.ResultSetMetaData rsd = rs.getMetaData();
            c = rsd.getColumnCount();
            
            DefaultTableModel d = (DefaultTableModel) resultTable.getModel();
            d.setRowCount(0);
            
            while (rs.next()) {
                Vector v2 = new Vector();
                
                for (int i = 1; i <= c; i++) {
                    v2.add(rs.getInt("rentID"));
                    v2.add(rs.getInt("userID"));
                    v2.add(rs.getInt("bookID"));
                    v2.add(rs.getString("rentalDate"));
                    v2.add(rs.getString("dueDate"));
                    v2.add(rs.getDouble("price"));
                    
                }
                avenue += rs.getDouble("price");
                d.addRow(v2);
            }
            
            txtAvenue.setText(avenue+"");
        } catch (SQLException ex) {
            Logger.getLogger(EbookRegisterPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    public void LoadProductNo() {
//        
//        int c;
//        String[] month = {
//            "January",
//            "February",
//            "March",
//            "April",
//            "May",
//            "June",
//            "July",
//            "August",
//            "September",
//            "October",
//            "November",
//            "December"
//        };
//
//        try {
//            pst = con.prepareStatement("SELECT * FROM rent");
//            rs = pst.executeQuery();
//
//            java.sql.ResultSetMetaData rsd = rs.getMetaData();
//            c = rsd.getColumnCount();
//
//            DefaultTableModel d = (DefaultTableModel) resultTable.getModel();
//            d.setRowCount(0);
//
//            while (rs.next()) {
//
//                Vector v2 = new Vector();
//
//                for (int i = 1; i <= c; i++) {
//                    v2.add(rs.getInt("rentID"));
//                    v2.add(rs.getInt("userID"));
//                    v2.add(rs.getInt("bookID"));
//                    v2.add(rs.getString("rentalDate"));
//                    v2.add(rs.getString("dueDate"));
//                    v2.add(rs.getDouble("price"));
//                }
//
//                d.addRow(v2);
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(EbookRegisterPage.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    
//    public void LoadProductNo(int selectedMonthIndex) {
//    int c;
//
//    try {
//        // Construct the SQL query based on the selected month
//        String query = "SELECT * FROM rent";
//        if (selectedMonthIndex > 0) {
//            // If a specific month is selected, add a WHERE clause to filter by month
//            query += " WHERE MONTH(rentalDate) = ?";
//        }
//
//        pst = con.prepareStatement(query);
//
//        // Set the month parameter if a specific month is selected
//        if (selectedMonthIndex > 0) {
//            pst.setInt(1, selectedMonthIndex);
//        }
//
//        rs = pst.executeQuery();
//
//        java.sql.ResultSetMetaData rsd = rs.getMetaData();
//        c = rsd.getColumnCount();
//
//        DefaultTableModel d = (DefaultTableModel) resultTable.getModel();
//        d.setRowCount(0);
//
//        while (rs.next()) {
//            Vector v2 = new Vector();
//
//            for (int i = 1; i <= c; i++) {
//                v2.add(rs.getInt("rentID"));
//                v2.add(rs.getInt("userID"));
//                v2.add(rs.getInt("bookID"));
//                v2.add(rs.getString("rentalDate"));
//                v2.add(rs.getString("dueDate"));
//                v2.add(rs.getDouble("price"));
//            }
//
//            d.addRow(v2);
//        }
//
//    } catch (SQLException ex) {
//        Logger.getLogger(EbookRegisterPage.class.getName()).log(Level.SEVERE, null, ex);
//    }
//}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        resultTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtAvenue = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cmbMonth = new javax.swing.JComboBox<>();
        btnResult = new javax.swing.JButton();
        btnMainMenu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        resultTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "rent ID", "User ID", "Book ID", "Rental Date", "Due Date", "Price"
            }
        ));
        jScrollPane1.setViewportView(resultTable);

        jLabel1.setText("Total Avenue");

        jLabel2.setText("Month");

        cmbMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));

        btnResult.setText("Result");
        btnResult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResultActionPerformed(evt);
            }
        });

        btnMainMenu.setText("Main menu");
        btnMainMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMainMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAvenue, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnMainMenu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnResult, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cmbMonth, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 806, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtAvenue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(cmbMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnResult)
                    .addComponent(btnMainMenu))
                .addContainerGap(111, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnResultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResultActionPerformed
//        int selectedMonthIndex = cmbMonth.getSelectedIndex();
        LoadProductNo();
    }//GEN-LAST:event_btnResultActionPerformed

    private void btnMainMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMainMenuActionPerformed
        // TODO add your handling code here:
        AdminMainMenuPage a = new AdminMainMenuPage();
        a.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnMainMenuActionPerformed

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
            java.util.logging.Logger.getLogger(AdminReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminReport().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMainMenu;
    private javax.swing.JButton btnResult;
    private javax.swing.JComboBox<String> cmbMonth;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable resultTable;
    private javax.swing.JTextField txtAvenue;
    // End of variables declaration//GEN-END:variables
}
