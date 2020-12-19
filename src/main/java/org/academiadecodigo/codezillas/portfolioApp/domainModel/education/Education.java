package org.academiadecodigo.codezillas.portfolioApp.domainModel.education;

import org.academiadecodigo.codezillas.portfolioApp.domainModel.AbstractModel;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.address.Address;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.portfolio.Portfolio;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Education extends AbstractModel {

    private String institution;
    private String course;
    private String startDate;
    private String endDate;

    @OneToMany(mappedBy = "education")
    private final List<Address> addressList = new ArrayList<>();

//    @ManyToMany(mappedBy = "educationList")
//    private final List<Portfolio> portfolioList = new ArrayList<>();

    @ManyToMany(mappedBy = "educationList")
    private final List<EducationGroup> educationGroupList = new ArrayList<>();

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void addAddress(Address address) {
        addressList.add(address);
        address.setEducation(this);
    }

    public void removeAddress(Address address) {
        address.setEducation(null);
        this.addressList.remove(address);
    }

//    public List<Portfolio> getPortfolioList() {
//        return portfolioList;
//    }
//
//    public void addPortfolio(Portfolio portfolio) {
//        this.portfolioList.add(portfolio);
//    }
//
//    public void removePortfolio(Portfolio portfolio) {
//        this.portfolioList.remove(portfolio);
//    }

    public List<EducationGroup> getEducationGroupList() {
        return educationGroupList;
    }

    public void addEducationGroup(EducationGroup educationGroup) {
        this.educationGroupList.add(educationGroup);
    }

    public void removeEducationGroup(EducationGroup educationGroup) {
        this.educationGroupList.remove(educationGroup);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Education education = (Education) o;
        return Objects.equals(institution, education.institution) &&
                Objects.equals(course, education.course) &&
                Objects.equals(startDate, education.startDate) &&
                Objects.equals(endDate, education.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(institution, course, startDate, endDate);
    }

    @Override
    public String toString() {
        return "Education{" +
                "institution='" + institution + '\'' +
                ", course='" + course + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                "} " + super.toString();
    }
}


