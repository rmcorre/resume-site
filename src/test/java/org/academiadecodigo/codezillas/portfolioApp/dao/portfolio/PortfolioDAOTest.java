package org.academiadecodigo.codezillas.portfolioApp.dao.portfolio;

import org.academiadecodigo.codezillas.portfolioApp.PortfolioApplication;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.portfolio.Portfolio;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = PortfolioApplication.class)
public class PortfolioDAOTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PortfolioDAO portfolioDAO;

    @Test
    @Transactional
    public void retrievePortfolioAndAssociatedIdentities() {
        Portfolio portfolio = portfolioDAO.find(1);

        assertEquals(1, portfolio.getId());
        assertEquals(2, portfolio.getIdentityList().size());
    }

}
