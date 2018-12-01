/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment_4;

import assignment_4.anlysis.AnlysisHelper;
import assignment_4.anlysis.DataStore;
import assignment_4.entities.Customer;
import assignment_4.entities.Item;
import assignment_4.entities.Order;
import assignment_4.entities.Product;
import assignment_4.entities.SalesPerson;
import java.io.IOException;

/**
 *
 * @author harshalneelkamal
 */
public class GateWay {
    
    private DataReader prodReader;
    private DataReader orderReader;
    private AnlysisHelper helper;
    
    public GateWay() throws IOException{
        DataGenerator generator = DataGenerator.getInstance();
//        
//        prodReader = new DataReader(generator.getProductCataloguePath());
//        orderReader = new DataReader(generator.getOrderFilePath());
        
        prodReader = new DataReader("./ProductCatalogue1.csv");
        orderReader = new DataReader("./SalesData1.csv");
        
        helper = new AnlysisHelper();
    }
    
    public static void main(String args[]) throws IOException{
        GateWay gateway_Instance = new GateWay();
        gateway_Instance.readData();
    }
    
    public void readData() throws IOException{
        String[] row;
        while((row = prodReader.getNextRow()) != null ){
            generateProd(row);
        }
        while((row = orderReader.getNextRow()) != null ){
            generateOrder(row, generateItem(row));
            generateCustomer(row);
            generateSalesPerson(row);
        }
        
        analysis();
    }

    public void generateProd(String[] row){
        int productId = Integer.parseInt(row[0]);
        int minPrice = Integer.parseInt(row[1]);
        int maxPrice = Integer.parseInt(row[2]);
        int targetPrice = Integer.parseInt(row[3]);
        DataStore.getInstance().getProducts().put(productId, new Product(productId, minPrice, maxPrice, targetPrice));
    }
    
    public void generateOrder(String[] row, Item item){
        int orderId = Integer.parseInt(row[0]);
        int salesPerosnId = Integer.parseInt(row[4]);
        int customerId = Integer.parseInt(row[5]);
        
        Order order = new Order(orderId, salesPerosnId, customerId, item);
        DataStore.getInstance().getOrders().put(orderId, order);
    }
    
    public Item generateItem(String[] row){    
        int productId = Integer.parseInt(row[2]);;
        int salesPrice = Integer.parseInt(row[6]);;
        int quantity =Integer.parseInt(row[3]);;
        Item item = new Item(productId, salesPrice, quantity);
        return item;
    }
    
    public void generateCustomer(String[] row){
        int customerId = Integer.parseInt(row[5]);
        DataStore.getInstance().getCustomers().put(customerId, new Customer(customerId));
    }
    
    public void generateSalesPerson(String[] row){
        int salesPerosnId = Integer.parseInt(row[4]);
        DataStore.getInstance().getSalesPersons().put(salesPerosnId, new SalesPerson(salesPerosnId));
    }
    
    public void analysis(){
        helper.top3MostPopProd();
        helper.best3Customer();
        helper.top3SalesPeole();
        helper.totalRevenue();
    }
}
