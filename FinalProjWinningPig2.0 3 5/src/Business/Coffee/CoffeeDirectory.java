/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Coffee;

import java.util.ArrayList;

/**
 *
 * @author runyangzhou
 */
public class CoffeeDirectory {
    private ArrayList<Coffee> coffeeList;
    
    public CoffeeDirectory(){
        this.coffeeList = new ArrayList();
    }

    public ArrayList<Coffee> getCoffeeList() {
        return coffeeList;
    }

    public void setCoffeeList(ArrayList<Coffee> coffeeList) {
        this.coffeeList = coffeeList;
    }
    
    
}
