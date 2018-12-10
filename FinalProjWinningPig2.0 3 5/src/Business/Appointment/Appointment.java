/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Appointment;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author runyangzhou
 */
public class Appointment {
    private StudyRoom studyRoom;
    private String session;
    private Date date;
    
    public Appointment(Date date, String session){
        studyRoom = null;
        this.date = date;
        this.session = session;
    }
    
    @Override
    public String toString(){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String r = df.format(date);
        r = r + "  " + session;
        return r;
    }
    
    public Appointment(StudyRoom studyRoom, Date date, String session){
        this.studyRoom = studyRoom;
        this.date = date;
        this.session = session;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public StudyRoom getStudyRoom() {
        return studyRoom;
    }

    public void setStudyRoom(StudyRoom studyRoom) {
        this.studyRoom = studyRoom;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
