package com.example.adsl4.stschoolmanagement.login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by adsl4 on 4/26/18.
 */

public class StudentDetail {
    @SerializedName("studentImage")
    @Expose
    private String studentImage;
    @SerializedName("fullName")
    @Expose
    private String fullName;
    @SerializedName("guardianName")
    @Expose
    private String guardianName;
    @SerializedName("class")
    @Expose
    private String _class;
    @SerializedName("batch")
    @Expose
    private String batch;
    @SerializedName("section")
    @Expose
    private Object section;
    @SerializedName("rollNo")
    @Expose
    private Integer rollNo;
    @SerializedName("organization")
    @Expose
    private String organization;
    @SerializedName("branch")
    @Expose
    private String branch;
    @SerializedName("contactNumber")
    @Expose
    private String contactNumber;
    @SerializedName("organizationAddress")
    @Expose
    private String organizationAddress;
    @SerializedName("studentId")
    @Expose
    private Integer studentId;
    @SerializedName("branchId")
    @Expose
    private Integer branchId;
    @SerializedName("organizationId")
    @Expose
    private Integer organizationId;
    @SerializedName("classId")
    @Expose
    private Integer classId;
    @SerializedName("sectionId")
    @Expose
    private Integer sectionId;
    @SerializedName("batchId")
    @Expose
    private Integer batchId;
    @SerializedName("userId")
    @Expose
    private String userId;

    //For error

    @SerializedName("errorNumber")
    @Expose
    private Integer errorNumber;
    @SerializedName("errorMessage")
    @Expose
    private String errorMessage;
    @SerializedName("errorType")
    @Expose
    private String errorType;

//for Teacher
    @SerializedName("employeeImage")
    @Expose
    private String employeeImage;
    @SerializedName("employeeAddress")
    @Expose
    private String employeeAddress;
    @SerializedName("employeeContactNumber")
    @Expose
    private String employeeContactNumber;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("employeePost")
    @Expose
    private String employeePost;
    @SerializedName("organizationContactNumber")
    @Expose
    private String organizationContactNumber;
    @SerializedName("employeeDetailId")
    @Expose
    private Integer employeeDetailId;


    public String getStudentImage() {
        return studentImage;
    }

    public void setStudentImage(String studentImage) {
        this.studentImage = studentImage;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGuardianName() {
        return guardianName;
    }

    public void setGuardianName(String guardianName) {
        this.guardianName = guardianName;
    }

    public String getClass_() {
        return _class;
    }

    public void setClass_(String _class) {
        this._class = _class;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public Object getSection() {
        return section;
    }

    public void setSection(Object section) {
        this.section = section;
    }

    public Integer getRollNo() {
        return rollNo;
    }

    public void setRollNo(Integer rollNo) {
        this.rollNo = rollNo;
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

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getOrganizationAddress() {
        return organizationAddress;
    }

    public void setOrganizationAddress(String organizationAddress) {
        this.organizationAddress = organizationAddress;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getBranchId() {
        return branchId;
    }

    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
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

    public Integer getBatchId() {
        return batchId;
    }

    public void setBatchId(Integer batchId) {
        this.batchId = batchId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    //for error
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

    //for teacher
    public String getEmployeeImage() {
        return employeeImage;
    }

    public void setEmployeeImage(String employeeImage) {
        this.employeeImage = employeeImage;
    }


    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public String getEmployeeContactNumber() {
        return employeeContactNumber;
    }

    public void setEmployeeContactNumber(String employeeContactNumber) {
        this.employeeContactNumber = employeeContactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmployeePost() {
        return employeePost;
    }

    public void setEmployeePost(String employeePost) {
        this.employeePost = employeePost;
    }

    public String getOrganizationContactNumber() {
        return organizationContactNumber;
    }

    public void setOrganizationContactNumber(String organizationContactNumber) {
        this.organizationContactNumber = organizationContactNumber;
    }


    public Integer getEmployeeDetailId() {
        return employeeDetailId;
    }

    public void setEmployeeDetailId(Integer employeeDetailId) {
        this.employeeDetailId = employeeDetailId;
    }


}
