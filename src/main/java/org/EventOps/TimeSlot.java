package org.EventOps;

import java.util.ArrayList;
import java.util.List;

public class TimeSlot {

    private int id;
    private String timeString;

//    stores student names, lets investigate later if names is the best approach of if we need to store the object
    private List<String> studentNames;
    private int assignedStudents;

//    Need to create two constructors; The first consructor is used when intitializing the time array and does not need
//
//    the students names. Later on we will be adding student names

    TimeSlot(int id, String timeString){
        this.id = id;
        this.timeString = timeString;
        this.studentNames = new ArrayList<>();
        this.assignedStudents = 0;
    }


//    TimeSlot(int id, String timeString, String  studentName){
//        this.id = id;
//        this.timeString = timeString;
//        this.studentNames = new ArrayList<>();
//        this.assignedStudents = 0;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTimeString() {
        return timeString;
    }

    public void setTimeString(String timeString) {
        this.timeString = timeString;
    }

    public List<String> getStudentNames() {
        return studentNames;
    }

    public void setStudentNames(String studentName) {
        this.studentNames.add(studentName);
    }

    public void setAssignedStudents(int assignedStudents) {
        this.assignedStudents = assignedStudents;
    }

    public int getAssignedStudents() {
        return assignedStudents;
    }

//        Pending to determine if we will need a toString method.
    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", timeString='" + timeString + '\'' +
                ", studentNames=" + studentNames +
                ", assignedStudents=" + assignedStudents +
                '}';
    }
}
