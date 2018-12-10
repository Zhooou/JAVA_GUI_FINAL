/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Book.Book;
import java.util.ArrayList;

/**
 *
 * @author runyangzhou
 */
public class BookRequest extends WorkRequest{
    private ArrayList<Book> bookList;
    private String result;
    
    @Override
    public String toString(){
        String s = "";
        for(Book book : bookList){
            s = s + book.getName() + "  ";
        }
        return s;
    }
    
    public BookRequest(){
        bookList = new ArrayList();
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public ArrayList<Book> getBookList() {
        return bookList;
    }

    public void setBookList(ArrayList<Book> bookList) {
        this.bookList = bookList;
    }
}
