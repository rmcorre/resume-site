package org.academiadecodigo.codezillas.portfolioApp.domainModel.portfolio;

import org.academiadecodigo.codezillas.portfolioApp.domainModel.AbstractModel;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.education.Education;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.identity.Identity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Portfolio extends AbstractModel {

    @ManyToMany
    @JoinTable(
        name = "portfolio_industry",
        joinColumns = @JoinColumn(name = "portfolio_id"),
        inverseJoinColumns = @JoinColumn(name = "industry_id"))
    private final List<Industry> industryList = new ArrayList<>();

    private String specialization;
    private String summary;

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

    public List<Industry> getIndustryList() {
        return industryList;
    }

    public void addIndustry(Industry industry) {
        industryList.add(industry);
    }

    public void removeIndustry(Industry industry) {
        industryList.remove(industry);
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Portfolio portfolio = (Portfolio) o;
        return Objects.equals(specialization, portfolio.specialization) && Objects.equals(summary, portfolio.summary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(specialization, summary);
    }

    @Override
    public String toString() {
        return "Portfolio{" +
                "specialization='" + specialization + '\'' +
                ", summary='" + summary + '\'' +
                "} " + super.toString();
    }
}
