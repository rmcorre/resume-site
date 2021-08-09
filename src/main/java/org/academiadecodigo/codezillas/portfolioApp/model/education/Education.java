package org.academiadecodigo.codezillas.portfolioApp.domainModel.education;

import org.academiadecodigo.codezillas.portfolioApp.domainModel.AbstractModel;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Education extends AbstractModel {

    private String institution;
    private String course;
    private String startDate;
    private String endDate;

    @Embedded
    private EducationAddress educationAddress;

    @ManyToMany(mappedBy = "educationSet")
    private Set<EducationGroup> educationGroupSet = new HashSet<>();

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

    public EducationAddress getEducationAddress() {
        return educationAddress;
    }

    public void setEducationAddress(EducationAddress educationAddress) {
        this.educationAddress = educationAddress;
    }

    public Set<EducationGroup> getEducationGroupSet() {
        return educationGroupSet;
    }

    public void setEducationGroupSet(Set<EducationGroup> educationGroupSet) {
        this.educationGroupSet = educationGroupSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Education education = (Education) o;
        return Objects.equals(institution, education.institution) && Objects.equals(course, education.course);
    }

    @Override
    public int hashCode() {
        return Objects.hash(institution, course);
    }

    @Override
    public String toString() {
        return "Education{" +
                "institution='" + institution + '\'' +
                ", course='" + course + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", educationAddress=" + educationAddress +
                "} " + super.toString();
    }
}


