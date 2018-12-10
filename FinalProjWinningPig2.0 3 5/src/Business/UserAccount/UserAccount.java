/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Person.Person;
import Business.Role.Role;
import Business.WorkQueue.AppointmentQueue;
import Business.WorkQueue.BookQueue;
import Business.WorkQueue.CoffeeQueue;

/**
 *
 * @author runyangzhou
 */
public class UserAccount {
    private String username;
    private String password;
    private Person person;
    private Role role;
    private BookQueue bookQueue;
    private CoffeeQueue coffeeQueue;
    private AppointmentQueue appointmentQueue;
    
    public UserAccount() {
        bookQueue = new BookQueue();
        coffeeQueue = new CoffeeQueue();
        appointmentQueue = new AppointmentQueue();
    }

    public AppointmentQueue getAppointmentQueue() {
        return appointmentQueue;
    }

    public void setAppointmentQueue(AppointmentQueue appointmentQueue) {
        this.appointmentQueue = appointmentQueue;
    }

    public CoffeeQueue getCoffeeQueue() {
        return coffeeQueue;
    }

    public void setCoffeeQueue(CoffeeQueue coffeeQueue) {
        this.coffeeQueue = coffeeQueue;
    }
    
    public BookQueue getBookQueue() {
        return bookQueue;
    }

    public void setBookQueue(BookQueue bookQueue) {
        this.bookQueue = bookQueue;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    
    @Override
    public String toString(){
        return this.username;
    }
}
