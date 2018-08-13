
package com.example.adsl4.stschoolmanagement.modals;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StudentAttendanceModal {

    @SerializedName("studentAttendanceId")
    @Expose
    private Integer studentAttendanceId;
    @SerializedName("attendanceId")
    @Expose
    private Integer attendanceId;
    @SerializedName("studentId")
    @Expose
    private Integer studentId;
    @SerializedName("studentStatus")
    @Expose
    private String studentStatus;

    //Error

    @SerializedName("errorNumber")
    @Expose
    private Integer errorNumber;
    @SerializedName("errorMessage")
    @Expose
    private String errorMessage;
    @SerializedName("errorType")
    @Expose
    private String errorType;

    public Integer getStudentAttendanceId() {
        return studentAttendanceId;
    }

    public void setStudentAttendanceId(Integer studentAttendanceId) {
        this.studentAttendanceId = studentAttendanceId;
    }

    public Integer getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(Integer attendanceId) {
        this.attendanceId = attendanceId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentStatus() {
        return studentStatus;
    }

    public void setStudentStatus(String studentStatus) {
        this.studentStatus = studentStatus;
    }

    //error
    public Integer getErrorNumber() {
        return errorNumber;
    }

    public void setErrorNumber(Integer errorNumber) {
        this.errorNumber = errorNumber;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }


}