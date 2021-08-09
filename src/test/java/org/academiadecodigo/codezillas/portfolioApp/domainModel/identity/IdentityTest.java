package org.academiadecodigo.codezillas.portfolioApp.domainModel.identity;

import org.academiadecodigo.codezillas.portfolioApp.PortfolioApplication;
import org.academiadecodigo.codezillas.portfolioApp.dao.address.AddressDAO;
import org.academiadecodigo.codezillas.portfolioApp.dao.identity.IdentityDAO;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.address.Address;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = PortfolioApplication.class)
public class IdentityTest {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IdentityDAO identityDAO;

    @Autowired
    private AddressDAO addressDAO;

    private Identity identity;
    private Address address;


    @BeforeEach
    public void init() {
        logger.info("Running init() before each method");

        address = new Address();
        address.setId(3);
        address.setVersion(0);
        address.setCreationTime(new Date());
        address.setUpdateTime(new Date());
        address.setSubject("Identity");
        address.setNum(null);
        address.setAddress("10242-106 Street");
        address.setParish(null);
        address.setCounty(null);
        address.setTownCity("Edmonton");
        address.setStateProvince("Alberta");
        address.setIsland(null);
        address.setCountryRegion("Canada");
        address.setPostalCode("T5M - 1M1");
        addressDAO.saveOrUpdate(address);

        identity = new Identity();
        identity.setId(4);
        identity.setVersion(0);
        identity.setCreationTime(new Date());
        identity.setUpdateTime(new Date());
        identity.setFirstName("Anthony");
        identity.setLastName("Hayduk");
        identityDAO.saveOrUpdate(identity);
    }

//    @Test
//    @Transactional
//    @DirtiesContext
//    void getAddressTest() {
//
//        identity.addAddress(address);
//        identityDAO.saveOrUpdate(identity);
//        logger.info("identity.getAddressList().get(0).getId() --> {}", identity.getAddressList().get(0).getId());
//
//
//        assertEquals(4, identity.getId());
//        assertEquals(3, identity.getAddressList().get(0).getId());
//    }


}
