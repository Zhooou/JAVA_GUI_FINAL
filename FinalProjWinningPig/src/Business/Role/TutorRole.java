/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Organization.StudentOrganization;
import Business.Organization.TutorOrganization;
import Business.UserAccount.UserAccount;
import Userinterface.Student.StudentWorkAreaJPanel;
import Userinterface.Tutor.TutorWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author runyangzhou
 */
public class TutorRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new TutorWorkAreaJPanel(userProcessContainer, account, (TutorOrganization)organization, enterprise); 
    }
    
}
