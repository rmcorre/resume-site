package org.academiadecodigo.codezillas.portfolioApp.dao.identity;

import org.academiadecodigo.codezillas.portfolioApp.PortfolioApplication;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.identity.Identity;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest(classes = PortfolioApplication.class)
class IdentityDAOTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IdentityDAO identityDAO;

    @Test
    void find_basic() {
        Identity identity = identityDAO.find(1);
        assertEquals("Horacio", identity.getFirstName());
    }

    @Test
    void findAll_basic() {
        List<Identity> identityList = identityDAO.findAll();
        assertEquals(4, identityList.size());
    }

    @Test
    @DirtiesContext
    @Transactional
    void saveOrUpdate_basic() {
        Identity identity = new Identity();
        identity.setId(5);
        identity.setVersion(0);
        identity.setCreationTime(new Date());
        identity.setUpdateTime(new Date());
        identity.setFirstName("Jimmy");
        identity.setLastName("Page");
        identity.setEmail("jimmy@gmail.com");
        identity.setPhone("91 777 7777");

        identityDAO.saveOrUpdate(identity);
        assertEquals(identity, identityDAO.find(5));
    }

    @Test
    @DirtiesContext
    @Transactional
    void delete_basic() {
        identityDAO.delete(1);
        assertNull(identityDAO.find(1));
    }

}
