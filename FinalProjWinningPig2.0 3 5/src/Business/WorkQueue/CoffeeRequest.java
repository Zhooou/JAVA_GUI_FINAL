/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Coffee.Coffee;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author runyangzhou
 */
public class CoffeeRequest extends WorkRequest{
    private HashMap<Coffee, Integer> coffeeOrder;

    @Override
    public String toString(){
        String result = "";
        for(Map.Entry<Coffee, Integer> e : coffeeOrder.entrySet())
            result += e.getKey().getName() + " * " + e.getValue() + "  ";
        return result;
    }
    
    public double getTotalPrice(){
        double price = 0;
        for(Map.Entry<Coffee, Integer> e : coffeeOrder.entrySet())
            price += e.getKey().getPrice() * e.getValue();
        return price;
    }
    
    public CoffeeRequest() {
        coffeeOrder = new HashMap();
    }

    public HashMap<Coffee, Integer> getCoffeeOrder() {
        return coffeeOrder;
    }

    public void setCoffeeOrder(HashMap<Coffee, Integer> coffeeOrder) {
        this.coffeeOrder = coffeeOrder;
    }
    
}
