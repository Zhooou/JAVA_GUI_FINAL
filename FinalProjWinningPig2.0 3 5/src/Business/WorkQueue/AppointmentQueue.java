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
public class AppointmentQueue {
    private ArrayList<AppointmentRequest> appointmentRequestList;
    
    public AppointmentQueue(){
        this.appointmentRequestList = new ArrayList();
    }

    public ArrayList<AppointmentRequest> getAppointmentRequestList() {
        return appointmentRequestList;
    }

    public void setAppointmentRequestList(ArrayList<AppointmentRequest> appointmentRequestList) {
        this.appointmentRequestList = appointmentRequestList;
    }
    
    
}
