package org.EventOps;

import java.util.ArrayList;
import java.util.List;

public class TimeArray {

//    create an array that stores the times
//        what if we need to completely delete shift info

    private static List <TimeSlot> timeArray = new ArrayList<>();


    public static synchronized List<TimeSlot> getTimeArray(){

        return timeArray;
    }

    public static synchronized void setTimeArray(List<TimeSlot> newArray){
        timeArray = newArray;
    }
//    public static List<TimeSlot> getTimeArray(){
//
//        List<TimeSlot> array = new ArrayList<>();
//
//        array.add(new TimeSlot(1, "8-10am"));
//        array.add(new TimeSlot(2, "10-12pm"));
//        array.add(new TimeSlot(3, "12-2pm", new ArrayList<>()));
//        array.add(new TimeSlot(4, "2-4pm", new ArrayList<>()));
//        array.add(new TimeSlot(5, "4-6pm", new ArrayList<>()));
//        array.add(new TimeSlot(6, "6-8pm", new ArrayList<>()));
//        array.add(new TimeSlot(7, "8-10pm", new ArrayList<>()));
//        array.add(new TimeSlot(8, "10-12am", new ArrayList<>()));
//        array.add(new TimeSlot(9, "8-10am", new ArrayList<>()));
//        array.add(new TimeSlot(10, "10-12pm", new ArrayList<>()));
//        array.add(new TimeSlot(11, "12-2pm", new ArrayList<>()));
//        array.add(new TimeSlot(12, "2-4pm", new ArrayList<>()));
//        array.add(new TimeSlot(13, "4-6pm", new ArrayList<>()));
//        array.add(new TimeSlot(14, "6-8pm", new ArrayList<>()));
//        array.add(new TimeSlot(15, "8-10pm", new ArrayList<>()));
//        array.add(new TimeSlot(16, "10-12am", new ArrayList<>()));
//        array.add(new TimeSlot(17, "8-10am", new ArrayList<>()));
//        array.add(new TimeSlot(18, "10-12pm", new ArrayList<>()));
//        array.add(new TimeSlot(19, "12-2pm", new ArrayList<>()));
//        array.add(new TimeSlot(20, "2-4pm", new ArrayList<>()));
//        array.add(new TimeSlot(21, "4-6pm", new ArrayList<>()));
//        array.add(new TimeSlot(22, "6-8pm", new ArrayList<>()));
//        array.add(new TimeSlot(23, "8-10pm", new ArrayList<>()));
//        array.add(new TimeSlot(24, "10-12am", new ArrayList<>()));
//        array.add(new TimeSlot(25, "8-10am", new ArrayList<>()));
//        array.add(new TimeSlot(26, "10-12pm", new ArrayList<>()));
//        array.add(new TimeSlot(27, "12-2pm", new ArrayList<>()));
//        array.add(new TimeSlot(28, "2-4pm", new ArrayList<>()));
//        array.add(new TimeSlot(29, "4-6pm", new ArrayList<>()));
//        array.add(new TimeSlot(30, "6-8pm", new ArrayList<>()));
//        array.add(new TimeSlot(31, "8-10pm",new ArrayList<>()));
//        array.add(new TimeSlot(32, "10-12am", new ArrayList<>()));
//        array.add(new TimeSlot(33, "8-10am", new ArrayList<>()));
//        array.add(new TimeSlot(34, "10-12pm", new ArrayList<>()));
//        array.add(new TimeSlot(35, "12-2pm", new ArrayList<>()));
//        array.add(new TimeSlot(36, "2-4pm", new ArrayList<>()));
//        array.add(new TimeSlot(37, "4-6pm", new ArrayList<>()));
//        array.add(new TimeSlot(38, "6-8pm", new ArrayList<>()));
//        array.add(new TimeSlot(39, "8-10pm", new ArrayList<>()));
//        array.add(new TimeSlot(40, "10-12am", new ArrayList<>()));
//        array.add(new TimeSlot(41, "8-10am", new ArrayList<>()));
//        array.add(new TimeSlot(42, "10-12pm", new ArrayList<>()));
//        array.add(new TimeSlot(43, "12-2pm", new ArrayList<>()));
//        array.add(new TimeSlot(44, "2-4pm", new ArrayList<>()));
//        array.add(new TimeSlot(45, "4-6pm", new ArrayList<>()));
//        array.add(new TimeSlot(46, "6-8pm", new ArrayList<>()));
//        array.add(new TimeSlot(47, "8-10pm", new ArrayList<>()));
//        array.add(new TimeSlot(48, "10-12am", new ArrayList<>()));
//        array.add(new TimeSlot(49, "8-10am", new ArrayList<>()));
//        array.add(new TimeSlot(50, "10-12pm", new ArrayList<>()));
//        array.add(new TimeSlot(51, "12-2pm", new ArrayList<>()));
//        array.add(new TimeSlot(52, "2-4pm", new ArrayList<>()));
//        array.add(new TimeSlot(53, "4-6pm", new ArrayList<>()));
//        array.add(new TimeSlot(54, "6-8pm", new ArrayList<>()));
//        array.add(new TimeSlot(55, "8-10pm", new ArrayList<>()));
//        array.add(new TimeSlot(56, "10-12am", new ArrayList<>()));

//        return array;
//
//    }


}
