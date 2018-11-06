/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment_4;

import assignment_4.anlysis.AnlysisHelper;
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
            
        }
        while((row = orderReader.getNextRow()) != null ){
            
        }
    }
    
    public void readRow() throws IOException{
        
    }
}
