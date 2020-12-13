package org.academiadecodigo.codezillas.portfolioApp.domainModel.portfolio;

import org.academiadecodigo.codezillas.portfolioApp.domainModel.AbstractModel;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.education.Education;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.role.Role;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.identity.Identity;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.industry.Industry;

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

    @ManyToMany
    @JoinTable(
        name = "portfolio_role",
        joinColumns = @JoinColumn(name = "portfolio_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id"))
    private final List<Role> roleList = new ArrayList<>();

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

    public List<Role> getRoleList() {
        return roleList;
    }

    public void addRole(Role role) {
        roleList.add(role);
    }

    public void removeRole(Role role) {
        roleList.remove(role);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Portfolio portfolio = (Portfolio) o;
        return Objects.equals(summary, portfolio.summary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(summary);
    }

    @Override
    public String toString() {
        return "Portfolio{" +
                "summary='" + summary + '\'' +
                "} " + super.toString();
    }
}
