/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Appointment;

import java.util.ArrayList;

/**
 *
 * @author runyangzhou
 */
public class StudyRoomDirectory {
    private ArrayList<StudyRoom> studyRoomList;
    
    public StudyRoomDirectory(){
        this.studyRoomList = new ArrayList();
        for(int i = 0; i < 16; i++){
            StudyRoom studyRoom = new StudyRoom();
            this.studyRoomList.add(studyRoom);
        }
    }

    public ArrayList<StudyRoom> getStudyRoomList() {
        return studyRoomList;
    }

    public void setStudyRoomList(ArrayList<StudyRoom> studyRoomList) {
        this.studyRoomList = studyRoomList;
    }
    
    
}
