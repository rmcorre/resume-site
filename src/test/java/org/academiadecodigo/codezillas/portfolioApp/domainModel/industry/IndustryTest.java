package org.academiadecodigo.codezillas.portfolioApp.domainModel.industry;

import org.academiadecodigo.codezillas.portfolioApp.PortfolioApplication;
import org.academiadecodigo.codezillas.portfolioApp.dao.industry.IndustryDAO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import javax.transaction.Transactional;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = PortfolioApplication.class)
public class IndustryTest {

    @Autowired
    private IndustryDAO industryDAO;

    @Test
    @Transactional
    @DirtiesContext
    public void saveIndustry() {
       Industry industry = new Industry();
       industry.setId(3);
       industry.setVersion(0);
       industry.setCreationTime(new Date());
       industry.setUpdateTime(new Date());
       industry.setIndustry("Warehousing");
       industryDAO.saveOrUpdate(industry);

       Industry savedIndustry = industryDAO.find(3);

       assertEquals(3, savedIndustry.getId());
    }
}
