package com.example.adsl4.stschoolmanagement.adapters;

/**
 * Created by adsl4 on 11/28/17.
 */

public class ListItemStudentNotice {

    private String head;
    private String date;
    private String detail;
    private String shortDetail;

    public String getHead() {
        return head;
    }
    public String getShortDetail() {
        return shortDetail;
    }
    public String getDate() {
        return date;
    }
    public String getDetail() {
        return detail;
    }
    public ListItemStudentNotice(String head, String date, String detail, String shortDetail) {
        this.head = head;
        this.date = date;
        this.detail=detail;
        this.shortDetail=shortDetail;
    }
}
