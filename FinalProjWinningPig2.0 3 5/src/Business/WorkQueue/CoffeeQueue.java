/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import java.util.ArrayList;

/**
 *
 * @author runyangzhou
 */
public class CoffeeQueue {
    private ArrayList<CoffeeRequest> coffeeRequestList;
    
    public CoffeeQueue(){
        this.coffeeRequestList = new ArrayList();
    }

    public ArrayList<CoffeeRequest> getCoffeeRequestList() {
        return coffeeRequestList;
    }

    public void setCoffeeRequestList(ArrayList<CoffeeRequest> coffeeRequestList) {
        this.coffeeRequestList = coffeeRequestList;
    }
}
