package com.example.adsl4.stschoolmanagement.modals;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MonthDetailModal {
    @SerializedName("monthSetupId")
    @Expose
    private Integer monthSetupId;
    @SerializedName("financialYearId")
    @Expose
    private Object financialYearId;
    @SerializedName("financialYearName")
    @Expose
    private Object financialYearName;
    @SerializedName("monthName")
    @Expose
    private String monthName;
    @SerializedName("monthNumber")
    @Expose
    private Integer monthNumber;
    @SerializedName("monthStartDate")
    @Expose
    private String monthStartDate;
    @SerializedName("monthEndDate")
    @Expose
    private String monthEndDate;

    public Integer getMonthSetupId() {
        return monthSetupId;
    }

    public void setMonthSetupId(Integer monthSetupId) {
        this.monthSetupId = monthSetupId;
    }

    public Object getFinancialYearId() {
        return financialYearId;
    }

    public void setFinancialYearId(Object financialYearId) {
        this.financialYearId = financialYearId;
    }

    public Object getFinancialYearName() {
        return financialYearName;
    }

    public void setFinancialYearName(Object financialYearName) {
        this.financialYearName = financialYearName;
    }

    public String getMonthName() {
        return monthName;
    }

    public void setMonthName(String monthName) {
        this.monthName = monthName;
    }

    public Integer getMonthNumber() {
        return monthNumber;
    }

    public void setMonthNumber(Integer monthNumber) {
        this.monthNumber = monthNumber;
    }

    public String getMonthStartDate() {
        return monthStartDate;
    }

    public void setMonthStartDate(String monthStartDate) {
        this.monthStartDate = monthStartDate;
    }

    public String getMonthEndDate() {
        return monthEndDate;
    }

    public void setMonthEndDate(String monthEndDate) {
        this.monthEndDate = monthEndDate;
    }
}
