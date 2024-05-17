package org.EventOps;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Scheduler {

//    takes a list of shifts and a list of students
//    private List<TimeSlot> timeArray;
//    private List<Student> studentArray;
//
//    public Scheduler (List<TimeSlot>  myArray, List<Student>  myStudents){
//        this.timeArray = myArray;
//        this.studentArray = myStudents;
//
//    }
//Improvements
//make sure you are observing maximum hours for students and student count per shift - maximum and minimum
//    If a shift has a super then you may not need to reasign a super to it.

//    for each shift store a variable that indicates whether a super has been assigned or not
//    whenever someone has been assigned to a shift, make sure the person is removed from the elligible students list
//    so that at the very end we can fill in the remaining slots with the remaining students
//    You may also remove them from the corresponding mini-arrays
    public static void scheduleStudents (){
//        Refresh the time arrray before each allocation

        for (TimeSlot shift :  TimeArray.getTimeArray()){

            System.out.println("1");


            List<Student> elligibleStudents = getElligibleStudents(shift, StudentArray.getStudentArray());

            if(elligibleStudents.isEmpty()){
                continue;
            }
            List<Student> supers = getSupers(elligibleStudents);
            List<Student> intermediate = getIntermediate(elligibleStudents);
            List<Student> beginners = getBeginner(elligibleStudents);

            if(!supers.isEmpty()){
//                Make sure you assign a super to this shift and increase the super hours by 2.
//                shift.setStudentNames(supers.get(0).getFirstName() + " " + supers.get(0).getLastName());
//                int currentHours = supers.get(0).getAllocatedHours();
//                supers.get(0).setAllocatedHours(currentHours + 2);

                Student currentStudent = supers.get(0);
                shift.setStudentNames(currentStudent.getFirstName() + " " + currentStudent.getLastName());

                System.out.println("in super condition " + shift.getStudentNames());

//                increment the number of students assigned to this shift
                int studentNumber = shift.getAssignedStudents();
                shift.setAssignedStudents(studentNumber + 1);

                int currentHours = currentStudent.getAllocatedHours();
                currentStudent.setAllocatedHours(currentHours + 2);


//                remove student from the elligible student list
                int id = currentStudent.getId();
                removeStudent(elligibleStudents, id);

                System.out.println(shift.toString());

            }else if (!intermediate.isEmpty()){
                Student currentStudent = intermediate.get(0);
                shift.setStudentNames(currentStudent.getFirstName() + " " + currentStudent.getLastName());
                //                increment the number of students assigned to this shift
                int studentNumber = shift.getAssignedStudents();
                shift.setAssignedStudents(studentNumber + 1);

                int currentHours = currentStudent.getAllocatedHours();
                currentStudent.setAllocatedHours(currentHours + 2);

                //                remove student from the elligible student list
                int id = currentStudent.getId();
                removeStudent(elligibleStudents, id);

                System.out.println("2");


            }
//            else{
//                Student currentStudent = beginners.get(0);
//                shift.setStudentNames(currentStudent.getFirstName() + " " + currentStudent.getLastName());
//
//                //                increment the number of students assigned to this shift
//                int studentNumber = shift.getAssignedStudents();
//                shift.setAssignedStudents(studentNumber + 1);
//
//                int currentHours = currentStudent.getAllocatedHours();
//                currentStudent.setAllocatedHours(currentHours + 2);
//
//                //                remove student from the elligible student list
//                int id = currentStudent.getId();
//                removeStudent(elligibleStudents, id);
//
//            }

//            fill in the remaining slots - REMOVE this hard coded value;

            System.out.println("3");

            int remainingSlot = 4 - shift.getAssignedStudents();
            int remainingStudents = elligibleStudents.size();
            int iterator = Math.min(remainingSlot, remainingStudents);
            for (int i =0; i < iterator; i ++){
                Student currentStudent = elligibleStudents.get(0);
                shift.setStudentNames(currentStudent.getFirstName() + " " + currentStudent.getLastName());

                //                increment the number of students assigned to this shift
                int studentNumber = shift.getAssignedStudents();
                shift.setAssignedStudents(studentNumber + 1);

                int currentHours = currentStudent.getAllocatedHours();
                currentStudent.setAllocatedHours(currentHours + 2);
            }
            System.out.println("In loop looop" + TimeArray.getTimeArray());
            System.out.println("4");

        }

        System.out.println("After looop" + TimeArray.getTimeArray());

        System.out.println("5");
    }

    public static List<Student> getElligibleStudents(TimeSlot shift,List<Student> studentArray ){

        List<Student> result  = new ArrayList<>();
        for(Student student : studentArray){
//            We want to get the students that selected this shift and the students who have not exhausted their hours
            if (student.getShifts().contains(shift.getId()) && student.getAllocatedHours() < student.getMaximumHours() ){
                result.add(student);
            }
        }
        System.out.println("6");
        return result;
    }

//    returns a list of supervisors from a general list of students
    public static List<Student> getSupers(List<Student> studentArray ){
        List<Student> result  = new ArrayList<>();
        for(Student student : studentArray){
            if (student.getLevel().equals("super")){
                result.add(student);
            }
        }
        System.out.println("7");
        return result;
    }


    //    returns a list of intermediate from a general list of students
    public static List<Student> getIntermediate(List<Student> studentArray ){
        List<Student> result  = new ArrayList<>();
        for(Student student : studentArray){
            if (student.getLevel().equals("medium")){
                result.add(student);
            }
        }
        System.out.println("8");
        return result;
    }

    //    returns a list of intermediate from a general list of students
    public static List<Student> getBeginner(List<Student> studentArray ){
        List<Student> result  = new ArrayList<>();
        for(Student student : studentArray){
            if (student.getLevel().equals("beginner")){
                result.add(student);
            }
        }
        System.out.println("9");
        return result;
    }

//    remove student so that we can later add the remaining students if we still have more slots
//    public static void removeStudent(List<Student> studentArray, int id ){
//        for(Student student : studentArray){
//            if(student.getId() == id){
//                studentArray.remove(student);
//            }
//        }
//
//        System.out.println("10");
//
//    }

    public static void removeStudent(List<Student> studentArray, int id) {
        Iterator<Student> iterator = studentArray.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getId() == id) {
                iterator.remove();
                break; // Exit the loop after removing the student
            }
        }
    }

}
