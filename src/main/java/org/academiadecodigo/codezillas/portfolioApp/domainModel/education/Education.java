package org.academiadecodigo.codezillas.portfolioApp.domainModel.education;

import org.academiadecodigo.codezillas.portfolioApp.domainModel.AbstractModel;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Education extends AbstractModel {

    private String institution;
    private String course;
    private String startDate;
    private String endDate;


    //private String address;

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


