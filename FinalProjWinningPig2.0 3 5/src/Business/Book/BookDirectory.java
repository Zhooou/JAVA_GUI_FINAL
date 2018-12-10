/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Book;

import java.util.ArrayList;

/**
 *
 * @author runyangzhou
 */
public class BookDirectory {
    private ArrayList<Book> bookList;
    
    public BookDirectory(){
        this.bookList = new ArrayList();
    }

    public ArrayList<Book> getBookList() {
        return bookList;
    }

    public void setBookList(ArrayList<Book> bookList) {
        this.bookList = bookList;
    }
}
