/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.CafeEnterprise;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.TutorOrganization;
import Business.Organization.WorkerOrganization;
import Business.UserAccount.UserAccount;
import Userinterface.Tutor.TutorWorkAreaJPanel;
import Userinterface.Worker.WorkerWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author runyangzhou
 */
public class WorkerRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, Network network, EcoSystem business) {
        return new WorkerWorkAreaJPanel(userProcessContainer, account, (WorkerOrganization)organization, (CafeEnterprise)enterprise); 
    }
    
}
