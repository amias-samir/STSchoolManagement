package com.example.adsl4.stschoolmanagement.teacherattendance;

public class AttendanceDetails {
    StudentAttendance studentAttendance;
    int childPosition;
    String attendanceStatus;

    public AttendanceDetails(StudentAttendance studentAttendance, int childPosition, String attendanceStatus) {
        this.studentAttendance = studentAttendance;
        this.childPosition = childPosition;
        this.attendanceStatus = attendanceStatus;
    }

    public StudentAttendance getStudentAttendance() {
        return studentAttendance;
    }

    public void setStudentAttendance(StudentAttendance studentAttendance) {
        this.studentAttendance = studentAttendance;
    }

    public int getChildPosition() {
        return childPosition;
    }

    public void setChildPosition(int childPosition) {
        this.childPosition = childPosition;
    }

    public String getAttendanceStatus() {
        return attendanceStatus;
    }

    public void setAttendanceStatus(String attendanceStatus) {
        this.attendanceStatus = attendanceStatus;
    }
}