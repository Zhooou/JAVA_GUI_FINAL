/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment_4;

import assignment_4.anlysis.AnlysisHelper;
import assignment_4.anlysis.DataStore;
import assignment_4.entities.Item;
import assignment_4.entities.Product;
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
        
        prodReader = new DataReader(generator.getProductCataloguePath());
        orderReader = new DataReader(generator.getOrderFilePath());
        
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
    }

    public void generateProd(String[] row){
        int productId = Integer.parseInt(row[0]);
        int minPrice = Integer.parseInt(row[1]);
        int maxPrice = Integer.parseInt(row[2]);
        int targetPrice = Integer.parseInt(row[3]);
        DataStore.getInstance().getProducts().put(productId, new Product(productId, minPrice, maxPrice, targetPrice));
    }
    
    public void generateOrder(String[] row, Item item){
        
    }
    
    public Item generateItem(String[] row){
        Item item = new Item(1,1,1);
        return item;
    }
    
    public void generateCustomer(String[] row){
        
    }
    
    public void generateSalesPerson(String[] row){
        
    }
}
