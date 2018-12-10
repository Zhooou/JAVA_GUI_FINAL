/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import java.util.ArrayList;

/**
 *
 * @author runyangzhou
 */
public class BookQueue {
    private ArrayList<BookRequest> bookRequestList;
    
    public BookQueue(){
        bookRequestList = new ArrayList();
    }

    public ArrayList<BookRequest> getBookRequestList() {
        return bookRequestList;
    }

    public void setBookRequestList(ArrayList<BookRequest> bookRequestList) {
        this.bookRequestList = bookRequestList;
    }

    
}
