/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Users;

import Business.Abstract.User;
import java.util.Date;

/**
 *
 * @author harshalneelkamal
 */
public class Customer extends User implements Comparable<Customer>{

//    private Date dateCreated;
    
    public Customer(String password, String userName) {
        super(password, userName, "Customer");
//        this.dateCreated = dateCreated;
    }

    @Override
    public boolean verify(String password) {
        if(password.equals(getPassword()))
            return true;
        else
            return false;
    }

    @Override
    public int compareTo(Customer o) {
        return getUserName().compareTo(o.getUserName());
    }
    
}
