package org.academiadecodigo.codezillas.portfolioApp;

import org.academiadecodigo.codezillas.portfolioApp.dao.address.AddressDAO;
import org.academiadecodigo.codezillas.portfolioApp.dao.identity.IdentityDAO;
import org.academiadecodigo.codezillas.portfolioApp.dao.industry.IndustryDAO;
import org.academiadecodigo.codezillas.portfolioApp.dao.knowledge.KnowledgeDAO;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.address.Address;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.identity.Identity;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.industry.Industry;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.knowledge.Knowledge;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;
import java.util.Date;

@SpringBootApplication
public class PortfolioApplication implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final IdentityDAO identityDAO;
    private final AddressDAO addressDAO;
    private final IndustryDAO industryDAO;
    private final KnowledgeDAO knowledgeDAO;

    @Autowired
    public PortfolioApplication(IdentityDAO identityDAO, AddressDAO addressDAO, IndustryDAO industryDAO, KnowledgeDAO knowledgeDAO) {
        this.identityDAO = identityDAO;
        this.addressDAO = addressDAO;
        this.industryDAO = industryDAO;
        this.knowledgeDAO = knowledgeDAO;
    }

    public static void main(String[] args) {
        SpringApplication.run(PortfolioApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        Industry industry = industryDAO.find(1);

        logger.info("industry.getKnowledgeList().toString()" + industry.getKnowledgeSet().toString());

        Knowledge knowledge = new Knowledge();
        knowledge.setId(9);
        knowledge.setVersion(0);
        knowledge.setCreationTime(new Date());
        knowledge.setUpdateTime(new Date());
        knowledge.setKnowledgeItem("Networking");
        knowledgeDAO.saveOrUpdate(knowledge);

        Knowledge savedKnowledge = knowledgeDAO.find(9);

        industry.addKnowledge(savedKnowledge);

        logger.info("Saved Knowledge -->" + savedKnowledge.toString());

    }
}
