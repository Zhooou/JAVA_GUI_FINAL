/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Appointment;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author runyangzhou
 */
public class AppointmentTime {
    Date date;
    private ArrayList<Date> dateList;
    private ArrayList<String> sessionList;
    
    public AppointmentTime(){
        
        dateList = new ArrayList();
        sessionList = new ArrayList();
        
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        
        try
        {
           date = df.parse("2018-12-01");
        }
        catch(ParseException d){
           
        }
        
        Calendar dateCalendar = Calendar.getInstance();
        dateCalendar.setTime(date);
        
        for(int i = 0; i< 30; i++){
            dateCalendar.add(Calendar.DAY_OF_YEAR, 1);
           
            dateList.add(dateCalendar.getTime());
        }
        
        sessionList.add("Morning");
        sessionList.add("Afternoon");
        
    }

    public ArrayList<Date> getDateList() {
        return dateList;
    }

    public void setDateList(ArrayList<Date> dateList) {
        this.dateList = dateList;
    }

    public ArrayList<String> getSessionList() {
        return sessionList;
    }

    public void setSessionList(ArrayList<String> sessionList) {
        this.sessionList = sessionList;
    }
    
    
    
    
}

