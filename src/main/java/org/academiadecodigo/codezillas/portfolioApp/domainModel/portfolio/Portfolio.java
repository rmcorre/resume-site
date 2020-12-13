package org.academiadecodigo.codezillas.portfolioApp.domainModel.portfolio;

import org.academiadecodigo.codezillas.portfolioApp.domainModel.AbstractModel;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.education.Education;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.identity.Identity;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.industry.Industry;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Portfolio extends AbstractModel {

    @ManyToMany
    @JoinTable(
        name = "portfolio_industry",
        joinColumns = @JoinColumn(name = "portfolio_id"),
        inverseJoinColumns = @JoinColumn(name = "industry_id"))
    private final List<Industry> industryList = new ArrayList<>();




    @ManyToMany
    @JoinTable(
        name = "portfolio_identity",
        joinColumns = @JoinColumn(name = "portfolio_id"),
        inverseJoinColumns = @JoinColumn(name = "identity_id"))
    private final List<Identity> identityList = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "portfolio_education",
            joinColumns = @JoinColumn(name = "portfolio_id"),
            inverseJoinColumns = @JoinColumn(name = "education_id"))
    private final List<Education> educationList = new ArrayList<>();

    private String summary;

    public List<Industry> getIndustryList() {
        return industryList;
    }

    public void addIndustry(Industry industry) {
        industryList.add(industry);
    }

    public void removeIndustry(Industry industry) {
        industryList.remove(industry);
    }





    public List<Identity> getIdentityList() {
        return identityList;
    }

    public void addIdentity(Identity identity) {
        identityList.add(identity);
    }

    public void removeIdentity(Identity identity) {
        identityList.remove(identity);
    }

    public List<Education> getEducationList() {
        return educationList;
    }

    public void addEducation(Education education) {
        educationList.add(education);
    }

    public void removeEduction(Education education) {
        educationList.remove(education);
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
