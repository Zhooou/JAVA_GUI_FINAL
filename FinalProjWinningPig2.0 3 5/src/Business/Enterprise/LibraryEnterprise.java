/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Appointment.AppointmentTime;
import Business.Appointment.StudyRoomDirectory;
import Business.Book.BookDirectory;
import Business.Role.Role;
import Business.WorkQueue.AppointmentQueue;
import Business.WorkQueue.BookQueue;
import java.util.ArrayList;

/**
 *
 * @author runyangzhou
 */
public class LibraryEnterprise extends Enterprise{
    private BookQueue bookQueue;
    private BookDirectory bookDirectory;
    private AppointmentQueue appointmentQueue;
    private StudyRoomDirectory studyRoomDirectory;
    private AppointmentTime appointmentTime;
    
    public LibraryEnterprise(String name){
        super(name,Enterprise.EnterpriseType.Library);
        this.bookDirectory = new BookDirectory();
        this.studyRoomDirectory = new StudyRoomDirectory();
        this.appointmentTime = new AppointmentTime();
        
        appointmentQueue = new AppointmentQueue();
        bookQueue = new BookQueue();
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }

    public AppointmentTime getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(AppointmentTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }
    
    

    public BookDirectory getBookDirectory() {
        return bookDirectory;
    }

    public void setBookDirectory(BookDirectory bookDirectory) {
        this.bookDirectory = bookDirectory;
    }
    
    public BookQueue getBookQueue() {
        return bookQueue;
    }

    public void setBookQueue(BookQueue bookQueue) {
        this.bookQueue = bookQueue;
    }

    public AppointmentQueue getAppointmentQueue() {
        return appointmentQueue;
    }

    public void setAppointmentQueue(AppointmentQueue appointmentQueue) {
        this.appointmentQueue = appointmentQueue;
    }

    public StudyRoomDirectory getStudyRoomDirectory() {
        return studyRoomDirectory;
    }

    public void setStudyRoomDirectory(StudyRoomDirectory studyRoomDirectory) {
        this.studyRoomDirectory = studyRoomDirectory;
    }

    

}
