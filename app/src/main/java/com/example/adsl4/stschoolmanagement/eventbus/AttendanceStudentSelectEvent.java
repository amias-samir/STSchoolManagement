package com.example.adsl4.stschoolmanagement.eventbus;

import com.example.adsl4.stschoolmanagement.teacherattendance.AttendanceDetails;

public class AttendanceStudentSelectEvent {

    public static class StudentAttendanceItemClick{

        private AttendanceDetails attendanceDetails;

        public StudentAttendanceItemClick(AttendanceDetails attendanceDetails) {
            this.attendanceDetails = attendanceDetails;
        }

        public AttendanceDetails getAttendanceListChild() {
            return attendanceDetails;
        }


    }



}
