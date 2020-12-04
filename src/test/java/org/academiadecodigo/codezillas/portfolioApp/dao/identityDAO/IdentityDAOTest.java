package org.academiadecodigo.codezillas.portfolioApp.dao.identityDAO;

import org.academiadecodigo.codezillas.portfolioApp.PortfolioApplication;
import org.academiadecodigo.codezillas.portfolioApp.dao.identity.IdentityDAO;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.identity.Identity;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PortfolioApplication.class)
class IdentityDAOTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IdentityDAO identityDAO;

    @Test
    void find_basicTest() {
        Identity identity = identityDAO.find(1);
        assertEquals("Horacio", identity.getFirstName());
    }

}
