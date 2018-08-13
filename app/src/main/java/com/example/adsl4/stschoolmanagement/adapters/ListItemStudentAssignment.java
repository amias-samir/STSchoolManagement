package com.example.adsl4.stschoolmanagement.adapters;

/**
 * Created by adsl4 on 5/18/18.
 */

public class ListItemStudentAssignment {
private int assignmentId;
private String assignmentName;
private String assignmentDate;

    public int getAssignmentId() {
        return assignmentId;
    }

    public String getAssignmentName() {
        return assignmentName;
    }

    public String getAssignmentDate() {
        return assignmentDate;
    }

    public ListItemStudentAssignment(int assignmentId, String assignmentName, String assignmentDate) {
        this.assignmentId = assignmentId;
        this.assignmentName = assignmentName;
        this.assignmentDate = assignmentDate;
    }
}
