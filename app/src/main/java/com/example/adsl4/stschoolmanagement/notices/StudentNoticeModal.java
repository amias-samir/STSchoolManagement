
package com.example.adsl4.stschoolmanagement.notices;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StudentNoticeModal implements Parcelable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("displayName")
    @Expose
    private String displayName;
    @SerializedName("fontAwesomeIcon")
    @Expose
    private Object fontAwesomeIcon;
    @SerializedName("avatarURL")
    @Expose
    private Object avatarURL;
    @SerializedName("urlPath")
    @Expose
    private Object urlPath;
    @SerializedName("shortDesc")
    @Expose
    private String shortDesc;
    @SerializedName("fullDescription")
    @Expose
    private String fullDescription;
    @SerializedName("createdBy")
    @Expose
    private String createdBy;
    @SerializedName("fileName")
    @Expose
    private Object fileName;
    @SerializedName("createdDate")
    @Expose
    private String createdDate;
    @SerializedName("updatedBy")
    @Expose
    private Object updatedBy;
    @SerializedName("updatedDate")
    @Expose
    private Object updatedDate;
    @SerializedName("approvedBy")
    @Expose
    private Object approvedBy;
    @SerializedName("approvedDate")
    @Expose
    private Object approvedDate;
    @SerializedName("isPublished")
    @Expose
    private Boolean isPublished;
    @SerializedName("isActive")
    @Expose
    private Boolean isActive;
    @SerializedName("organizationId")
    @Expose
    private Integer organizationId;
    @SerializedName("branchId")
    @Expose
    private Integer branchId;
    @SerializedName("organization")
    @Expose
    private Object organization;
    @SerializedName("branch")
    @Expose
    private Object branch;
    @SerializedName("seenNotices")
    @Expose
    private Object seenNotices;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Object getFontAwesomeIcon() {
        return fontAwesomeIcon;
    }

    public void setFontAwesomeIcon(Object fontAwesomeIcon) {
        this.fontAwesomeIcon = fontAwesomeIcon;
    }

    public Object getAvatarURL() {
        return avatarURL;
    }

    public void setAvatarURL(Object avatarURL) {
        this.avatarURL = avatarURL;
    }

    public Object getUrlPath() {
        return urlPath;
    }

    public void setUrlPath(Object urlPath) {
        this.urlPath = urlPath;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Object getFileName() {
        return fileName;
    }

    public void setFileName(Object fileName) {
        this.fileName = fileName;
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

    public Object getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Object updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Object getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(Object approvedBy) {
        this.approvedBy = approvedBy;
    }

    public Object getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(Object approvedDate) {
        this.approvedDate = approvedDate;
    }

    public Boolean getIsPublished() {
        return isPublished;
    }

    public void setIsPublished(Boolean isPublished) {
        this.isPublished = isPublished;
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

    public Integer getBranchId() {
        return branchId;
    }

    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }

    public Object getOrganization() {
        return organization;
    }

    public void setOrganization(Object organization) {
        this.organization = organization;
    }

    public Object getBranch() {
        return branch;
    }

    public void setBranch(Object branch) {
        this.branch = branch;
    }

    public Object getSeenNotices() {
        return seenNotices;
    }

    public void setSeenNotices(Object seenNotices) {
        this.seenNotices = seenNotices;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.id);
        dest.writeString(this.displayName);
        dest.writeParcelable((Parcelable) this.fontAwesomeIcon, flags);
        dest.writeParcelable((Parcelable) this.avatarURL, flags);
        dest.writeParcelable((Parcelable) this.urlPath, flags);
        dest.writeString(this.shortDesc);
        dest.writeString(this.fullDescription);
        dest.writeString(this.createdBy);
        dest.writeParcelable((Parcelable) this.fileName, flags);
        dest.writeString(this.createdDate);
        dest.writeParcelable((Parcelable) this.updatedBy, flags);
        dest.writeParcelable((Parcelable) this.updatedDate, flags);
        dest.writeParcelable((Parcelable) this.approvedBy, flags);
        dest.writeParcelable((Parcelable) this.approvedDate, flags);
        dest.writeValue(this.isPublished);
        dest.writeValue(this.isActive);
        dest.writeValue(this.organizationId);
        dest.writeValue(this.branchId);
        dest.writeParcelable((Parcelable) this.organization, flags);
        dest.writeParcelable((Parcelable) this.branch, flags);
        dest.writeParcelable((Parcelable) this.seenNotices, flags);
    }

    public StudentNoticeModal() {
    }

    protected StudentNoticeModal(Parcel in) {
        this.id = (Integer) in.readValue(Integer.class.getClassLoader());
        this.displayName = in.readString();
        this.fontAwesomeIcon = in.readParcelable(Object.class.getClassLoader());
        this.avatarURL = in.readParcelable(Object.class.getClassLoader());
        this.urlPath = in.readParcelable(Object.class.getClassLoader());
        this.shortDesc = in.readString();
        this.fullDescription = in.readString();
        this.createdBy = in.readString();
        this.fileName = in.readParcelable(Object.class.getClassLoader());
        this.createdDate = in.readString();
        this.updatedBy = in.readParcelable(Object.class.getClassLoader());
        this.updatedDate = in.readParcelable(Object.class.getClassLoader());
        this.approvedBy = in.readParcelable(Object.class.getClassLoader());
        this.approvedDate = in.readParcelable(Object.class.getClassLoader());
        this.isPublished = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.isActive = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.organizationId = (Integer) in.readValue(Integer.class.getClassLoader());
        this.branchId = (Integer) in.readValue(Integer.class.getClassLoader());
        this.organization = in.readParcelable(Object.class.getClassLoader());
        this.branch = in.readParcelable(Object.class.getClassLoader());
        this.seenNotices = in.readParcelable(Object.class.getClassLoader());
    }

    public static final Parcelable.Creator<StudentNoticeModal> CREATOR = new Parcelable.Creator<StudentNoticeModal>() {
        @Override
        public StudentNoticeModal createFromParcel(Parcel source) {
            return new StudentNoticeModal(source);
        }

        @Override
        public StudentNoticeModal[] newArray(int size) {
            return new StudentNoticeModal[size];
        }
    };
}