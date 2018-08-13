
package com.example.adsl4.stschoolmanagement.teacherattendance;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TeacherAttendanceResponse {

    @SerializedName("attendanceId")
    @Expose
    private Integer attendanceId;
    @SerializedName("employeeDetailId")
    @Expose
    private Integer employeeDetailId;
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
    @SerializedName("day")
    @Expose
    private String day;
    @SerializedName("attendanceDate")
    @Expose
    private String attendanceDate;
    @SerializedName("employeeDetail")
    @Expose
    private String employeeDetail;
    @SerializedName("batch")
    @Expose
    private String batch;
    @SerializedName("classes")
    @Expose
    private String classes;
    @SerializedName("section")
    @Expose
    private String section;
    @SerializedName("organization")
    @Expose
    private String organization;
    @SerializedName("branch")
    @Expose
    private String branch;
    @SerializedName("studentAttendance")
    @Expose
    private String studentAttendance;
    @SerializedName("studentAttendances")
    @Expose
    private List<StudentAttendance> studentAttendances = null;

    public Integer getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(Integer attendanceId) {
        this.attendanceId = attendanceId;
    }

    public Integer getEmployeeDetailId() {
        return employeeDetailId;
    }

    public void setEmployeeDetailId(Integer employeeDetailId) {
        this.employeeDetailId = employeeDetailId;
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

    public String getEmployeeDetail() {
        return employeeDetail;
    }

    public void setEmployeeDetail(String employeeDetail) {
        this.employeeDetail = employeeDetail;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
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

    public String getStudentAttendance() {
        return studentAttendance;
    }

    public void setStudentAttendance(String studentAttendance) {
        this.studentAttendance = studentAttendance;
    }

    public List<StudentAttendance> getStudentAttendances() {
        return studentAttendances;
    }

    public void setStudentAttendances(List<StudentAttendance> studentAttendances) {
        this.studentAttendances = studentAttendances;
    }

}
