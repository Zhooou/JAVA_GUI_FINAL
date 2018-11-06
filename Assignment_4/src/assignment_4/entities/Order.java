/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment_4.entities;

/**
 *
 * @author harshalneelkamal
 */
public class Order {
    int orderId;
    int salesPerosnId;
    int customerId;
    Item item;
    
    public Order(int orderId, int salesPerosnId, int customerId, Item item) {
        this.orderId = orderId;
        this.salesPerosnId = salesPerosnId;
        this.customerId = customerId;
        this.item = item;
    }
    
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getSalesPerosnId() {
        return salesPerosnId;
    }

    public void setSalesPerosnId(int salesPerosnId) {
        this.salesPerosnId = salesPerosnId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
    
    
}
