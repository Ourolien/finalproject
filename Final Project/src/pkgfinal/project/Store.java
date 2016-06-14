/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author lucif
 */
public class Store extends javax.swing.JFrame {
    public static ArrayList<Product> myList;
    public static DefaultTableModel productmodel;

    /**
     *
     */
    public static ArrayList<Product> cart = new ArrayList<>();
    public static DefaultTableModel cartmodel;
    public final static String DB_URL="jdbc:mysql://localhost:3306/OnlineShop";
    public final static String USER="root";
    public final static String PASS="";
    public final static String JDBC_DRIVER="com.mysql.jdbc.Driver";
    
    public Store() {
        initComponents();
        myList = new ArrayList<>();
        productmodel = (DefaultTableModel) product.getModel();
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
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cartbutton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        product = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        outbutton = new javax.swing.JButton();
        exitbutton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cartbutton.setText("Add To Cart");
        cartbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cartbuttonActionPerformed(evt);
            }
        });

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
        jScrollPane2.setViewportView(product);

        jLabel1.setText("Store");

        outbutton.setText("View Cart");
        outbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outbuttonActionPerformed(evt);
            }
        });

        exitbutton.setText("Log Out");
        exitbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitbuttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(exitbutton)
                        .addGap(18, 18, 18)
                        .addComponent(outbutton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cartbutton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cartbutton)
                    .addComponent(outbutton)
                    .addComponent(exitbutton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cartbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cartbuttonActionPerformed
        boolean isExist = false;
        int tmp = 0;
        Product temp2 = (Product) myList.get(product.getSelectedRow());
        for (int x =0; x<cart.size();x++){
            if (cart.get(x) == temp2){
                tmp = x;
                isExist=true;
            }
            if(isExist) {
                break;
            }
        }
        if(isExist) {
            cart.get(tmp).setStock(cart.get(tmp).getStock()+1);
        }
        else {
            temp2.setStock(1);
            cart.add(temp2);
        }
        JOptionPane.showMessageDialog(null,"A product has been added to cart!");
        
    }//GEN-LAST:event_cartbuttonActionPerformed

    private void exitbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitbuttonActionPerformed
        this.dispose();
        new Login().setVisible(true);
    }//GEN-LAST:event_exitbuttonActionPerformed

    private void outbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outbuttonActionPerformed
        this.dispose();
        new Checkout().setVisible(true);
    }//GEN-LAST:event_outbuttonActionPerformed
    
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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            } 
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cartbutton;
    private javax.swing.JButton exitbutton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton outbutton;
    private javax.swing.JTable product;
    // End of variables declaration//GEN-END:variables

    private Product myList(int x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
