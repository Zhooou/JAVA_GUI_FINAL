/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Coffee;

/**
 *
 * @author runyangzhou
 */
public class Coffee {
    private double price;
    private int id;
    private static int count = 0;
    private String name;

    public Coffee(String name, double price){
        this.name = name;
        this.price = price;
        id = count;
        count ++;
    }
    
    @Override
    public String toString(){
        return this.name;
    }
    
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Coffee.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
