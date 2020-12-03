package org.academiadecodigo.codezillas.portfolioApp.domainModel.address;

import org.academiadecodigo.codezillas.portfolioApp.domainModel.AbstractModel;

import java.util.Date;
import java.util.Objects;

public class Address extends AbstractModel {

    private String type;
    private String houseAptSuite;
    private String address;
    private String parishTownCity;
    private String countyStateProvince;
    private String countryRegion;
    private String postalCode;

    public Address() {

    }

    public Address(Integer id, Integer version, Date creationTime, Date updateTime, String type, String houseAptSuite, String address, String parishTownCity, String countyStateProvince, String countryRegion, String postalCode) {
        super(id, version, creationTime, updateTime);
        this.type = type;
        this.houseAptSuite = houseAptSuite;
        this.address = address;
        this.parishTownCity = parishTownCity;
        this.countyStateProvince = countyStateProvince;
        this.countryRegion = countryRegion;
        this.postalCode = postalCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHouseAptSuite() {
        return houseAptSuite;
    }

    public void setHouseAptSuite(String houseAptSuite) {
        this.houseAptSuite = houseAptSuite;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getParishTownCity() {
        return parishTownCity;
    }

    public void setParishTownCity(String parishTownCity) {
        this.parishTownCity = parishTownCity;
    }

    public String getCountyStateProvince() {
        return countyStateProvince;
    }

    public void setCountyStateProvince(String countyStateProvince) {
        this.countyStateProvince = countyStateProvince;
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
                Objects.equals(houseAptSuite, address1.houseAptSuite) &&
                Objects.equals(address, address1.address) &&
                Objects.equals(parishTownCity, address1.parishTownCity) &&
                Objects.equals(countyStateProvince, address1.countyStateProvince) &&
                Objects.equals(countryRegion, address1.countryRegion) &&
                Objects.equals(postalCode, address1.postalCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, houseAptSuite, address, parishTownCity, countyStateProvince, countryRegion, postalCode);
    }

    @Override
    public String toString() {
        return "Address{" +
                "type='" + type + '\'' +
                ", houseAptSuite='" + houseAptSuite + '\'' +
                ", address='" + address + '\'' +
                ", parishTownCity='" + parishTownCity + '\'' +
                ", countyStateProvince='" + countyStateProvince + '\'' +
                ", countryRegion='" + countryRegion + '\'' +
                ", postalCode='" + postalCode + '\'' +
                "} " + super.toString();
    }
}
