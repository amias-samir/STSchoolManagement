package com.example.adsl4.stschoolmanagement.adapters;

public class LIstItemAssignmentBatch {
    int batchsId;
    String batchName;

    public int getBatchsId() {
        return batchsId;
    }

    public String getBatchName() {
        return batchName;
    }

    public LIstItemAssignmentBatch(int batchsId, String batchName) {
        this.batchsId = batchsId;
        this.batchName = batchName;
    }

    @Override
    public String toString() {
        return batchName;
    }

}
