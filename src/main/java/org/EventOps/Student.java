package org.EventOps;

import java.util.List;

public class Student {
//     Describes a student object

    private static int idCounter = 0;
    private  int id ;
    private String firstName;
    private String lastName;
    private String netId;
    private int maximumHours;
    private int allocatedHours;
    private String level;
    private List<Integer> shifts;
    Student (String firstName, String lastName, String netId, int hours, String level, List<Integer> shifts){

        this.firstName = firstName;
        this.lastName = lastName;
        this.netId = netId;
        this.maximumHours = hours;
        this.level = level;
        this.shifts = shifts;
        this.allocatedHours = 0;
        this.id = generateId();



    }

    private static synchronized int generateId(){
        return idCounter++;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setNetId(String netId) {
        this.netId = netId;
    }

    public String getNetId() {
        return netId;
    }

    public void setMaximumHours(int hours) {
        this.maximumHours = hours;
    }
    public int getMaximumHours(){
        return maximumHours;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLevel() {
        return level;
    }

    public List<Integer> getShifts() {
        return shifts;
    }

    public void setShifts(List<Integer> shifts) {
        this.shifts = shifts;
    }

    public void setAllocatedHours(int allocatedHours) {
        this.allocatedHours = allocatedHours;
    }

    public int getAllocatedHours() {
        return allocatedHours;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName= '" + firstName +'\'' +
                ", lastName='" + lastName + '\'' +
                ", netId='" + netId + '\'' +
                ", maximumHours=" + maximumHours +
                ", level='" + level + '\'' +
                ", shifts=" + shifts +
                ", allocatedHours=" + allocatedHours +
                '}';
    }
}
