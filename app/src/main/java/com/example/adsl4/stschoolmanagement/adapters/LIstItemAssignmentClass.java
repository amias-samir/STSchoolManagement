package com.example.adsl4.stschoolmanagement.adapters;

public class LIstItemAssignmentClass {
    int classId;
    String className;

    public int getClassId() {
        return classId;
    }

    public String getClassName() {
        return className;
    }

    public LIstItemAssignmentClass(int classId, String className) {
        this.classId = classId;
        this.className = className;
    }

    @Override
    public String toString() {
        return className;
    }

}
