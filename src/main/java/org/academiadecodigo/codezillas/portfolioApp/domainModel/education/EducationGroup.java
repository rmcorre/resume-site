package org.academiadecodigo.codezillas.portfolioApp.domainModel.education;

import org.academiadecodigo.codezillas.portfolioApp.domainModel.AbstractModel;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.portfolio.Portfolio;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class EducationGroup extends AbstractModel {

    private String groupName;

    @ManyToMany
    @JoinTable(
        name = "educationgroup_education",
        joinColumns = @JoinColumn(name = "educationgroup_id"),
        inverseJoinColumns = @JoinColumn(name = "education_id"))
    private final List<Education> educationList = new ArrayList<>();

    @ManyToMany(mappedBy = "educationGroupList")
    private final List<Portfolio> portfolioList = new ArrayList<>();

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<Education> getEducationList() {
        return educationList;
    }

    public void addEducation(Education education) {
        this.educationList.add(education);
    }

    public void removeEducation(Education education) {
        this.educationList.remove(education);
    }

    public void addPortfolio(Portfolio portfolio) {
        this.portfolioList.add(portfolio);
    }

    public void removePortfolio(Portfolio portfolio) {
        this.portfolioList.remove(portfolio);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EducationGroup that = (EducationGroup) o;
        return Objects.equals(groupName, that.groupName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupName);
    }

    @Override
    public String toString() {
        return "EducationGroup{" +
                "groupName='" + groupName + '\'' +
                "} " + super.toString();
    }
}
