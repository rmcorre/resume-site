package org.academiadecodigo.codezillas.portfolioApp.dto;

public class PortfolioDTO {

    private Integer industry;

    private Integer role;

    private Integer identity;

    private Integer education;

    private String summary;

    private Boolean active;

    public Integer getIndustry() {
        return industry;
    }

    public void setIndustry(Integer industry) {
        this.industry = industry;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Integer getIdentity() {
        return identity;
    }

    public void setIdentity(Integer identity) {
        this.identity = identity;
    }

    public Integer getEducation() {
        return education;
    }

    public void setEducation(Integer education) {
        this.education = education;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
