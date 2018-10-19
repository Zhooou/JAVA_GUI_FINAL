/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import Business.Users.Admin;
import Business.Users.Customer;
import Business.Users.Supplier;
import java.awt.CardLayout;
import static java.awt.Color.*;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ButtonModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author harshalneelkamal
 */
public class AdminCreateScreen extends javax.swing.JPanel {

    /**
     * Creates new form AdminScreen
     */
    private JPanel panelRight;
    private Admin admin;
    public AdminCreateScreen(JPanel panelRight, Admin admin) {
        initComponents();
        this.panelRight = panelRight;
        this.admin = admin;
        checkButtonEnabled();
    }
    
    public void checkButtonEnabled(){
        btnCreate.setEnabled(false);
        if(txtUser.getText().isEmpty()){
            lblResult.setText("Username cannot be empty");
            return;
        }
        if(txtPword.getText().isEmpty()){
            lblResult.setText("Password cannot be empty");
            return;
        }
        if(txtRePword.getText().isEmpty()){
            lblResult.setText("Re-enter Password cannot be empty");
            return;
        }
        if(!txtPword.getText().equals(txtRePword.getText())){
            lblResult.setText("Password and re-enter don't match");
            return;
        }
        if(!radioCustomer.isSelected() && !radioSupplier.isSelected()){
            lblResult.setText("Please select one rule");
            return;
        }
        if(checkPasswordPattern()){
            lblResult.setText("Wrong password format");
            return;
        }
        if(checkUsernamePattern()){
            lblResult.setText("Wrong username format");
            return;
        }
        
        btnCreate.setEnabled(true);
        lblResult.setText("You can create now");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        radioGroup = new javax.swing.ButtonGroup();
        btnCreate = new javax.swing.JButton();
        txtUser = new javax.swing.JTextField();
        txtPword = new javax.swing.JTextField();
        txtRePword = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        radioCustomer = new javax.swing.JRadioButton();
        radioSupplier = new javax.swing.JRadioButton();
        btnBack = new javax.swing.JButton();
        lblResult = new javax.swing.JLabel();

        btnCreate.setText("Create");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        txtUser.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        txtUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserActionPerformed(evt);
            }
        });
        txtUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUserKeyReleased(evt);
            }
        });

        txtPword.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        txtPword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPwordActionPerformed(evt);
            }
        });
        txtPword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPwordKeyReleased(evt);
            }
        });

        txtRePword.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        txtRePword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRePwordActionPerformed(evt);
            }
        });
        txtRePword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtRePwordKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRePwordKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRePwordKeyTyped(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel1.setText("username:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel2.setText("password:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel3.setText("re-enter password :");

        radioGroup.add(radioCustomer);
        radioCustomer.setText("Customer");
        radioCustomer.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                radioCustomerStateChanged(evt);
            }
        });
        radioCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioCustomerActionPerformed(evt);
            }
        });

        radioGroup.add(radioSupplier);
        radioSupplier.setText("Supplier");
        radioSupplier.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                radioSupplierStateChanged(evt);
            }
        });

        btnBack.setText("< BACK");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblResult, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(35, 35, 35)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(radioSupplier)
                                        .addComponent(radioCustomer)))
                                .addComponent(txtUser, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
                                .addComponent(txtPword)
                                .addComponent(txtRePword)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(17, 17, 17)
                            .addComponent(btnBack))))
                .addContainerGap(227, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBack)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRePword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(radioCustomer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radioSupplier)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblResult, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnCreate)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        // TODO add your handling code here:
//        if(txtUser.getText().isEmpty()){
//            JOptionPane.showMessageDialog(this, "User name cannot be empty");
//            return;
//        }
//        if(txtPword.getText().isEmpty()){
//            JOptionPane.showMessageDialog(this, "Password cannot be empty");
//            return;
//        }
//        if(txtRePword.getText().isEmpty()){
//            JOptionPane.showMessageDialog(this, "Re-enter Password cannot be empty");
//            return;
//        }
//        if(!radioCustomer.isSelected() && !radioSupplier.isSelected()){
//            JOptionPane.showMessageDialog(this, "Please select one rule");
//            return;
//        }
//        if(checkPasswordPattern()){
//            JOptionPane.showMessageDialog(this, "Wrong password format");
//            return;
//        }
        if(radioCustomer.isSelected()){
            admin.getCustDir().add( txtUser.getText(),txtPword.getText());
        }
        else{
            admin.getSuppDir().add(txtUser.getText(),txtPword.getText());
        }
        
        txtUser.setText("");
        txtPword.setText("");
        txtRePword.setText("");
        txtRePword.setBackground(white);
        JOptionPane.showMessageDialog(this, "Create Successfully");
    }//GEN-LAST:event_btnCreateActionPerformed

    private Boolean checkPasswordPattern(){
        Pattern p = Pattern.compile("[^A-Za-z0-9@&$]");
        Matcher m = p.matcher(txtPword.getText());
        boolean b = m.find();
        
        return b;
    }
    
    private Boolean checkUsernamePattern(){
        Pattern p = Pattern.compile("^[a-zA-Z0-9@][a-zA-Z0-9@_]*$");
        //^[A-Za-z0-9]{1}[A-Za-z0-9_]+@[A-Za-z0-9_]+
        Matcher m = p.matcher(txtPword.getText());
        boolean b = m.find();
        
        return !b;
    }
    
    
    private void radioCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioCustomerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioCustomerActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

        CardLayout layout = (CardLayout)panelRight.getLayout();
        panelRight.remove(this);
        layout.previous(panelRight);
        
        Component[] components = panelRight.getComponents();
        for(Component c : components){
            if(c instanceof AdminMainScreen){
                AdminMainScreen panel = (AdminMainScreen) c;
                panel.populate();
            }
        }
        
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtRePwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRePwordActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtRePwordActionPerformed

    private void txtRePwordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRePwordKeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtRePwordKeyPressed

    private void txtRePwordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRePwordKeyReleased
        // TODO add your handling code here:
        if(txtPword.getText().equals(txtRePword.getText())){
            txtRePword.setBackground(green);
        }
        else{
            txtRePword.setBackground(red);
        }
        checkButtonEnabled();
    }//GEN-LAST:event_txtRePwordKeyReleased

    private void txtRePwordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRePwordKeyTyped
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtRePwordKeyTyped
    
    private void txtUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserActionPerformed

    private void txtUserKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserKeyReleased
        // TODO add your handling code here:
        checkButtonEnabled();
    }//GEN-LAST:event_txtUserKeyReleased

    private void txtPwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPwordActionPerformed

    private void txtPwordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPwordKeyReleased
        // TODO add your handling code here:
        if(txtPword.getText().equals(txtRePword.getText())){
            txtRePword.setBackground(green);
        }
        else{
            txtRePword.setBackground(red);
        }
        checkButtonEnabled();
    }//GEN-LAST:event_txtPwordKeyReleased

    private void radioCustomerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_radioCustomerStateChanged
        // TODO add your handling code here:
        checkButtonEnabled();
    }//GEN-LAST:event_radioCustomerStateChanged

    private void radioSupplierStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_radioSupplierStateChanged
        // TODO add your handling code here:
        checkButtonEnabled();
    }//GEN-LAST:event_radioSupplierStateChanged

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCreate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblResult;
    private javax.swing.JRadioButton radioCustomer;
    private javax.swing.ButtonGroup radioGroup;
    private javax.swing.JRadioButton radioSupplier;
    private javax.swing.JTextField txtPword;
    private javax.swing.JTextField txtRePword;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
