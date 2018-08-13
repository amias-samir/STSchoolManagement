package com.example.adsl4.stschoolmanagement.modals;

public class MessageToAdminModal {

    private Integer id;
    private String userId;
    private String displayName;
    private Object type;
    private Object fontAwesomeIcon;
    private Object avatarURL;
    private Object urlPath;
    private String shortDesc;
    private String messageDescription;
    private String messageFrom;
    private Object timeSpan;
    private Integer percentage;
    private String timestamp;
    private Integer organizationId;
    private Integer branchId;
    private Object organization;
    private Object branch;
    private Object userMessageDetails;
    private String createdBy;
    private String createdDate;
    private Object updatedBy;
    private Object updatedDate;
    private Object approvedBy;
    private Object approvedDate;
    private Object viewUserMessages;
    private Object roleIds;
    private Object userIds;
    private Object batchIds;
    private Object classIds;
    private Object sectionIds;
    private Object studentIds;
    private Integer batchId;

    public MessageToAdminModal(Integer id, String userId, String displayName, Object type, Object fontAwesomeIcon, Object avatarURL, Object urlPath, String shortDesc, String messageDescription, String messageFrom, Object timeSpan, Integer percentage, String timestamp, Integer organizationId, Integer branchId, Object organization, Object branch, Object userMessageDetails, String createdBy, String createdDate, Object updatedBy, Object updatedDate, Object approvedBy, Object approvedDate, Object viewUserMessages, Object roleIds, Object userIds, Object batchIds, Object classIds, Object sectionIds, Object studentIds, Integer batchId) {
        this.id = id;
        this.userId = userId;
        this.displayName = displayName;
        this.type = type;
        this.fontAwesomeIcon = fontAwesomeIcon;
        this.avatarURL = avatarURL;
        this.urlPath = urlPath;
        this.shortDesc = shortDesc;
        this.messageDescription = messageDescription;
        this.messageFrom = messageFrom;
        this.timeSpan = timeSpan;
        this.percentage = percentage;
        this.timestamp = timestamp;
        this.organizationId = organizationId;
        this.branchId = branchId;
        this.organization = organization;
        this.branch = branch;
        this.userMessageDetails = userMessageDetails;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.updatedBy = updatedBy;
        this.updatedDate = updatedDate;
        this.approvedBy = approvedBy;
        this.approvedDate = approvedDate;
        this.viewUserMessages = viewUserMessages;
        this.roleIds = roleIds;
        this.userIds = userIds;
        this.batchIds = batchIds;
        this.classIds = classIds;
        this.sectionIds = sectionIds;
        this.studentIds = studentIds;
        this.batchId = batchId;
    }

}
