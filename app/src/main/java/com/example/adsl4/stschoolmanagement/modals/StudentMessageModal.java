
package com.example.adsl4.stschoolmanagement.modals;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StudentMessageModal {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("userId")
    @Expose
    private String userId;
    @SerializedName("displayName")
    @Expose
    private String displayName;
    @SerializedName("type")
    @Expose
    private Object type;
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
    @SerializedName("messageDescription")
    @Expose
    private String messageDescription;
    @SerializedName("messageFrom")
    @Expose
    private String messageFrom;
    @SerializedName("timeSpan")
    @Expose
    private Object timeSpan;
    @SerializedName("percentage")
    @Expose
    private Integer percentage;
    @SerializedName("timestamp")
    @Expose
    private String timestamp;
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
    @SerializedName("userMessageDetails")
    @Expose
    private Object userMessageDetails;
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
    private Object updatedDate;
    @SerializedName("approvedBy")
    @Expose
    private Object approvedBy;
    @SerializedName("approvedDate")
    @Expose
    private Object approvedDate;
    @SerializedName("viewUserMessages")
    @Expose
    private Object viewUserMessages;
    @SerializedName("roleIds")
    @Expose
    private Object roleIds;
    @SerializedName("userIds")
    @Expose
    private Object userIds;
    @SerializedName("batchIds")
    @Expose
    private Object batchIds;
    @SerializedName("classIds")
    @Expose
    private Object classIds;
    @SerializedName("sectionIds")
    @Expose
    private Object sectionIds;
    @SerializedName("studentIds")
    @Expose
    private Object studentIds;
    @SerializedName("batchId")
    @Expose
    private Integer batchId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Object getType() {
        return type;
    }

    public void setType(Object type) {
        this.type = type;
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

    public String getMessageDescription() {
        return messageDescription;
    }

    public void setMessageDescription(String messageDescription) {
        this.messageDescription = messageDescription;
    }

    public String getMessageFrom() {
        return messageFrom;
    }

    public void setMessageFrom(String messageFrom) {
        this.messageFrom = messageFrom;
    }

    public Object getTimeSpan() {
        return timeSpan;
    }

    public void setTimeSpan(Object timeSpan) {
        this.timeSpan = timeSpan;
    }

    public Integer getPercentage() {
        return percentage;
    }

    public void setPercentage(Integer percentage) {
        this.percentage = percentage;
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

    public Object getUserMessageDetails() {
        return userMessageDetails;
    }

    public void setUserMessageDetails(Object userMessageDetails) {
        this.userMessageDetails = userMessageDetails;
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

    public Object getViewUserMessages() {
        return viewUserMessages;
    }

    public void setViewUserMessages(Object viewUserMessages) {
        this.viewUserMessages = viewUserMessages;
    }

    public Object getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(Object roleIds) {
        this.roleIds = roleIds;
    }

    public Object getUserIds() {
        return userIds;
    }

    public void setUserIds(Object userIds) {
        this.userIds = userIds;
    }

    public Object getBatchIds() {
        return batchIds;
    }

    public void setBatchIds(Object batchIds) {
        this.batchIds = batchIds;
    }

    public Object getClassIds() {
        return classIds;
    }

    public void setClassIds(Object classIds) {
        this.classIds = classIds;
    }

    public Object getSectionIds() {
        return sectionIds;
    }

    public void setSectionIds(Object sectionIds) {
        this.sectionIds = sectionIds;
    }

    public Object getStudentIds() {
        return studentIds;
    }

    public void setStudentIds(Object studentIds) {
        this.studentIds = studentIds;
    }

    public Integer getBatchId() {
        return batchId;
    }

    public void setBatchId(Integer batchId) {
        this.batchId = batchId;
    }

}