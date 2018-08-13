package com.example.adsl4.stschoolmanagement.modals;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by adsl4 on 5/18/18.
 */

public class StudentAssignmentModal {
    @SerializedName("assignmentId")
    @Expose
    private Integer assignmentId;
    @SerializedName("organizationId")
    @Expose
    private Integer organizationId;
    @SerializedName("branchId")
    @Expose
    private Integer branchId;
    @SerializedName("batchId")
    @Expose
    private Integer batchId;
    @SerializedName("classId")
    @Expose
    private Integer classId;
    @SerializedName("sectionId")
    @Expose
    private Integer sectionId;
    @SerializedName("assignedDate")
    @Expose
    private String assignedDate;
    @SerializedName("employeeDetailId")
    @Expose
    private Integer employeeDetailId;
    @SerializedName("classSubjectId")
    @Expose
    private Integer classSubjectId;
    @SerializedName("assignmentName")
    @Expose
    private String assignmentName;
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
    @SerializedName("branch")
    @Expose
    private Object branch;
    @SerializedName("class")
    @Expose
    private Object _class;
    @SerializedName("section")
    @Expose
    private Object section;
    @SerializedName("employeeDetail")
    @Expose
    private Object employeeDetail;
    @SerializedName("classSubject")
    @Expose
    private Object classSubject;

    public Integer getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(Integer assignmentId) {
        this.assignmentId = assignmentId;
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

    public String getAssignedDate() {
        return assignedDate;
    }

    public void setAssignedDate(String assignedDate) {
        this.assignedDate = assignedDate;
    }

    public Integer getEmployeeDetailId() {
        return employeeDetailId;
    }

    public void setEmployeeDetailId(Integer employeeDetailId) {
        this.employeeDetailId = employeeDetailId;
    }

    public Integer getClassSubjectId() {
        return classSubjectId;
    }

    public void setClassSubjectId(Integer classSubjectId) {
        this.classSubjectId = classSubjectId;
    }

    public String getAssignmentName() {
        return assignmentName;
    }

    public void setAssignmentName(String assignmentName) {
        this.assignmentName = assignmentName;
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

    public Object getBranch() {
        return branch;
    }

    public void setBranch(Object branch) {
        this.branch = branch;
    }

    public Object getClass_() {
        return _class;
    }

    public void setClass_(Object _class) {
        this._class = _class;
    }

    public Object getSection() {
        return section;
    }

    public void setSection(Object section) {
        this.section = section;
    }

    public Object getEmployeeDetail() {
        return employeeDetail;
    }

    public void setEmployeeDetail(Object employeeDetail) {
        this.employeeDetail = employeeDetail;
    }

    public Object getClassSubject() {
        return classSubject;
    }

    public void setClassSubject(Object classSubject) {
        this.classSubject = classSubject;
    }
}
