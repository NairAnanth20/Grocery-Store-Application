/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package onlinegrocerystore.newpackage;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import com.sun.source.tree.ParenthesizedTree;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author naira
 */
public class UserAccount extends javax.swing.JFrame {

    /**
     * Creates new form UserAccount
     */
    public UserAccount() {
        initComponents();
        Connect();// Establish database connection
        fetch(); // Fetch products from database and display in jTable1
        fetchAddToCart();// Fetch products added to cart from database

        jTable1.addMouseListener(new MouseAdapter() {

            @Override
            // Add mouse click listener to jTable1
            public void mouseClicked(MouseEvent e) {
                // Get the selected row index
                int rowIndex = jTable1.getSelectedRow();
                if (rowIndex != -1) { // If a row is selected
                    // Retrieve data from the selected row
                    String productName = (String) jTable1.getValueAt(rowIndex, 1); // Assuming column 1 is product name
                    String productQty = (String) jTable1.getValueAt(rowIndex, 3); // Assuming column 3 is product quantity

                    // Set the retrieved data to the text fields
                    txtPname.setText(productName);
                    txtPqty.setText(productQty);
                }
            }
        });

    }

    // Method triggered when a row in jTable1 is clicked
    private void table1MouseClicked(java.awt.event.MouseEvent evt) {
        int row = jTable1.getSelectedRow();
        if (row != -1) {
            // Get the selected item's name and price
            String name = jTable1.getValueAt(row, 0).toString();
            String price = jTable1.getValueAt(row, 1).toString();

            // Display the name and price in text fields
            txtPname.setText(name);
            txtPqty.setText(price);
        }
    }

    Connection con;// Connection object for database connection
    PreparedStatement pst;// PreparedStatement for executing SQL queries
    ResultSet rs;// ResultSet for storing query results

    // Method to establish database connection
    public void Connect() {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            // If the driver class is not found, log the error
            Logger.getLogger(crud_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
        String dbUrl = "jdbc:mysql://localhost:3306/onlinegrocerystore";
        String username = "root";
        String password = "nair";
        try {
            // Attempt to establish a connection with the database
            con = DriverManager.getConnection(dbUrl, username, password);
        } catch (SQLException ex) {
            // If connection fails, log the error
            Logger.getLogger(crud_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void fetch() {
        try {
            int q;
            pst = con.prepareStatement("select * from product_tbl");// Prepare SQL query to fetch all records from product_tbl
            rs = pst.executeQuery(); // Execute the query and get the ResultSet
            ResultSetMetaData rss = (ResultSetMetaData) rs.getMetaData();// Get metadata about the ResultSet
            q = rss.getColumnCount();// Get the number of columns in the ResultSet

            DefaultTableModel df = (DefaultTableModel) jTable1.getModel();// Get the table model of jTable1
            df.setRowCount(0);// Clear existing rows in the table
            while (rs.next()) { // Iterate through each row in the ResultSet
                Vector v2 = new Vector();// Create a Vector to hold data for each row

                // Loop through each column and add its value to the Vector
                for (int a = 1; a <= q; a++) {
                    v2.add(rs.getString("id"));// Assuming column "id" is at index 0
                    v2.add(rs.getString("pname"));// Assuming column "pname" is at index 1
                    v2.add(rs.getString("price"));// Assuming column "price" is at index 2
                    v2.add(rs.getString("qty")); // Assuming column "qty" is at index 3
                }
                df.addRow(v2);// Add the Vector as a row to the table model
            }

        } catch (SQLException ex) {
            // Log any SQL exceptions
            Logger.getLogger(crud_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void fetchAddToCart() {
        try {
            int q;

            ResultSetMetaData rss = (ResultSetMetaData) rs.getMetaData();// Get metadata about the ResultSet
            q = rss.getColumnCount();// Get the number of columns in the ResultSet

            DefaultTableModel df = (DefaultTableModel) jTable2.getModel();// Get the table model of jTable2
            df.setRowCount(0);// Clear existing rows in the table
            while (rs.next()) {// Iterate through each row in the ResultSet
                Vector v2 = new Vector();// Create a Vector to hold data for each row

                // Loop through each column and add its value to the Vector
            
                for (int a = 1; a <= q; a++) {
                    v2.add(rs.getString("id"));// Assuming column "id" is at index 0
                    v2.add(rs.getString("pname"));// Assuming column "pname" is at index 1
                    v2.add(rs.getString("price"));// Assuming column "price" is at index 2
                    v2.add(rs.getString("qty"));// Assuming column "qty" is at index 3
                }
                df.addRow(v2);// Add the Vector as a row to the table model
            }

        } catch (SQLException ex) {
            // Log any SQL exceptions
            Logger.getLogger(crud_Form.class.getName()).log(Level.SEVERE, null, ex);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtPname = new javax.swing.JTextField();
        txtPqty = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnBuy = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Product Name:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Product Qty:");

        txtPname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPnameActionPerformed(evt);
            }
        });

        txtPqty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPqtyActionPerformed(evt);
            }
        });

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnBuy.setText("Buy");
        btnBuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuyActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAdd)
                .addGap(88, 88, 88)
                .addComponent(btnDelete)
                .addGap(70, 70, 70)
                .addComponent(btnBuy)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnBuy)
                    .addComponent(btnDelete))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Product Id", "Product Name", "Product Price", "Quantity"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel4.setText("Add Cart");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Product Name", "Quantity"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 675, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(307, 307, 307)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Total Price:");

        txtPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPriceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtPname)
                            .addComponent(txtPqty, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE))
                        .addGap(64, 64, 64)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 116, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtPname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPqty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(36, 36, 36)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPnameActionPerformed

    private void txtPqtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPqtyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPqtyActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
 
        String productName = txtPname.getText();
        String productQty = txtPqty.getText(); // Assuming txtPrice is your JTextField for the price

        // Add item to jTable2
        DefaultTableModel model2 = (DefaultTableModel) jTable2.getModel();
        model2.addRow(new Object[]{productName, productQty}); // Adding price to jTable2

        // Insert item into the database
        try {
            pst = con.prepareStatement("INSERT INTO cart_tbl (product_name, quantity) VALUES (?, ?)");
            pst.setString(1, productName);
            pst.setString(2, productQty);

            int rowsInserted = pst.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(this, "Item added to cart and database successfully");
                calc();

            } else {
                JOptionPane.showMessageDialog(this, "Failed to add item to cart and database");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserAccount.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "An error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int selectedRowIndex = jTable2.getSelectedRow();

        if (selectedRowIndex != -1) { // If a row is selected
            // Retrieve the product name and quantity from the selected row
            String productName = jTable2.getValueAt(selectedRowIndex, 0).toString(); // Assuming column 0 is product name
            int quantity = Integer.parseInt(jTable2.getValueAt(selectedRowIndex, 1).toString()); // Assuming column 1 is quantity

            try {
                // Prepare a SQL statement to delete the record from the cart table
                pst = con.prepareStatement("DELETE FROM cart_tbl WHERE product_name = ? AND quantity = ?");
                pst.setString(1, productName);
                pst.setInt(2, quantity);

                // Execute the SQL statement
                int rowsAffected = pst.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Record deleted from cart_tbl.");

                    // Remove the corresponding row from jTable2
                    DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
                    model.removeRow(selectedRowIndex);
                    
                } else {
                    System.out.println("Record not found in cart_tbl.");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "An error occurred while deleting the record from the database.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select an item to delete.", "No Item Selected", JOptionPane.WARNING_MESSAGE);
        }
        calc();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnBuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuyActionPerformed

        // Iterate through each row in the cart table (jTable2)
    DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
    for (int i = 0; i < model.getRowCount(); i++) {
        String productName = model.getValueAt(i, 0).toString(); // Get product name
        int quantity = Integer.parseInt(model.getValueAt(i, 1).toString()); // Get quantity

        try {
            // Retrieve the current quantity of the product from the database
            pst = con.prepareStatement("SELECT qty FROM product_tbl WHERE pname = ?");
            pst.setString(1, productName);
            ResultSet rs = pst.executeQuery();

            // Update the quantity in the database
            if (rs.next()) {
                int currentQuantity = rs.getInt("qty");
                int newQuantity = currentQuantity - quantity; // Deduct the quantity bought
                if (newQuantity >= 0) { // Ensure the quantity doesn't go negative
                    // Update the quantity in the database
                    pst = con.prepareStatement("UPDATE product_tbl SET qty = ? WHERE pname = ?");
                    pst.setInt(1, newQuantity);
                    pst.setString(2, productName);
                    pst.executeUpdate();
                } else {
                    // Show error message if the quantity is insufficient
                    JOptionPane.showMessageDialog(this, "Insufficient quantity available for " + productName, "Error", JOptionPane.ERROR_MESSAGE);
                    return; // Exit the method
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "An error occurred while updating product quantities in the database.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Exit the method
        }
    }

    // After successfully updating quantities, clear the cart
    model.setRowCount(0);

    // Show success message
    JOptionPane.showMessageDialog(this, "Order purchased Successfully.");
    fetch();
    
//        JOptionPane.showMessageDialog(this, "Order purchased Successfully.");
    }//GEN-LAST:event_btnBuyActionPerformed

    private void txtPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPriceActionPerformed

    }//GEN-LAST:event_txtPriceActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
        
         */

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserAccount().setVisible(true);
            }
        });

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UserAccount.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserAccount.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserAccount.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserAccount.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserAccount().setVisible(true);
            }
        });
    }

    private double calc() {
        double totalPrice = 0.0;// Initialize total price
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();// Get table model of jTable2
        int rowCount = model.getRowCount();// Get the number of rows in the table

        // Iterate through each row in the table
        for (int i = 0; i < rowCount; i++) {
            String productName = model.getValueAt(i, 0).toString(); // Assuming column 0 is product name
            int productQty = Integer.parseInt(model.getValueAt(i, 1).toString()); // Assuming column 1 is product quantity

            try {
                // Prepare and execute a SQL query to fetch the product price based on the product name
                pst = con.prepareStatement("SELECT price FROM product_tbl WHERE pname = ?");
                pst.setString(1, productName);
                ResultSet rs = pst.executeQuery();

                // Check if a price is retrieved
                if (rs.next()) {
                    double productPrice = rs.getDouble("price");
                    // Calculate total price for each product
                    totalPrice += (productPrice * productQty);
                }
            } catch (SQLException ex) {
                // Handle SQL exception
                ex.printStackTrace();
            }
        }

        // Set the total price in the txtPrice text field
        int totalPriceInt = (int) Math.round(totalPrice);
        txtPrice.setText(String.valueOf(totalPriceInt));

        return totalPrice;
    }
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBuy;
    private javax.swing.JButton btnDelete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField txtPname;
    private javax.swing.JTextField txtPqty;
    private javax.swing.JTextField txtPrice;
    // End of variables declaration//GEN-END:variables

}
