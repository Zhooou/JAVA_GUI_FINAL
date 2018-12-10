/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Book.BookDirectory;
import Business.Coffee.CoffeeDirectory;
import Business.Role.Role;
import Business.WorkQueue.CoffeeQueue;
import java.util.ArrayList;

/**
 *
 * @author runyangzhou
 */
public class CafeEnterprise extends Enterprise{
    private CoffeeDirectory coffeeDirectory;
    private CoffeeQueue coffeeQueue;
    
    
    
    public CafeEnterprise(String name){
        super(name,Enterprise.EnterpriseType.Cafe);
        this.coffeeDirectory = new CoffeeDirectory();
        this.coffeeQueue = new CoffeeQueue();
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }

    public CoffeeQueue getCoffeeQueue() {
        return coffeeQueue;
    }

    public void setCoffeeQueue(CoffeeQueue coffeeQueue) {
        this.coffeeQueue = coffeeQueue;
    }
    

    public CoffeeDirectory getCoffeeDirectory() {
        return coffeeDirectory;
    }

    public void setCoffeeDirectory(CoffeeDirectory coffeeDirectory) {
        this.coffeeDirectory = coffeeDirectory;
    }
    
    

}
