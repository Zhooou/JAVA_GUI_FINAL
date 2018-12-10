/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Userinterface.Librarian;

import Business.Book.Book;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.LibraryEnterprise;
import Business.Organization.LibrarianOrganization;
import Business.Organization.StudentOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.BookRequest;
import Userinterface.Admin.ManageOganizationJPanel;
import java.awt.CardLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author cyyo
 */
public class LibrarianWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel container;
    private UserAccount account;
    private LibrarianOrganization organization;
    private LibraryEnterprise enterprise;
    
    /**
     * Creates new form LibrarianManagementJPanel
     */
    public LibrarianWorkAreaJPanel(JPanel container, UserAccount account, LibrarianOrganization organization, Enterprise enterprise) {
        this.container = container;
        this.account = account;
        this.organization = organization;
        this.enterprise = (LibraryEnterprise) enterprise;
        initComponents();
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
        booksViewBtn = new javax.swing.JButton();
        analysisButton = new javax.swing.JButton();
        checkRequestButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setText("Please manage the library system");

        booksViewBtn.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        booksViewBtn.setForeground(new java.awt.Color(0, 102, 102));
        booksViewBtn.setText(" books View");
        booksViewBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                booksViewBtnActionPerformed(evt);
            }
        });

        analysisButton.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        analysisButton.setForeground(new java.awt.Color(0, 102, 102));
        analysisButton.setText("Analysis Helper");
        analysisButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                analysisButtonActionPerformed(evt);
            }
        });

        checkRequestButton.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        checkRequestButton.setForeground(new java.awt.Color(0, 102, 102));
        checkRequestButton.setText("Check Request");
        checkRequestButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkRequestButtonActionPerformed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Business/Images/bbb.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(389, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(analysisButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(checkRequestButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(booksViewBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(booksViewBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(checkRequestButton, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(analysisButton, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(47, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void booksViewBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_booksViewBtnActionPerformed
        // TODO add your handling code here:
        BookViewJPanel bookViewJPanel = new BookViewJPanel(container, account, enterprise);
        container.add("bookViewJPanel", bookViewJPanel);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.next(container);
    }//GEN-LAST:event_booksViewBtnActionPerformed

    private void analysisButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_analysisButtonActionPerformed
        // TODO add your handling code here:
        AnalysisJPanel analysisJPanel = new AnalysisJPanel(container, enterprise);
        container.add("analysisJPanel", analysisJPanel);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.next(container);
    }//GEN-LAST:event_analysisButtonActionPerformed

    private void checkRequestButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkRequestButtonActionPerformed
        // TODO add your handling code here:
        RentingRequestJPanel rentingRequestJPanel = new RentingRequestJPanel(container, account, enterprise);
        container.add("rentingRequestJPanel", rentingRequestJPanel);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.next(container);
    }//GEN-LAST:event_checkRequestButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton analysisButton;
    private javax.swing.JButton booksViewBtn;
    private javax.swing.JButton checkRequestButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}
