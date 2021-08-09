package org.academiadecodigo.codezillas.portfolioApp.domainModel.identity;

import org.academiadecodigo.codezillas.portfolioApp.domainModel.AbstractModel;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.address.Address;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.portfolio.Portfolio;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Identity extends AbstractModel {

    private String firstName;
    private String lastName;
    private Boolean active;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Identity{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                "} " + super.toString();
    }
}
