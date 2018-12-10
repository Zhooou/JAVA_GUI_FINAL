/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Userinterface.Admin;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author cyyo
 */
public class AdminWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form AdminWorkAreaJPanel
     */
    private EcoSystem ecoSystem;
    private JPanel container;
    private Enterprise enterprise;

    public AdminWorkAreaJPanel(JPanel container, Enterprise enterprise, EcoSystem ecoSystem) {
        initComponents();
        this.container = container;
        this.enterprise = enterprise;
        this.ecoSystem = ecoSystem;
        valueLabel.setText(enterprise.getName());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        manageAccountJButton = new javax.swing.JButton();
        manageUserJButton = new javax.swing.JButton();
        manageOrganizationJButton = new javax.swing.JButton();
        enterpriseLabel = new javax.swing.JLabel();
        valueLabel = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 204));
        jLabel1.setText("Library System Area -Adminstrative Role");

        manageAccountJButton.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        manageAccountJButton.setForeground(new java.awt.Color(0, 153, 153));
        manageAccountJButton.setText("Manage Account");
        manageAccountJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageAccountJButtonActionPerformed(evt);
            }
        });

        manageUserJButton.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        manageUserJButton.setForeground(new java.awt.Color(0, 153, 153));
        manageUserJButton.setText("Manage User");
        manageUserJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageUserJButtonActionPerformed(evt);
            }
        });

        manageOrganizationJButton.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        manageOrganizationJButton.setForeground(new java.awt.Color(0, 153, 153));
        manageOrganizationJButton.setText("Manage Organization");
        manageOrganizationJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageOrganizationJButtonActionPerformed(evt);
            }
        });

        enterpriseLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        enterpriseLabel.setText("EnterPrise :");

        valueLabel.setText("<value>");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(manageOrganizationJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(manageUserJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(manageAccountJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(enterpriseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(valueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(130, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(enterpriseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(valueLabel))
                .addGap(21, 21, 21)
                .addComponent(manageOrganizationJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(manageUserJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(manageAccountJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void manageAccountJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageAccountJButtonActionPerformed
        // TODO add your handling code here:
        boolean checkUsersNotEmpty = false;
        
        for(Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
            if(organization.getPersonDirectory().getPersonList().size() > 0){
                checkUsersNotEmpty = true;
                break;
            }
        }
        if(checkUsersNotEmpty){
            ManageAccountJPanel mujp = new ManageAccountJPanel(container, enterprise, ecoSystem);
            container.add("ManageUserAccountJPanel", mujp);
            CardLayout layout = (CardLayout) container.getLayout();
            layout.next(container);}
        else{
            JOptionPane.showMessageDialog(null, "No User Created Yet!");
        }
    }//GEN-LAST:event_manageAccountJButtonActionPerformed
    
    private void manageUserJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageUserJButtonActionPerformed
        if(enterprise.getOrganizationDirectory().getOrganizationList().size() > 0)
        {
            ManagePersonJPanel managePersonJPanel = new ManagePersonJPanel(container, enterprise.getOrganizationDirectory());
            container.add("managePersonJPanel", managePersonJPanel);
            CardLayout layout = (CardLayout) container.getLayout();
            layout.next(container);
        }  
        else{
            JOptionPane.showMessageDialog(null, "No Organization Created Yet!");
        }
    }//GEN-LAST:event_manageUserJButtonActionPerformed

    private void manageOrganizationJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageOrganizationJButtonActionPerformed
        ManageOganizationJPanel manageOrganizationJPanel = new ManageOganizationJPanel(container, enterprise.getOrganizationDirectory(), enterprise);
        container.add("manageOrganizationJPanel", manageOrganizationJPanel);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.next(container);
       
    }//GEN-LAST:event_manageOrganizationJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton manageAccountJButton;
    private javax.swing.JButton manageOrganizationJButton;
    private javax.swing.JButton manageUserJButton;
    private javax.swing.JLabel valueLabel;
    // End of variables declaration//GEN-END:variables
}