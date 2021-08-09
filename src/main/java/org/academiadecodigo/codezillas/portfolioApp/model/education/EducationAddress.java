package org.academiadecodigo.codezillas.portfolioApp.domainModel.education;

import javax.persistence.Embeddable;

@Embeddable
public class EducationAddress {

    private String num;
    private String address;
    private String parish;
    private String townCity;
    private String county;
    private String stateProvince;
    private String island;
    private String countryRegion;
    private String postalCode;

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
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
    public String toString() {
        return "EducationAddress{" +
                "num='" + num + '\'' +
                ", address='" + address + '\'' +
                ", parish='" + parish + '\'' +
                ", townCity='" + townCity + '\'' +
                ", county='" + county + '\'' +
                ", stateProvince='" + stateProvince + '\'' +
                ", island='" + island + '\'' +
                ", countryRegion='" + countryRegion + '\'' +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }
}
