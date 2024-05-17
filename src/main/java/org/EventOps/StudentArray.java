package org.EventOps;

import java.util.ArrayList;
import java.util.List;

public class StudentArray {
//create a static method that can be accessed from anywhere
    public static List<Student> studentArray =  new ArrayList<>();
//    public static StudentArray(){
//        this.studentArray = new ArrayList<>();
//    }
    public  static List<Student> getStudentArray(){
        return studentArray;
    }

//    add student only if the student is not already in the array
    public static void setStudentArray(Student newStudent){
        studentArray.add(newStudent);
    }
}
