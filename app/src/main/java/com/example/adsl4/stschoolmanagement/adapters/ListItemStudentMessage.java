package com.example.adsl4.stschoolmanagement.adapters;

/**
 * Created by adsl4 on 5/18/18.
 */

public class ListItemStudentMessage {
private String msgShortDes;
private String msgBody;
private String msgDate;
private String usrId;
private String usrFromId;

    public String getMsgShortDes() {
        return msgShortDes;
    }

    public String getMsgBody() {
        return msgBody;
    }

    public String getMsgDate() {
        return msgDate;
    }

    public String getUsrId() {
        return usrId;
    }

    public String getUsrFromId() {
        return usrFromId;
    }

    public ListItemStudentMessage(String msgShortDes, String msgBody, String msgDate, String usrId, String usrFromId) {
        this.msgShortDes = msgShortDes;
        this.msgBody = msgBody;
        this.msgDate = msgDate;
        this.usrId = usrId;
        this.usrFromId = usrFromId;
    }
}
