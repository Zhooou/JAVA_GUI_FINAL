/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import java.util.ArrayList;

/**
 *
 * @author runyangzhou
 */
public class OrganizationDirectory {
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization createOrganization(Organization.Type type){
        Organization organization = null;
        if (type.getValue().equals(Organization.Type.Librarian.getValue())){
            organization = new LibrarianOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Organization.Type.Student.getValue())){
            organization = new StudentOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Organization.Type.TA.getValue())){
            organization = new TAOrganization();
            organizationList.add(organization);
        }
        return organization;
    }
}
