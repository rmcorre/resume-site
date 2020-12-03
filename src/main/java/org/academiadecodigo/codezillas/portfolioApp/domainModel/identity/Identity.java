package org.academiadecodigo.codezillas.portfolioApp.domainModel.identity;

import org.academiadecodigo.codezillas.portfolioApp.domainModel.AbstractModel;

import java.util.Date;
import java.util.Objects;

public class Identity extends AbstractModel {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    public Identity() {

    }

    public Identity(Integer id, Integer version, Date creationTime, Date updateTime, String firstName, String lastName, String email, String phone) {
        super(id, version, creationTime, updateTime);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Identity identity = (Identity) o;
        return Objects.equals(firstName, identity.firstName) &&
                Objects.equals(lastName, identity.lastName) &&
                Objects.equals(email, identity.email) &&
                Objects.equals(phone, identity.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, phone);
    }

    @Override
    public String toString() {
        return "Identity{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                "} " + super.toString();
    }
}
