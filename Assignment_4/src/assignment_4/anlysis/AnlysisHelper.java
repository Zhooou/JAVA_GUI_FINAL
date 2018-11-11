/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment_4.anlysis;

import assignment_4.entities.Customer;
import assignment_4.entities.Item;
import assignment_4.entities.Order;
import assignment_4.entities.Product;
import assignment_4.entities.SalesPerson;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author runyangzhou
 */
public class AnlysisHelper {
    
    public void top3MostPopProd(){
        Map<Integer, Integer> prodSales = new HashMap();
        
        for(Product p : DataStore.getInstance().getProducts().values())
            prodSales.put(p.getProductId(), 0);
        
        for(Order o : DataStore.getInstance().getOrders().values()){
            int quantity = 0;
            if(prodSales.containsKey(o.getItem().getProductId()))
                quantity = prodSales.get(o.getItem().getProductId());
            quantity = quantity + o.getItem().getQuantity();
            prodSales.put(o.getItem().getProductId(), quantity);
        }
        List<Map.Entry<Integer, Integer>> rankList = new ArrayList(prodSales.entrySet());
        Collections.sort(rankList, new Comparator<Map.Entry<Integer, Integer>>(){

            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return -o1.getValue().compareTo(o2.getValue());
            }
        });
        System.out.println(rankList);
        for(int i = 0; i < 3; i++){
            System.out.println("Top "+ (i+1) +" popular Product Id: " + rankList.get(i).getKey()+ " Total sales quantity: " + rankList.get(i).getValue());
        }
    }
    
    public void best3Customer(){
        Map<Integer, Integer> cusCosume = new HashMap();
        for(Customer c : DataStore.getInstance().getCustomers().values())
            cusCosume.put(c.getId(), 0);
        
        for(Order o : DataStore.getInstance().getOrders().values()){
            int cosume = 0;
            if(cusCosume.containsKey(o.getCustomerId()))
                cosume = cusCosume.get(o.getCustomerId());
            Item item = o.getItem();
            cosume = cosume + item.getQuantity() * item.getSalesPrice();
            cusCosume.put(o.getCustomerId(), cosume);
        }
        
        List<Map.Entry<Integer, Integer>> rankList = new ArrayList(cusCosume.entrySet());
        Collections.sort(rankList, new Comparator<Map.Entry<Integer, Integer>>(){

            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return -o1.getValue().compareTo(o2.getValue());
            }
        });
        
        System.out.println(rankList);
        for(int i = 0; i < 3; i++){
            System.out.println("Top "+ (i+1) + " Customer Id: " + rankList.get(i).getKey()+ " Total consumption: " + rankList.get(i).getValue());
        }
    }
    
    public void top3SalesPeole(){
        Map<Integer, Integer> salesPersonSales = new HashMap();
        for(SalesPerson sp: DataStore.getInstance().getSalesPersons().values())
             salesPersonSales.put(sp.getId(), 0);
         
        for(Order o : DataStore.getInstance().getOrders().values()){
            int sales = 0;
            if(salesPersonSales.containsKey(o.getCustomerId()))
                sales = salesPersonSales.get(o.getCustomerId());
            Item item = o.getItem();
            Product p = DataStore.getInstance().getProducts().get(item.getProductId());
            int TargetSales = p.getTargetPrice();
            sales = sales + item.getQuantity() * (item.getSalesPrice() - TargetSales);
            salesPersonSales.put(o.getCustomerId(), sales);
        }
        List<Map.Entry<Integer, Integer>> rankList = new ArrayList(salesPersonSales.entrySet());
        Collections.sort(rankList, new Comparator<Map.Entry<Integer, Integer>>(){

            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return -o1.getValue().compareTo(o2.getValue());
            }
        });
        
        System.out.println(rankList);
        for(int i = 0; i < 3; i++){
            System.out.println("Top "+ (i+1) + " SalesPeole Id: " + rankList.get(i).getKey()+ " Total sales: " + rankList.get(i).getValue());
        }
    }
    
    public void totalRevenue(){
        int totalRevenue = 0;
        for(Order o : DataStore.getInstance().getOrders().values()){
            Item item = o.getItem();
            Product p = DataStore.getInstance().getProducts().get(item.getProductId());
            int minPrice = p.getMinPrice();
            totalRevenue = totalRevenue + item.getQuantity() * (item.getSalesPrice() - minPrice);
        }
        System.out.println("total revenue this year : "+totalRevenue);
    }
}
