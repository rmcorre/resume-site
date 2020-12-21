package org.academiadecodigo.codezillas.portfolioApp.domainModel.knowledge;

import org.academiadecodigo.codezillas.portfolioApp.PortfolioApplication;
import org.academiadecodigo.codezillas.portfolioApp.dao.industry.IndustryDAO;
import org.academiadecodigo.codezillas.portfolioApp.dao.knowledge.KnowledgeDAO;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.industry.Industry;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import javax.transaction.Transactional;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = PortfolioApplication.class)
public class KnowledgeTest {

    @Autowired
    private IndustryDAO industryDAO;

    @Autowired
    private KnowledgeDAO knowledgeDAO;

    @Test
    @Transactional
    public void save_Knowledge() {

        Industry industry = industryDAO.find(1);

        Knowledge knowledge = new Knowledge();
        knowledge.setId(9);
        knowledge.setVersion(0);
        knowledge.setCreationTime(new Date());
        knowledge.setUpdateTime(new Date());
        knowledge.setKnowledgeItem("Networking");
        knowledge.addIndustry(industry);
        knowledgeDAO.saveOrUpdate(knowledge);

        Knowledge savedKnowledge = knowledgeDAO.find(9);

        assertEquals(9, savedKnowledge.getId());
    }
}
