package org.academiadecodigo.codezillas.portfolioApp.domainModel.address;

import org.academiadecodigo.codezillas.portfolioApp.domainModel.AbstractModel;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.identity.Identity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Entity
public class Address extends AbstractModel {

    private String subject;
    private String num;
    private String address;
    private String parish;
    private String townCity;
    private String county;
    private String stateProvince;
    private String island;
    private String countryRegion;
    private String postalCode;

    @ManyToOne
    private Identity identity;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String type) {
        this.subject = type;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String number) {
        this.num = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getParish() {
        return parish;
    }

    public void setParish(String parish) {
        this.parish = parish;
    }

    public String getTownCity() {
        return townCity;
    }

    public void setTownCity(String townCity) {
        this.townCity = townCity;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getStateProvince() {
        return stateProvince;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    public String getIsland() {
        return island;
    }

    public void setIsland(String island) {
        this.island = island;
    }

    public String getCountryRegion() {
        return countryRegion;
    }

    public void setCountryRegion(String countryRegion) {
        this.countryRegion = countryRegion;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Identity getIdentity() {
        return identity;
    }

    public void setIdentity(Identity identity) {
        this.identity = identity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address1 = (Address) o;
        return Objects.equals(subject, address1.subject) &&
                Objects.equals(num, address1.num) &&
                Objects.equals(address, address1.address) &&
                Objects.equals(parish, address1.parish) &&
                Objects.equals(townCity, address1.townCity) &&
                Objects.equals(county, address1.county) &&
                Objects.equals(stateProvince, address1.stateProvince) &&
                Objects.equals(island, address1.island) &&
                Objects.equals(countryRegion, address1.countryRegion) &&
                Objects.equals(postalCode, address1.postalCode) &&
                Objects.equals(identity, address1.identity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subject, num, address, parish, townCity, county, stateProvince, island, countryRegion, postalCode, identity);
    }

    @Override
    public String toString() {
        return "Address{" +
                "subject='" + subject + '\'' +
                ", num='" + num + '\'' +
                ", address='" + address + '\'' +
                ", parish='" + parish + '\'' +
                ", townCity='" + townCity + '\'' +
                ", county='" + county + '\'' +
                ", stateProvince='" + stateProvince + '\'' +
                ", island='" + island + '\'' +
                ", countryRegion='" + countryRegion + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", identity=" + identity +
                "} " + super.toString();
    }
}
