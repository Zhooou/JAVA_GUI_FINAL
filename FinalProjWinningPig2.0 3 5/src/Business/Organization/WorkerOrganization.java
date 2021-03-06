/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.Role;
import Business.Role.TutorRole;
import Business.Role.WorkerRole;
import java.util.ArrayList;

/**
 *
 * @author runyangzhou
 */
public class WorkerOrganization extends Organization{
    public WorkerOrganization(){
        super(Type.Worker.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new WorkerRole());
        return roles;
    }
}
