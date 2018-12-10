/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Appointment.Appointment;
import Business.Appointment.StudyRoom;

/**
 *
 * @author runyangzhou
 */
public class AppointmentRequest extends WorkRequest{
    private Appointment appointment;
    
    public AppointmentRequest(Appointment appointment){
        this.appointment = appointment;
    }
    
    @Override
    public String toString(){
        return this.appointment.toString();
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }
    
}
