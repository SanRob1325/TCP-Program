/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tcpclientapplication;

/**
 *
 * @author seanr
 */
public class ClassTime{
    private String dateTime;
    private String time;
    private String courseCode;
    private String roomNumClass;
    
    public ClassTime(String date,String time,String courseCode,String roomNum){
        this.dateTime =date;
        this.roomNumClass= roomNum;
        this.time =time;
        this.courseCode =courseCode;
    }
    public ClassTime(){
        
    }

    public String getDateTime() {
        return dateTime;
    }

    public String getTime() {
        return time;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getRoomNumClass() {
        return roomNumClass;
    }
}