package com.example.adsl4.stschoolmanagement.adapters;

public class LIstItemAssignmentSection {
    int secId;
    String secName;

    public int getBatchsId() {
        return secId;
    }

    public String getBatchName() {
        return secName;
    }

    public LIstItemAssignmentSection(int secId, String secName) {
        this.secId = secId;
        this.secName = secName;
    }

    @Override
    public String toString() {
        return secName;
    }

}
