package com.example.adsl4.stschoolmanagement.modals;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetSectionAsignmentModal {
    @SerializedName("sectionId")
    @Expose
    private Integer sectionId;
    @SerializedName("sectionName")
    @Expose
    private String sectionName;
    @SerializedName("isActive")
    @Expose
    private Boolean isActive;
    @SerializedName("classId")
    @Expose
    private Integer classId;
    @SerializedName("batchId")
    @Expose
    private Integer batchId;
    @SerializedName("organizationId")
    @Expose
    private Integer organizationId;
    @SerializedName("createdBy")
    @Expose
    private String createdBy;
    @SerializedName("createdDate")
    @Expose
    private String createdDate;
    @SerializedName("updatedBy")
    @Expose
    private Object updatedBy;
    @SerializedName("updatedDate")
    @Expose
    private String updatedDate;
    @SerializedName("approvedBy")
    @Expose
    private Object approvedBy;
    @SerializedName("approvedDate")
    @Expose
    private String approvedDate;
    @SerializedName("organization")
    @Expose
    private Object organization;
    @SerializedName("batch")
    @Expose
    private Object batch;
    @SerializedName("class")
    @Expose
    private Object _class;
    @SerializedName("branchId")
    @Expose
    private Integer branchId;
    @SerializedName("branch")
    @Expose
    private Object branch;
    @SerializedName("timestamp")
    @Expose
    private String timestamp;
    @SerializedName("hostelStudent")
    @Expose
    private Object hostelStudent;
    @SerializedName("studentScholarship")
    @Expose
    private Object studentScholarship;
    @SerializedName("studentConsation")
    @Expose
    private Object studentConsation;
    @SerializedName("teacherClassPeriod")
    @Expose
    private Object teacherClassPeriod;
    @SerializedName("studentClassDetail")
    @Expose
    private Object studentClassDetail;
    @SerializedName("assignment")
    @Expose
    private Object assignment;
    @SerializedName("studentAttendance")
    @Expose
    private Object studentAttendance;
    @SerializedName("feeSubmit")
    @Expose
    private Object feeSubmit;
    @SerializedName("feeTransaction")
    @Expose
    private Object feeTransaction;
    @SerializedName("busStudent")
    @Expose
    private Object busStudent;
    @SerializedName("attendance")
    @Expose
    private Object attendance;

    public Integer getSectionId() {
        return sectionId;
    }

    public void setSectionId(Integer sectionId) {
        this.sectionId = sectionId;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Integer getBatchId() {
        return batchId;
    }

    public void setBatchId(Integer batchId) {
        this.batchId = batchId;
    }

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
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

    public Object getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Object updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Object getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(Object approvedBy) {
        this.approvedBy = approvedBy;
    }

    public String getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(String approvedDate) {
        this.approvedDate = approvedDate;
    }

    public Object getOrganization() {
        return organization;
    }

    public void setOrganization(Object organization) {
        this.organization = organization;
    }

    public Object getBatch() {
        return batch;
    }

    public void setBatch(Object batch) {
        this.batch = batch;
    }

    public Object getClass_() {
        return _class;
    }

    public void setClass_(Object _class) {
        this._class = _class;
    }

    public Integer getBranchId() {
        return branchId;
    }

    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }

    public Object getBranch() {
        return branch;
    }

    public void setBranch(Object branch) {
        this.branch = branch;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Object getHostelStudent() {
        return hostelStudent;
    }

    public void setHostelStudent(Object hostelStudent) {
        this.hostelStudent = hostelStudent;
    }

    public Object getStudentScholarship() {
        return studentScholarship;
    }

    public void setStudentScholarship(Object studentScholarship) {
        this.studentScholarship = studentScholarship;
    }

    public Object getStudentConsation() {
        return studentConsation;
    }

    public void setStudentConsation(Object studentConsation) {
        this.studentConsation = studentConsation;
    }

    public Object getTeacherClassPeriod() {
        return teacherClassPeriod;
    }

    public void setTeacherClassPeriod(Object teacherClassPeriod) {
        this.teacherClassPeriod = teacherClassPeriod;
    }

    public Object getStudentClassDetail() {
        return studentClassDetail;
    }

    public void setStudentClassDetail(Object studentClassDetail) {
        this.studentClassDetail = studentClassDetail;
    }

    public Object getAssignment() {
        return assignment;
    }

    public void setAssignment(Object assignment) {
        this.assignment = assignment;
    }

    public Object getStudentAttendance() {
        return studentAttendance;
    }

    public void setStudentAttendance(Object studentAttendance) {
        this.studentAttendance = studentAttendance;
    }

    public Object getFeeSubmit() {
        return feeSubmit;
    }

    public void setFeeSubmit(Object feeSubmit) {
        this.feeSubmit = feeSubmit;
    }

    public Object getFeeTransaction() {
        return feeTransaction;
    }

    public void setFeeTransaction(Object feeTransaction) {
        this.feeTransaction = feeTransaction;
    }

    public Object getBusStudent() {
        return busStudent;
    }

    public void setBusStudent(Object busStudent) {
        this.busStudent = busStudent;
    }

    public Object getAttendance() {
        return attendance;
    }

    public void setAttendance(Object attendance) {
        this.attendance = attendance;
    }
}
