package org.academiadecodigo.codezillas.portfolioApp.domainModel.portfolio;

import org.academiadecodigo.codezillas.portfolioApp.domainModel.address.Address;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.identity.Identity;

import java.util.Objects;

public class Portfolio {

    //Add an Identity field to accept an identity from a select input
    private Identity identity;

    //Add an Address field to accept an address from a select input
    private Address address;

    public Identity getIdentity() {
        return identity;
    }

    public void setIdentity(Identity identity) {
        this.identity = identity;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Portfolio portfolio = (Portfolio) o;
        return Objects.equals(identity, portfolio.identity) &&
                Objects.equals(address, portfolio.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identity, address);
    }

    @Override
    public String toString() {
        return "Portfolio{" +
                "identity=" + identity +
                ", address=" + address +
                '}';
    }
}
