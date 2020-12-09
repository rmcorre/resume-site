package org.academiadecodigo.codezillas.portfolioApp.domainModel.identity;

import org.academiadecodigo.codezillas.portfolioApp.domainModel.AbstractModel;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.address.Address;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.portfolio.Portfolio;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Identity extends AbstractModel {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    @OneToMany(mappedBy = "identity")
    private final List<Address> addressList  = new ArrayList<>();

    @ManyToMany(mappedBy = "identityList")
    private final List<Portfolio> portfolioList = new ArrayList<>();

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

    public List<Address> getAddressList() {
        return addressList;
    }

    public void addAddress(Address address) {
        addressList.add(address);
        address.setIdentity(this);
    }

    public void removeAddress(Address address) {
        addressList.remove(address);
    }

    public List<Portfolio> getPortfolioList() {
        return portfolioList;
    }

    public void addPortfolio(Portfolio portfolio) {
        portfolioList.add(portfolio);
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
