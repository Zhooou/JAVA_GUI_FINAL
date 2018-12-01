/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Userinterface.Admin.AdminWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author runyangzhou
 */
public class AdminRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem ecoSystem) {
         return new AdminWorkAreaJPanel(userProcessContainer, enterprise, ecoSystem);
    }
    
}
