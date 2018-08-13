package com.example.adsl4.stschoolmanagement.adapters;

/**
 * Created by adsl4 on 11/28/17.
 */

public class ListItemStudentAttendance {

    private int attenDay;
    private String presentStatus;

    public int getAttenDay() {
        return attenDay;
    }

    public String getPresentStatus() {
        return presentStatus;
    }

    public ListItemStudentAttendance(int attenDay, String presentStatus) {
        this.attenDay = attenDay;
        this.presentStatus = presentStatus;
    }
}
