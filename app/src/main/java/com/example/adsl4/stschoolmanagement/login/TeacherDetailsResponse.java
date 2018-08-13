
package com.example.adsl4.stschoolmanagement.login;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TeacherDetailsResponse implements Parcelable {

    @SerializedName("employeeImage")
    @Expose
    private String employeeImage;
    @SerializedName("fullName")
    @Expose
    private String fullName;
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
    @SerializedName("organization")
    @Expose
    private String organization;
    @SerializedName("branch")
    @Expose
    private String branch;
    @SerializedName("organizationContactNumber")
    @Expose
    private String organizationContactNumber;
    @SerializedName("organizationAddress")
    @Expose
    private String organizationAddress;
    @SerializedName("employeeDetailId")
    @Expose
    private Integer employeeDetailId;
    @SerializedName("branchId")
    @Expose
    private Integer branchId;
    @SerializedName("organizationId")
    @Expose
    private Integer organizationId;
    @SerializedName("userId")
    @Expose
    private String userId;

    public String getEmployeeImage() {
        return employeeImage;
    }

    public void setEmployeeImage(String employeeImage) {
        this.employeeImage = employeeImage;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public String getOrganizationContactNumber() {
        return organizationContactNumber;
    }

    public void setOrganizationContactNumber(String organizationContactNumber) {
        this.organizationContactNumber = organizationContactNumber;
    }

    public String getOrganizationAddress() {
        return organizationAddress;
    }

    public void setOrganizationAddress(String organizationAddress) {
        this.organizationAddress = organizationAddress;
    }

    public Integer getEmployeeDetailId() {
        return employeeDetailId;
    }

    public void setEmployeeDetailId(Integer employeeDetailId) {
        this.employeeDetailId = employeeDetailId;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString( this.employeeImage);
        dest.writeString(this.fullName);
        dest.writeString(this.employeeAddress);
        dest.writeString(this.employeeContactNumber);
        dest.writeString(this.email);
        dest.writeString(this.employeePost);
        dest.writeString(this.organization);
        dest.writeString(this.branch);
        dest.writeString(this.organizationContactNumber);
        dest.writeString(this.organizationAddress);
        dest.writeValue(this.employeeDetailId);
        dest.writeValue(this.branchId);
        dest.writeValue(this.organizationId);
        dest.writeString(this.userId);
    }

    public TeacherDetailsResponse() {
    }

    protected TeacherDetailsResponse(Parcel in) {
        this.employeeImage = in.readString();;
        this.fullName = in.readString();
        this.employeeAddress = in.readString();
        this.employeeContactNumber = in.readString();
        this.email = in.readString();;
        this.employeePost = in.readString();
        this.organization = in.readString();
        this.branch = in.readString();
        this.organizationContactNumber = in.readString();
        this.organizationAddress = in.readString();
        this.employeeDetailId = (Integer) in.readValue(Integer.class.getClassLoader());
        this.branchId = (Integer) in.readValue(Integer.class.getClassLoader());
        this.organizationId = (Integer) in.readValue(Integer.class.getClassLoader());
        this.userId = in.readString();
    }

    public static final Parcelable.Creator<TeacherDetailsResponse> CREATOR = new Parcelable.Creator<TeacherDetailsResponse>() {
        @Override
        public TeacherDetailsResponse createFromParcel(Parcel source) {
            return new TeacherDetailsResponse(source);
        }

        @Override
        public TeacherDetailsResponse[] newArray(int size) {
            return new TeacherDetailsResponse[size];
        }
    };
}
