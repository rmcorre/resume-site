package org.academiadecodigo.codezillas.portfolioApp.dao.industry;

import org.academiadecodigo.codezillas.portfolioApp.PortfolioApplication;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.industry.Industry;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = PortfolioApplication.class)
public class IndustryDAOTest {

    @Autowired
    private IndustryDAO industryDAO;

    @Test
    public void find_basic() {
        Industry industry = industryDAO.find(1);

        assertEquals(1, industry.getId());
    }
}
