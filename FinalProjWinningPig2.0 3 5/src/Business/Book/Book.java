/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Book;

/**
 *
 * @author runyangzhou
 */
public class Book {
    private String name;
    private int id;
    private int storage;
    private static int count = 0;
    
    public Book(String name){
        this.name = name;
        id = count;
        count ++;
    }

    public static int getCount() {
        return count;
    }    

    public static void setCount(int count) {
        Book.count = count;
    }
    
    public Book(String name, int storage){
        this.storage = storage;
        this.name = name;
        id = count;
        count ++;
    }
    
    @Override
    public String toString(){
        return this.name;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
