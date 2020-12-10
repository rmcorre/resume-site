package org.academiadecodigo.codezillas.portfolioApp.dao.portfolio;

import org.academiadecodigo.codezillas.portfolioApp.PortfolioApplication;
import org.academiadecodigo.codezillas.portfolioApp.dao.identity.IdentityDAO;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.portfolio.Portfolio;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest(classes = PortfolioApplication.class)
public class PortfolioDAOTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IdentityDAO identityDAO;

    @Autowired
    private PortfolioDAO portfolioDAO;

    @Test
    @Transactional
    public void retrievePortfolioAndAssociatedIdentities() {
        Portfolio portfolio = portfolioDAO.find(1);

        assertEquals(1, portfolio.getId());
        assertEquals(2, portfolio.getIdentityList().size());
    }


    @Test
    @Transactional
    @DirtiesContext
    public void deletePortfolio() {
        portfolioDAO.delete(3);

        assertNull(portfolioDAO.find(3));
    }



    //Todo:
    // Either way, have to implement test methods for the Portfolio/Education
    // ManyToMany relationship
}
