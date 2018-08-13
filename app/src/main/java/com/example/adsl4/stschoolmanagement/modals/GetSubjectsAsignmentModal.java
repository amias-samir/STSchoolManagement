package com.example.adsl4.stschoolmanagement.modals;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetSubjectsAsignmentModal {
    @SerializedName("classSubjectId")
    @Expose
    private Integer classSubjectId;
    @SerializedName("batchId")
    @Expose
    private Integer batchId;
    @SerializedName("classId")
    @Expose
    private Integer classId;
    @SerializedName("classSubjectName")
    @Expose
    private String classSubjectName;
    @SerializedName("fullMarks")
    @Expose
    private Integer fullMarks;
    @SerializedName("passMarks")
    @Expose
    private Integer passMarks;
    @SerializedName("subjectTypeId")
    @Expose
    private Integer subjectTypeId;
    @SerializedName("isActive")
    @Expose
    private Boolean isActive;
    @SerializedName("hasPractical")
    @Expose
    private Boolean hasPractical;
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
    @SerializedName("class")
    @Expose
    private Object _class;
    @SerializedName("subjectType")
    @Expose
    private Object subjectType;
    @SerializedName("timestamp")
    @Expose
    private String timestamp;
    @SerializedName("organizationId")
    @Expose
    private Integer organizationId;
    @SerializedName("organization")
    @Expose
    private Object organization;
    @SerializedName("branchId")
    @Expose
    private Integer branchId;
    @SerializedName("branch")
    @Expose
    private Object branch;
    @SerializedName("batch")
    @Expose
    private Object batch;
    @SerializedName("teacherClassPeriod")
    @Expose
    private Object teacherClassPeriod;
    @SerializedName("teacherSubject")
    @Expose
    private Object teacherSubject;
    @SerializedName("examSubject")
    @Expose
    private Object examSubject;
    @SerializedName("assignment")
    @Expose
    private Object assignment;
    @SerializedName("subjectExamMark")
    @Expose
    private Object subjectExamMark;

    public Integer getClassSubjectId() {
        return classSubjectId;
    }

    public void setClassSubjectId(Integer classSubjectId) {
        this.classSubjectId = classSubjectId;
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

    public String getClassSubjectName() {
        return classSubjectName;
    }

    public void setClassSubjectName(String classSubjectName) {
        this.classSubjectName = classSubjectName;
    }

    public Integer getFullMarks() {
        return fullMarks;
    }

    public void setFullMarks(Integer fullMarks) {
        this.fullMarks = fullMarks;
    }

    public Integer getPassMarks() {
        return passMarks;
    }

    public void setPassMarks(Integer passMarks) {
        this.passMarks = passMarks;
    }

    public Integer getSubjectTypeId() {
        return subjectTypeId;
    }

    public void setSubjectTypeId(Integer subjectTypeId) {
        this.subjectTypeId = subjectTypeId;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Boolean getHasPractical() {
        return hasPractical;
    }

    public void setHasPractical(Boolean hasPractical) {
        this.hasPractical = hasPractical;
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

    public Object getClass_() {
        return _class;
    }

    public void setClass_(Object _class) {
        this._class = _class;
    }

    public Object getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(Object subjectType) {
        this.subjectType = subjectType;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public Object getOrganization() {
        return organization;
    }

    public void setOrganization(Object organization) {
        this.organization = organization;
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

    public Object getSubjectExamMark() {
        return subjectExamMark;
    }

    public void setSubjectExamMark(Object subjectExamMark) {
        this.subjectExamMark = subjectExamMark;
    }
}
