package com.example.adsl4.stschoolmanagement.modals;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetClassAsignmentModal {
    @SerializedName("classId")
    @Expose
    private Integer classId;
    @SerializedName("className")
    @Expose
    private String className;
    @SerializedName("isActive")
    @Expose
    private Boolean isActive;
    @SerializedName("organizationId")
    @Expose
    private Integer organizationId;
    @SerializedName("batchId")
    @Expose
    private Integer batchId;
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
    @SerializedName("timestamp")
    @Expose
    private String timestamp;
    @SerializedName("branchId")
    @Expose
    private Integer branchId;
    @SerializedName("branch")
    @Expose
    private Object branch;
    @SerializedName("batch")
    @Expose
    private Object batch;
    @SerializedName("section")
    @Expose
    private Object section;
    @SerializedName("classSubject")
    @Expose
    private Object classSubject;
    @SerializedName("studentDetail")
    @Expose
    private Object studentDetail;
    @SerializedName("attendance")
    @Expose
    private Object attendance;
    @SerializedName("hostelStudent")
    @Expose
    private Object hostelStudent;
    @SerializedName("studentScholarship")
    @Expose
    private Object studentScholarship;
    @SerializedName("studentConsation")
    @Expose
    private Object studentConsation;
    @SerializedName("classTeacher")
    @Expose
    private Object classTeacher;
    @SerializedName("studentClassDetail")
    @Expose
    private Object studentClassDetail;
    @SerializedName("subjectExamMark")
    @Expose
    private Object subjectExamMark;
    @SerializedName("examSubject")
    @Expose
    private Object examSubject;
    @SerializedName("assignment")
    @Expose
    private Object assignment;
    @SerializedName("studentAttendance")
    @Expose
    private Object studentAttendance;
    @SerializedName("feeDetail")
    @Expose
    private Object feeDetail;
    @SerializedName("feeSubmit")
    @Expose
    private Object feeSubmit;
    @SerializedName("feeTransaction")
    @Expose
    private Object feeTransaction;
    @SerializedName("busStudent")
    @Expose
    private Object busStudent;
    @SerializedName("bookSetting")
    @Expose
    private Object bookSetting;
    @SerializedName("teacherClassPeriod")
    @Expose
    private Object teacherClassPeriod;
    @SerializedName("teacherSubject")
    @Expose
    private Object teacherSubject;

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public Integer getBatchId() {
        return batchId;
    }

    public void setBatchId(Integer batchId) {
        this.batchId = batchId;
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

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
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

    public Object getBatch() {
        return batch;
    }

    public void setBatch(Object batch) {
        this.batch = batch;
    }

    public Object getSection() {
        return section;
    }

    public void setSection(Object section) {
        this.section = section;
    }

    public Object getClassSubject() {
        return classSubject;
    }

    public void setClassSubject(Object classSubject) {
        this.classSubject = classSubject;
    }

    public Object getStudentDetail() {
        return studentDetail;
    }

    public void setStudentDetail(Object studentDetail) {
        this.studentDetail = studentDetail;
    }

    public Object getAttendance() {
        return attendance;
    }

    public void setAttendance(Object attendance) {
        this.attendance = attendance;
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

    public Object getClassTeacher() {
        return classTeacher;
    }

    public void setClassTeacher(Object classTeacher) {
        this.classTeacher = classTeacher;
    }

    public Object getStudentClassDetail() {
        return studentClassDetail;
    }

    public void setStudentClassDetail(Object studentClassDetail) {
        this.studentClassDetail = studentClassDetail;
    }

    public Object getSubjectExamMark() {
        return subjectExamMark;
    }

    public void setSubjectExamMark(Object subjectExamMark) {
        this.subjectExamMark = subjectExamMark;
    }

    public Object getExamSubject() {
        return examSubject;
    }

    public void setExamSubject(Object examSubject) {
        this.examSubject = examSubject;
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

    public Object getFeeDetail() {
        return feeDetail;
    }

    public void setFeeDetail(Object feeDetail) {
        this.feeDetail = feeDetail;
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

    public Object getBookSetting() {
        return bookSetting;
    }

    public void setBookSetting(Object bookSetting) {
        this.bookSetting = bookSetting;
    }

    public Object getTeacherClassPeriod() {
        return teacherClassPeriod;
    }

    public void setTeacherClassPeriod(Object teacherClassPeriod) {
        this.teacherClassPeriod = teacherClassPeriod;
    }

    public Object getTeacherSubject() {
        return teacherSubject;
    }

    public void setTeacherSubject(Object teacherSubject) {
        this.teacherSubject = teacherSubject;
    }

}
