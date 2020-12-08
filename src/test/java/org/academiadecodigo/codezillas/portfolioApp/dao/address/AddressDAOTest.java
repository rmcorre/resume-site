package org.academiadecodigo.codezillas.portfolioApp.dao.address;

import org.academiadecodigo.codezillas.portfolioApp.PortfolioApplication;
import org.academiadecodigo.codezillas.portfolioApp.dao.identity.IdentityDAO;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.address.Address;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.identity.Identity;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest(classes = PortfolioApplication.class)
class AddressDAOTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AddressDAO addressDAO;

    @Test
    void find_basic() {
        Address address = addressDAO.find(1);
        assertEquals("Identity", address.getSubject());
    }

    @Test
    void findAll_basic() {
        List<Address> addressList = addressDAO.findAll();
        assertEquals(2, addressList.size());
    }

    @Test
    @DirtiesContext
    void saveOrUpdate_basic() {
        Address address = new Address();
        address.setId(3);
        address.setVersion(0);
        address.setCreationTime(new Date());
        address.setUpdateTime(new Date());
        address.setSubject("Identity");
        address.setNum(null);
        address.setAddress("9436-153 Street");
        address.setParish(null);
        address.setCounty(null);
        address.setTownCity("Edmonton");
        address.setStateProvince("Alberta");
        address.setCountryRegion("Canada");
        address.setPostalCode("T5R 1R3");

        addressDAO.saveOrUpdate(address);
        assertEquals(address, addressDAO.find(3));
    }

    @Test
    @DirtiesContext
    void delete_basic() {
        addressDAO.delete(1);
        assertNull(addressDAO.find(1));
    }

}
