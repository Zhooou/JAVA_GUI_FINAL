/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment_4.anlysis;

import assignment_4.entities.Customer;
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
    
     public void getTop3PopularProduct(){
      List<Order> orderList = new ArrayList(DataStore.getInstance().getOrders().values());
          Map<Integer,Integer> Quantitycount = new HashMap<>();   
         //  Map<Integer,Customer> customer = DataStore.getInstance().getCustomers();
            Map<Integer,Order> orders = DataStore.getInstance().getOrders();
            for(Order order : orders.values()){
            int quantityCount = 0; 
             if(Quantitycount.containsKey(order.getItem().getProductId())){
                quantityCount = Quantitycount.get(order.getItem().getProductId());
             }
            quantityCount = quantityCount + order.getItem().getQuantity();
            Quantitycount.put(order.getItem().getProductId(), quantityCount);
            }
          
       List<Map.Entry<Integer, Integer>> rankList = new ArrayList(Quantitycount.entrySet());
       System.out.println(rankList);
        Collections.sort(rankList, new Comparator<Map.Entry<Integer, Integer>>(){
             @Override
           public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
               return -o1.getValue().compareTo(o2.getValue());
           }
        });
         for(int i = 0; i < 3; i++){
             System.out.println("Product ID: "+rankList.get(i).getKey() + " Top3 popular products: "+ rankList.get(i).getValue());
         }
         }



 public void getTop3Customer(){
        List<Order>orderList = new ArrayList(DataStore.getInstance().getOrders().values());
        List<Customer> customerList = new ArrayList(DataStore.getInstance().getCustomers().values());
        Map<Integer, Integer> customerActiveMap = new HashMap();
        for(Customer c: customerList){
            customerActiveMap.put(c.getId(), 0);
        }
        for(Order o: orderList){
            int orderCount = 0;
            if(customerActiveMap.containsKey(o.getCustomerId())){
                orderCount = customerActiveMap.get(o.getCustomerId());
            }
            orderCount = orderCount + o.getItem().getQuantity() * o.getItem().getSalesPrice();
            customerActiveMap.put(o.getCustomerId(), orderCount);
        }
        System.out.println(customerActiveMap);
        List<Map.Entry<Integer, Integer>> rankList = new ArrayList(customerActiveMap.entrySet());
        Collections.sort(rankList, new Comparator<Map.Entry<Integer, Integer>>(){

            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return -o1.getValue().compareTo(o2.getValue());
            }
            
        });
        for(int i = 0; i < 3; i++){
            System.out.println( " Top "+(i+1)+" "+"Customer ID: "+rankList.get(i).getKey() +" "+"Total Consumption: "+ rankList.get(i).getValue());
        }
    }
    
 public void getTop3Salesman(){
        List<Order>orderList = new ArrayList(DataStore.getInstance().getOrders().values());
        List<SalesPerson> SaleList = new ArrayList(DataStore.getInstance().getSalesPersons().values());
        List<Product> pList= new ArrayList(DataStore.getInstance().getProducts().values());
        Map<Integer, Integer> salesActiveMap = new HashMap();
        for(SalesPerson s: SaleList){
            salesActiveMap.put(s.getId(), 0);
        }
        for(Order o: orderList){
            int orderCount = 0;
            if(salesActiveMap.containsKey(o.getCustomerId())){
                orderCount = salesActiveMap.get(o.getCustomerId());
            }
            orderCount = orderCount + o.getItem().getQuantity() *(o.getItem().getSalesPrice()-o.getItem().getProductId()) ;
            int id = o.getItem().getProductId();
            Product p = DataStore.getInstance().getProducts().get(id);
            salesActiveMap.put(o.getCustomerId(), orderCount);
        }
        System.out.println(salesActiveMap);
        List<Map.Entry<Integer, Integer>> rankList = new ArrayList(salesActiveMap.entrySet());
        Collections.sort(rankList, new Comparator<Map.Entry<Integer, Integer>>(){

            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return -o1.getValue().compareTo(o2.getValue());
            }
            
        });
        for(int i = 0; i < 3; i++){
            System.out.println( " Top "+(i+1)+" "+"Salesman ID: "+rankList.get(i).getKey() +" "+"Total selling: "+ rankList.get(i).getValue());
        }
    }
 
}