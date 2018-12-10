/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Appointment;

/**
 *
 * @author runyangzhou
 */
public class StudyRoom {
    private int number;
    private static int id = 100;
    
    public StudyRoom(){
        if(id % 100 == 4){
            id = id + 100 - 4;
        }
        id ++;
        this.number = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    
    @Override
    public String toString(){
        return "" + number;
    }
}
