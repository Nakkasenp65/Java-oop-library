/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package testlibrary;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class TestingForm extends javax.swing.JFrame {

    public TestingForm() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dueDatePicker = new org.jdesktop.swingx.JXDatePicker();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        rentalDatePicker = new org.jdesktop.swingx.JXDatePicker();
        btnOK = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtPriceReceipt = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        dueDatePicker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dueDatePickerActionPerformed(evt);
            }
        });

        jLabel3.setText("Rental Date");

        jLabel5.setText("Due Date");

        rentalDatePicker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rentalDatePickerActionPerformed(evt);
            }
        });

        btnOK.setText("Confirm");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        txtPriceReceipt.setColumns(20);
        txtPriceReceipt.setRows(5);
        jScrollPane2.setViewportView(txtPriceReceipt);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnOK)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(rentalDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(31, 31, 31)
                                .addComponent(dueDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(328, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rentalDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dueDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnOK)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        // TODO add your handling code here:
//        User user = new User(0, "nakasen", "123", "user@gmail.com");
//        Ebook eb = new Ebook(0, "HP new BOOK", "JK ROW", "novel", 10);
//
//        Date rentalDateStr = rentalDatePicker.getDate();
//        LocalDate rentalDate = convertToLocalDateViaInstant(rentalDateStr);
//
//        Date dueDateStr = dueDatePicker.getDate();
//        LocalDate dueDate = convertToLocalDateViaInstant(dueDateStr);
//
//        Rent rent = new Rent(user, eb, rentalDate, dueDate);
//
//        System.out.println("THIS BELOW IS OBJECT VARIABLE");
//        int duration = (int) rent.calculateRentalDurationInDays();
//        System.out.println("Rental: " + rent.getRentalDate());
//        System.out.println("Due: " + rent.getDueDate());
//        System.out.println("Duration: " + duration);
//
//        System.out.println("\nTHIS BELOW UPLOAD TO DB");
//        String stringformatRentalDate = rentalDate + "";
//        String stringformatDueDate = dueDate + "";
//        System.out.println("RENTAL DATE: " + stringformatRentalDate);
//        System.out.println("DUE DATE: " + stringformatDueDate);
//
//        System.out.println("\nTHIS BELOW DOWNLOAD FROM DB");
//        rentalDate = LocalDate.parse(stringformatRentalDate);
//        dueDate = LocalDate.parse(stringformatDueDate);
//        Rent r2 = new Rent(user, eb, rentalDate, dueDate);
//        System.out.println("FINAL RENTAL DATE: " + rentalDate);
//        System.out.println("FINAL DUE DATE: " + dueDate);
//        System.out.println("FINAL DURATION: " + r2.calculateRentalDurationInDays());
//
//        System.out.println(r2.getRentReceiptDetails());


    }//GEN-LAST:event_btnOKActionPerformed

    Date dateRentalDate;
    LocalDate localRentalDate;
    Date dateDueDate;
    LocalDate localDueDate;
    String totalPrice;
    String strRentalDate;
    String strDueDate;

    private void rentalDatePickerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rentalDatePickerActionPerformed
        if (rentalDatePicker.getDate() == null) {
        } else {
            dateRentalDate = rentalDatePicker.getDate();
            localRentalDate = convertToLocalDateViaInstant(dateRentalDate);
            strRentalDate = localRentalDate + "";
        }
        if (rentalDatePicker.getDate() != null && dueDatePicker.getDate() != null) {
            txtPriceReceipt.setText(getDateDetails(strRentalDate, strDueDate));
        }
    }//GEN-LAST:event_rentalDatePickerActionPerformed

    private void dueDatePickerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dueDatePickerActionPerformed
        if (dueDatePicker.getDate() == null) {
        } else {
            dateDueDate = dueDatePicker.getDate();
            localDueDate = convertToLocalDateViaInstant(dateDueDate);
            strDueDate = localDueDate + "";
        }
        if (rentalDatePicker.getDate() != null && dueDatePicker.getDate() != null) {
            txtPriceReceipt.setText(getDateDetails(strRentalDate, strDueDate));
        }
    }//GEN-LAST:event_dueDatePickerActionPerformed

    public LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

    public String getDateDetails(String rentalDate, String dueDate) {
        String dateDetails = "";
        dateDetails += "Rental date: " + rentalDate + "\n";
        dateDetails += "Due date: " + dueDate + "\n";
        dateDetails += "Rent duration: " + getRentalDuration(localRentalDate, localDueDate) + "\n";

        return dateDetails;
    }

    public int getRentalDuration(LocalDate rentalDate, LocalDate dueDate) {
        int duration = (int) ChronoUnit.DAYS.between(rentalDate, dueDate);
        if (duration <= 0) {
            return 0;
        } else {
            return duration;
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TestingForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOK;
    private org.jdesktop.swingx.JXDatePicker dueDatePicker;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private org.jdesktop.swingx.JXDatePicker rentalDatePicker;
    private javax.swing.JTextArea txtPriceReceipt;
    // End of variables declaration//GEN-END:variables
}
