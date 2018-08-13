
package com.example.adsl4.stschoolmanagement.teacherattendance;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StudentAttendance {

    @SerializedName("studentAttendanceId")
    @Expose
    private Integer studentAttendanceId;
    @SerializedName("attendanceId")
    @Expose
    private Integer attendanceId;
    @SerializedName("studentId")
    @Expose
    private Integer studentId;
    @SerializedName("batchId")
    @Expose
    private Integer batchId;
    @SerializedName("classId")
    @Expose
    private Integer classId;
    @SerializedName("sectionId")
    @Expose
    private Integer sectionId;
    @SerializedName("organizationId")
    @Expose
    private Integer organizationId;
    @SerializedName("branchId")
    @Expose
    private Integer branchId;
    @SerializedName("rollNo")
    @Expose
    private Integer rollNo;
    @SerializedName("studentStatus")
    @Expose
    private String studentStatus;
    @SerializedName("day")
    @Expose
    private String day;
    @SerializedName("attendanceDate")
    @Expose
    private String attendanceDate;
    @SerializedName("remarks")
    @Expose
    private String remarks;
    @SerializedName("timestamp")
    @Expose
    private String timestamp;
    @SerializedName("createdBy")
    @Expose
    private String createdBy;
    @SerializedName("createdDate")
    @Expose
    private String createdDate;
    @SerializedName("updatedBy")
    @Expose
    private String updatedBy;
    @SerializedName("updatedDate")
    @Expose
    private String updatedDate;
    @SerializedName("approvedBy")
    @Expose
    private String approvedBy;
    @SerializedName("approvedDate")
    @Expose
    private String approvedDate;
    @SerializedName("studentDetail")
    @Expose
    private String studentDetail;
    @SerializedName("batch")
    @Expose
    private Integer batch;
    @SerializedName("class")
    @Expose
    private String _class;
    @SerializedName("section")
    @Expose
    private String section;
    @SerializedName("organization")
    @Expose
    private String organization;
    @SerializedName("branch")
    @Expose
    private String branch;
    @SerializedName("attendance")
    @Expose
    private Integer attendance;
    @SerializedName("studentName")
    @Expose
    private String studentName;
    @SerializedName("sectionName")
    @Expose
    private String sectionName;

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

    public Integer getBatchId() {
        return batchId;
    }

    public void setBatchId(Integer batchId) {
        this.batchId = batchId;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Integer getSectionId() {
        return sectionId;
    }

    public void setSectionId(Integer sectionId) {
        this.sectionId = sectionId;
    }

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public Integer getBranchId() {
        return branchId;
    }

    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }

    public Integer getRollNo() {
        return rollNo;
    }

    public void setRollNo(Integer rollNo) {
        this.rollNo = rollNo;
    }

    public String getStudentStatus() {
        return studentStatus;
    }

    public void setStudentStatus(String studentStatus) {
        this.studentStatus = studentStatus;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(String attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }

    public String getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(String approvedDate) {
        this.approvedDate = approvedDate;
    }

    public String getStudentDetail() {
        return studentDetail;
    }

    public void setStudentDetail(String studentDetail) {
        this.studentDetail = studentDetail;
    }

    public Integer getBatch() {
        return batch;
    }

    public void setBatch(Integer batch) {
        this.batch = batch;
    }

    public String getClass_() {
        return _class;
    }

    public void setClass_(String _class) {
        this._class = _class;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public Integer getAttendance() {
        return attendance;
    }

    public void setAttendance(Integer attendance) {
        this.attendance = attendance;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

}
