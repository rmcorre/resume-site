package org.academiadecodigo.codezillas.portfolioApp.domainModel.address;

import org.academiadecodigo.codezillas.portfolioApp.domainModel.AbstractModel;

import java.util.Objects;

public class Address extends AbstractModel {

    private String type;
    private String number;
    private String address;
    private String parish;
    private String townCity;
    private String county;
    private String stateProvince;
    private String island;
    private String countryRegion;
    private String postalCode;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address1 = (Address) o;
        return Objects.equals(type, address1.type) &&
                Objects.equals(number, address1.number) &&
                Objects.equals(address, address1.address) &&
                Objects.equals(parish, address1.parish) &&
                Objects.equals(townCity, address1.townCity) &&
                Objects.equals(county, address1.county) &&
                Objects.equals(stateProvince, address1.stateProvince) &&
                Objects.equals(island, address1.island) &&
                Objects.equals(countryRegion, address1.countryRegion) &&
                Objects.equals(postalCode, address1.postalCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, number, address, parish, townCity, county, stateProvince, island, countryRegion, postalCode);
    }

    @Override
    public String toString() {
        return "Address{" +
                "type='" + type + '\'' +
                ", number='" + number + '\'' +
                ", address='" + address + '\'' +
                ", parish='" + parish + '\'' +
                ", townCity='" + townCity + '\'' +
                ", county='" + county + '\'' +
                ", stateProvince='" + stateProvince + '\'' +
                ", island='" + island + '\'' +
                ", countryRegion='" + countryRegion + '\'' +
                ", postalCode='" + postalCode + '\'' +
                "} " + super.toString();
    }
}
