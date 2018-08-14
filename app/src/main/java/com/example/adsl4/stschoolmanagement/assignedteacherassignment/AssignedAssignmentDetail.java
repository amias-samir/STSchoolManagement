
package com.example.adsl4.stschoolmanagement.assignedteacherassignment;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AssignedAssignmentDetail implements Parcelable {

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
    private Double fullMarks;
    @SerializedName("passMarks")
    @Expose
    private Double passMarks;
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
    @SerializedName("class")
    @Expose
    private String _class;
    @SerializedName("subjectType")
    @Expose
    private String subjectType;
    @SerializedName("timestamp")
    @Expose
    private String timestamp;
    @SerializedName("organizationId")
    @Expose
    private Integer organizationId;
    @SerializedName("organization")
    @Expose
    private String organization;
    @SerializedName("branchId")
    @Expose
    private Integer branchId;
    @SerializedName("branch")
    @Expose
    private String branch;
    @SerializedName("batch")
    @Expose
    private String batch;
    @SerializedName("teacherClassPeriod")
    @Expose
    private String teacherClassPeriod;
    @SerializedName("teacherSubject")
    @Expose
    private String teacherSubject;
    @SerializedName("examSubject")
    @Expose
    private String examSubject;
    @SerializedName("assignment")
    @Expose
    private String assignment;
    @SerializedName("subjectExamMark")
    @Expose
    private Integer subjectExamMark;

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

    public Double getFullMarks() {
        return fullMarks;
    }

    public void setFullMarks(Double fullMarks) {
        this.fullMarks = fullMarks;
    }

    public Double getPassMarks() {
        return passMarks;
    }

    public void setPassMarks(Double passMarks) {
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

    public String getClass_() {
        return _class;
    }

    public void setClass_(String _class) {
        this._class = _class;
    }

    public String getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(String subjectType) {
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

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public Integer getBranchId() {
        return branchId;
    }

    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getTeacherClassPeriod() {
        return teacherClassPeriod;
    }

    public void setTeacherClassPeriod(String teacherClassPeriod) {
        this.teacherClassPeriod = teacherClassPeriod;
    }

    public String getTeacherSubject() {
        return teacherSubject;
    }

    public void setTeacherSubject(String teacherSubject) {
        this.teacherSubject = teacherSubject;
    }

    public String getExamSubject() {
        return examSubject;
    }

    public void setExamSubject(String examSubject) {
        this.examSubject = examSubject;
    }

    public String getAssignment() {
        return assignment;
    }

    public void setAssignment(String assignment) {
        this.assignment = assignment;
    }

    public Integer getSubjectExamMark() {
        return subjectExamMark;
    }

    public void setSubjectExamMark(Integer subjectExamMark) {
        this.subjectExamMark = subjectExamMark;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.classSubjectId);
        dest.writeValue(this.batchId);
        dest.writeValue(this.classId);
        dest.writeString(this.classSubjectName);
        dest.writeValue(this.fullMarks);
        dest.writeValue(this.passMarks);
        dest.writeValue(this.subjectTypeId);
        dest.writeValue(this.isActive);
        dest.writeValue(this.hasPractical);
        dest.writeString(this.createdBy);
        dest.writeString(this.createdDate);
        dest.writeString(this.updatedBy);
        dest.writeString(this.updatedDate);
        dest.writeString(this.approvedBy);
        dest.writeString(this.approvedDate);
        dest.writeString(this._class);
        dest.writeString(this.subjectType);
        dest.writeString(this.timestamp);
        dest.writeValue(this.organizationId);
        dest.writeString(this.organization);
        dest.writeValue(this.branchId);
        dest.writeString(this.branch);
        dest.writeString(this.batch);
        dest.writeString(this.teacherClassPeriod);
        dest.writeString(this.teacherSubject);
        dest.writeString(this.examSubject);
        dest.writeString(this.assignment);
        dest.writeValue(this.subjectExamMark);
    }

    public AssignedAssignmentDetail() {
    }

    protected AssignedAssignmentDetail(Parcel in) {
        this.classSubjectId = (Integer) in.readValue(Integer.class.getClassLoader());
        this.batchId = (Integer) in.readValue(Integer.class.getClassLoader());
        this.classId = (Integer) in.readValue(Integer.class.getClassLoader());
        this.classSubjectName = in.readString();
        this.fullMarks = (Double) in.readValue(Double.class.getClassLoader());
        this.passMarks = (Double) in.readValue(Double.class.getClassLoader());
        this.subjectTypeId = (Integer) in.readValue(Integer.class.getClassLoader());
        this.isActive = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.hasPractical = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.createdBy = in.readString();
        this.createdDate = in.readString();
        this.updatedBy = in.readString();
        this.updatedDate = in.readString();
        this.approvedBy = in.readString();
        this.approvedDate = in.readString();
        this._class = in.readString();
        this.subjectType = in.readString();
        this.timestamp = in.readString();
        this.organizationId = (Integer) in.readValue(Integer.class.getClassLoader());
        this.organization = in.readString();
        this.branchId = (Integer) in.readValue(Integer.class.getClassLoader());
        this.branch = in.readString();
        this.batch = in.readString();
        this.teacherClassPeriod = in.readString();
        this.teacherSubject = in.readString();
        this.examSubject = in.readString();
        this.assignment = in.readString();
        this.subjectExamMark = (Integer) in.readValue(Integer.class.getClassLoader());
    }

    public static final Parcelable.Creator<AssignedAssignmentDetail> CREATOR = new Parcelable.Creator<AssignedAssignmentDetail>() {
        @Override
        public AssignedAssignmentDetail createFromParcel(Parcel source) {
            return new AssignedAssignmentDetail(source);
        }

        @Override
        public AssignedAssignmentDetail[] newArray(int size) {
            return new AssignedAssignmentDetail[size];
        }
    };
}
