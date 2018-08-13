
package com.example.adsl4.stschoolmanagement.modals;

import com.google.gson.annotations.SerializedName;

public class TeacherAssignmentModal {

    @SerializedName("OrganizationId")
    private Integer orgnization_id;

    @SerializedName("BranchId")
    private Integer branch_id;

    @SerializedName("BatchId")
    private Integer batchId;

    @SerializedName("ClassId")
    private Integer classId;

    @SerializedName("SectionId")
    private Integer sectionId;

    @SerializedName("AssignedDate")
    private String assignmentDate;

    @SerializedName("EmployeeDetailId")
    private Integer empId;

    @SerializedName("ClassSubjectId")
    private Integer subId;

    @SerializedName("AssignmentName")
    private String assignName;

    @SerializedName("CreatedBy")
    private String userId;

    @SerializedName("CreatedDate")
    private String createdDate;

    public TeacherAssignmentModal(Integer orgnization_id, Integer branch_id, Integer batchId, Integer classId, Integer sectionId, String assignmentDate, Integer empId, Integer subId, String assignName, String userId, String createdDate) {
        this.orgnization_id = orgnization_id;
        this.branch_id = branch_id;
        this.batchId = batchId;
        this.classId = classId;
        this.sectionId = sectionId;
        this.assignmentDate = assignmentDate;
        this.empId = empId;
        this.subId = subId;
        this.assignName = assignName;
        this.userId = userId;
        this.createdDate = createdDate;
    }


    public Integer getOrgnization_id() {
        return orgnization_id;
    }

    public void setOrgnization_id(Integer orgnization_id) {
        this.orgnization_id = orgnization_id;
    }

    public Integer getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(Integer branch_id) {
        this.branch_id = branch_id;
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

    public String getAssignmentDate() {
        return assignmentDate;
    }

    public void setAssignmentDate(String assignmentDate) {
        this.assignmentDate = assignmentDate;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public Integer getSubId() {
        return subId;
    }

    public void setSubId(Integer subId) {
        this.subId = subId;
    }

    public String getAssignName() {
        return assignName;
    }

    public void setAssignName(String assignName) {
        this.assignName = assignName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }
}