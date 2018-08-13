package com.example.adsl4.stschoolmanagement.adapters;

public class LIstItemAssignmentSubjects {
    int subjectsId;
    String subjectsName;

    public int getSubjectsId() {
        return subjectsId;
    }

    public String getSubjectsName() {
        return subjectsName;
    }

    public LIstItemAssignmentSubjects(int subjectsId, String subjectsName) {
        this.subjectsId = subjectsId;
        this.subjectsName = subjectsName;
    }

    @Override
    public String toString() {
        return subjectsName;
    }

}
