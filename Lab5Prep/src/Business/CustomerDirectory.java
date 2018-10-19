/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Abstract.User;
import Business.Users.Customer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author harshalneelkamal
 */
public class CustomerDirectory {
    
    private List<User> customerList;
    //private 
    
    public CustomerDirectory(){
        customerList = new ArrayList<>();
    }

    public List<User> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<User> supplierList) {
        this.customerList = supplierList;
    }
 
    public void add(Date dateCreated,String userName, String password){
        Customer customer = new Customer(dateCreated,password, userName);
        this.customerList.add(customer);
    }
}
