/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import static pkgfinal.project.Signup.DB_URL;
import static pkgfinal.project.Signup.JDBC_DRIVER;
import static pkgfinal.project.Signup.PASS;
import static pkgfinal.project.Signup.USER;

/**
 *
 * @author lucif
 */
public class Admin extends javax.swing.JFrame {
    
    public static ArrayList myList = new ArrayList<Product>();
    public static DefaultTableModel productmodel;
    public final static String DB_URL="jdbc:mysql://localhost:3306/OnlineShop";
    public final static String USER="root";
    public final static String PASS="";
    public final static String JDBC_DRIVER="com.mysql.jdbc.Driver";
    
    public Admin() {
        initComponents();
        productmodel = (DefaultTableModel) product.getModel();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        product = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        addbutton = new javax.swing.JButton();
        delbutton = new javax.swing.JButton();
        Exitbutton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        product.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Product ID", "Manufacturer", "Price", "Stock", "Product Name"
            }
        ));
        jScrollPane1.setViewportView(product);

        jLabel1.setText("Admin Store Configuration");

        addbutton.setText("Add");
        addbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbuttonActionPerformed(evt);
            }
        });

        delbutton.setText("Delete");
        delbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delbuttonActionPerformed(evt);
            }
        });

        Exitbutton.setText("Exit");
        Exitbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitbuttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Exitbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(delbutton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(addbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(delbutton)
                    .addComponent(addbutton)
                    .addComponent(Exitbutton))
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void delbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delbuttonActionPerformed
            try {
            Connection conn = null;
            Statement stmt = null;
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER,PASS);
            stmt = conn.createStatement();
            String sql="delete from product limit 1";
            System.out.println(sql);
            stmt.executeUpdate(sql);
            this.dispose();
            new Admin().setVisible(true);
                    } catch (ClassNotFoundException | SQLException ex) {
            System.err.println(ex);
               }      
    }//GEN-LAST:event_delbuttonActionPerformed

    private void addbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbuttonActionPerformed
        this.dispose();
        new Add().setVisible(true);
    }//GEN-LAST:event_addbuttonActionPerformed

    private void ExitbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitbuttonActionPerformed
        this.dispose();
        new Login().setVisible(true);
    }//GEN-LAST:event_ExitbuttonActionPerformed
    
        private static void product() {
        Connection login=null;
        Statement loginsave=null;
        try {
        Class.forName(JDBC_DRIVER);
        login = DriverManager.getConnection(DB_URL, USER, PASS);
        loginsave = login.createStatement();}
        catch(Exception ex){
        System.err.println(ex);
        }
        int correct =0;
    
    try (ResultSet db = loginsave.executeQuery("select*from product")) {
            while (db.next()){
                Product temp = new Product();
                temp.setProductID(db.getString("productid"));
                temp.setManufacturer(db.getString("manufacturer"));
                temp.setPrice(db.getString("price"));
                temp.setStock(db.getInt("stock"));
                temp.setProductname(db.getString("productname"));
                myList.add(temp);
            }
    }
        catch(Exception ex){
           System.err.println(ex);    
        }
        
    }
    
    
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
            java.util.logging.Logger.getLogger(Store.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Store.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Store.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Store.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin().setVisible(true);
                product();
                productmodel.setRowCount(0);
                for (int x = 0;x<myList.size();x++){
                    Product tempproduct = (Product) myList.get(x);
                    productmodel.insertRow(productmodel.getRowCount(), new Object[]{

                        tempproduct.getProductID(),
                        tempproduct.getManufacturer(),
                        tempproduct.getPrice(),
                        tempproduct.getStock(),
                        tempproduct.getProductname()

                    });
                }
            } 
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Exitbutton;
    private javax.swing.JButton addbutton;
    private javax.swing.JButton delbutton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable product;
    // End of variables declaration//GEN-END:variables
}
