package org.academiadecodigo.codezillas.portfolioApp.domainModel.education;

import org.academiadecodigo.codezillas.portfolioApp.PortfolioApplication;
import org.academiadecodigo.codezillas.portfolioApp.dao.address.AddressDAO;
import org.academiadecodigo.codezillas.portfolioApp.dao.education.EducationDAO;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.address.Address;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = PortfolioApplication.class)
public class EducationTest {

    @Autowired
    private AddressDAO addressDAO;

    @Autowired
    private EducationDAO educationDAO;

    @Test
    @Transactional
    public void retrieveEducationAndAssociatedAddress() {
        Education education = educationDAO.find(1);
        assertEquals("7128 Ada Blvd NW", education.getAddressList().get(0).getAddress());
    }

    @Test
    @DirtiesContext
    @Transactional
    public void saveEducationAndAssociatedAddress() {
        Education education = new Education();
        education.setId(3);
        education.setVersion(0);
        education.setCreationTime(new Date());
        education.setUpdateTime(new Date());
        education.setInstitution("Archbishop Jordan High School");
        education.setCourse("High School Diploma");

        Address address = new Address();
        address.setId(5);
        address.setVersion(0);
        address.setCreationTime(new Date());
        address.setUpdateTime(new Date());
        address.setSubject("Education");
        address.setNum(null);
        address.setAddress("Main Blvd");
        address.setTownCity("Sherwood Park");
        address.setStateProvince("Alberta");
        address.setCountryRegion("Canada");
        // Have to persist the address first to set an ID in the database
        addressDAO.saveOrUpdate(address);


        education.addAddress(address);
        educationDAO.saveOrUpdate(education);

        Education education1 = educationDAO.find(3);

        assertEquals("Main Blvd", education1.getAddressList().get(0).getAddress());
    }
}

