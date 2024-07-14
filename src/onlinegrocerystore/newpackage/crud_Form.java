package onlinegrocerystore.newpackage;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author ayush
 */


// Import necessary packages
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import com.sun.source.tree.ParenthesizedTree;
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
import javax.swing.table.DefaultTableModel;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;


// Define the class
public final class crud_Form extends javax.swing.JFrame {
    
    // Constructor
    public crud_Form() throws ClassNotFoundException, SQLException {
        initComponents(); // Call this method to initialize components created in NetBeans GUI builder
        Connect(); // Call Connect() method to establish database connection
        LoadProductNo();// Call LoadProductNo() method to load product numbers from the database
        fetch();// Call fetch() method to fetch data from the database and display it in the form
    }
     // Declare variables for database connection
    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    // Method to establish database connection
    public void Connect() {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            // Handle ClassNotFoundException
            Logger.getLogger(crud_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Define database URL, username, and password
        String dbUrl = "jdbc:mysql://localhost:3306/onlinegrocerystore";
//        jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL
        String username = "root";
        String password = "nair";
        try {
            // Establish connection with the database
            con = DriverManager.getConnection(dbUrl, username, password);
        } catch (SQLException ex) {
            // Handle SQLException
            Logger.getLogger(crud_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // Method to load product IDs into a combo box
    public void LoadProductNo() {
        try {
            // Prepared SQL query to select product IDs from the database
            pst = con.prepareStatement("select id from product_tbl");
            rs = pst.executeQuery(); // Execute the query
            txtPid.removeAllItems(); // Remove all existing items from the combo box
            // Iterate through the result set and add each product ID to the combo box
            while (rs.next()) {
                txtPid.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(crud_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Method to fetch data from the database and display it in a table
    private void fetch() {
        try {
            int q;
            // Prepare SQL query to select all columns from product_tbl
            pst = con.prepareStatement("select * from product_tbl");
            rs = pst.executeQuery();// Execute the query
            ResultSetMetaData rss = (ResultSetMetaData) rs.getMetaData(); // Get metadata about the result set
            q = rss.getColumnCount();// Get the number of columns in the result set

            // Get the table model and reset row count to 0
            DefaultTableModel df = (DefaultTableModel) jTable1.getModel();
            df.setRowCount(0);
            while (rs.next()) {
                Vector v2 = new Vector();
                
                // Add data from each column to the vector
                for (int a = 1; a <= q; a++) {
                    v2.add(rs.getString("id"));
                    v2.add(rs.getString("pname"));
                    v2.add(rs.getString("price"));
                    v2.add(rs.getString("qty"));
                }
                df.addRow(v2);// Add the vector as a row in the table
            }

        } catch (SQLException ex) {
            Logger.getLogger(crud_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtPname = new javax.swing.JTextField();
        txtPprice = new javax.swing.JTextField();
        txtPqty = new javax.swing.JTextField();
        txtPid = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        BtnSearch = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Product Name:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Product Price");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Product Qty:");

        txtPname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPnameActionPerformed(evt);
            }
        });

        txtPprice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPpriceActionPerformed(evt);
            }
        });

        txtPqty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPqtyActionPerformed(evt);
            }
        });

        txtPid.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        txtPid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPidActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Product Id:");

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUpdate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        BtnSearch.setText("Search");
        BtnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSearchActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 657, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtPprice)
                            .addComponent(txtPname)
                            .addComponent(txtPqty, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPid, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(BtnSearch))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 50, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtPname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPprice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnSearch))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPqty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(104, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 810, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 45, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 46, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 651, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPnameActionPerformed

    private void txtPpriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPpriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPpriceActionPerformed

    private void txtPqtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPqtyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPqtyActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // Get product details from text fields
        String pname = txtPname.getText();
        String price = txtPprice.getText();
        String qty = txtPqty.getText();

        // Check if any of the fields are empty
        if (txtPname.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Product name is required!..");
        } else if (txtPprice.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Product price is required!..");
        } else if (txtPqty.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Product quantity is required!..");
        } else {
            try {
                // Prepare SQL statement to insert product details into the database
                pst = con.prepareStatement("insert into product_tbl(pname,price,qty) values(?,?,?)");
                pst.setString(1, pname);
                pst.setString(2, price);
                pst.setString(3, qty);

                // Execute the SQL statement
                int k = pst.executeUpdate();
                if (k == 1) {
                    // If successful, show success message and clear text fields
                    JOptionPane.showMessageDialog(this, "Record Added Successfully..");
                    txtPname.setText("");
                    txtPprice.setText("");
                    txtPqty.setText("");
                    fetch();// Refresh the table and product ID combo box with updated data
                    LoadProductNo();
                } else {
                    // If insertion fails, show failure message
                    JOptionPane.showMessageDialog(this, "Record Failed..");
                }
            } catch (SQLException ex) {
                Logger.getLogger(crud_Form.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnAddActionPerformed

    // Method to search for a product by its ID
    private void BtnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSearchActionPerformed
        try {
            // Get the selected product ID from the combo box
            String pid = txtPid.getSelectedItem().toString();
            // Prepare SQL query to select product details based on ID
            pst = con.prepareStatement("select * from product_tbl where id=?");
            pst.setString(1, pid);
            // Execute the query
            rs = pst.executeQuery();
            // If a record is found, display the details in the text fields
            if (rs.next() == true) {
                txtPname.setText(rs.getString(2));
                txtPprice.setText(rs.getString(3));
                txtPqty.setText(rs.getString(4));
            } else {
                // If no record is found, display a message
                JOptionPane.showMessageDialog(this, "No Record Found..");
            }
        } catch (SQLException ex) {
            Logger.getLogger(crud_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BtnSearchActionPerformed

    // Method to update product details
    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // Check if any of the fields are empty
        if (txtPname.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Product name is required!..");
        } else if (txtPprice.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Product price is required!..");
        } else if (txtPqty.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Product quantity is required!..");
        } else {
            try {
                // Get product details from text fields
                String pname = txtPname.getText();
                String price = txtPprice.getText();
                String qty = txtPqty.getText();
                // Get the selected product ID from the combo box
                String pid = txtPid.getSelectedItem().toString();

                // Prepare SQL statement to update product details in the database
                pst = con.prepareStatement("update product_tbl set pname=?,price=?,qty=? where id=?");
                pst.setString(1, pname);
                pst.setString(2, price);
                pst.setString(3, qty);
                pst.setString(4, pid);

                // Execute the SQL statement
                int k = pst.executeUpdate();
                if (k == 1) {
                    // If successful, display success message and clear text fields
                    JOptionPane.showMessageDialog(this, "Record has been Successfully Updated..");
                    txtPname.setText("");
                    txtPprice.setText("");
                    txtPqty.setText("");
                    txtPname.requestFocus();
                    fetch();// Refresh the table and product ID combo box with updated data
                    LoadProductNo();
                } else {
                    JOptionPane.showMessageDialog(this, "Update Failed..");
                }

            } catch (SQLException ex) {
                Logger.getLogger(crud_Form.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    // Method to delete a product record
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // Get the selected product ID from the combo box
        String pid = txtPid.getSelectedItem().toString();

        try {
            // Prepare SQL statement to delete product record based on ID
            pst = con.prepareStatement("delete from product_tbl where id=?");
            pst.setString(1, pid);

            // Execute the SQL statement
            int k = pst.executeUpdate();
            if (k == 1) {
                // If successful, display success message and clear text fields
                JOptionPane.showMessageDialog(this, "Record Deleted..");
                txtPname.setText("");
                txtPprice.setText("");
                txtPqty.setText("");
                txtPname.requestFocus();
                // Refresh the table and product ID combo box with updated data
                fetch();
                LoadProductNo();
            } else {
                // If deletion fails, display failure message
                JOptionPane.showMessageDialog(this, "delete Failed..");
            }
        } catch (SQLException ex) {
            // Handle any SQL exceptions
            Logger.getLogger(crud_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txtPidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPidActionPerformed

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
            java.util.logging.Logger.getLogger(crud_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(crud_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(crud_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(crud_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new login_Form().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnSearch;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> txtPid;
    private javax.swing.JTextField txtPname;
    private javax.swing.JTextField txtPprice;
    private javax.swing.JTextField txtPqty;
    // End of variables declaration//GEN-END:variables

}
