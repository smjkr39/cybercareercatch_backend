package com.ccc.company.dto;

public class CompanyCardDTO {
    private int companyNumber;
    private String companyName;
    private String companyAddress;
    private String companyState;
    private String compSummary;
    private String filePath;
    private String compPageDate;
    private int cat1IsHiring;
    private int cat2IsHiring;
    private int cat3IsHiring;
    private int cat4IsHiring;

    public int getCompanyNumber() {
        return companyNumber;
    }

    public void setCompanyNumber(int companyNumber) {
        this.companyNumber = companyNumber;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getCompanyState() {
        return companyState;
    }

    public void setCompanyState(String companyState) {
        this.companyState = companyState;
    }

    public String getCompSummary() {
        return compSummary;
    }

    public void setCompSummary(String compSummary) {
        this.compSummary = compSummary;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getCompPageDate() {
        return compPageDate;
    }

    public void setCompPageDate(String compPageDate) {
        this.compPageDate = compPageDate;
    }

    public int getCat1IsHiring() {
        return cat1IsHiring;
    }

    public void setCat1IsHiring(int cat1IsHiring) {
        this.cat1IsHiring = cat1IsHiring;
    }

    public int getCat2IsHiring() {
        return cat2IsHiring;
    }

    public void setCat2IsHiring(int cat2IsHiring) {
        this.cat2IsHiring = cat2IsHiring;
    }

    public int getCat3IsHiring() {
        return cat3IsHiring;
    }

    public void setCat3IsHiring(int cat3IsHiring) {
        this.cat3IsHiring = cat3IsHiring;
    }

    public int getCat4IsHiring() {
        return cat4IsHiring;
    }

    public void setCat4IsHiring(int cat4IsHiring) {
        this.cat4IsHiring = cat4IsHiring;
    }

    public String getJobCategoryText() {
        StringBuilder builder = new StringBuilder();

        if (cat1IsHiring == 1) {
            builder.append("보안컨설팅, ");
        }
        if (cat2IsHiring == 1) {
            builder.append("시스템/네트워크 엔지니어, ");
        }
        if (cat3IsHiring == 1) {
            builder.append("보안관제, ");
        }
        if (cat4IsHiring == 1) {
            builder.append("침해사고/디지털포렌식, ");
        }

        if (builder.length() == 0) {
            return "-";
        }

        return builder.substring(0, builder.length() - 2);
    }

    @Override
    public String toString() {
        return "CompanyCardDTO [companyNumber=" + companyNumber
                + ", companyName=" + companyName
                + ", companyAddress=" + companyAddress
                + ", companyState=" + companyState
                + ", compSummary=" + compSummary
                + ", filePath=" + filePath
                + ", compPageDate=" + compPageDate
                + ", cat1IsHiring=" + cat1IsHiring
                + ", cat2IsHiring=" + cat2IsHiring
                + ", cat3IsHiring=" + cat3IsHiring
                + ", cat4IsHiring=" + cat4IsHiring + "]";
    }
}