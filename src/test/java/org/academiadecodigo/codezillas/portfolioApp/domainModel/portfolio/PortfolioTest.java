package org.academiadecodigo.codezillas.portfolioApp.domainModel.portfolio;

import org.academiadecodigo.codezillas.portfolioApp.PortfolioApplication;
import org.academiadecodigo.codezillas.portfolioApp.dao.education.EducationDAO;
import org.academiadecodigo.codezillas.portfolioApp.dao.identity.IdentityDAO;
import org.academiadecodigo.codezillas.portfolioApp.dao.portfolio.PortfolioDAO;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.education.Education;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.identity.Identity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = PortfolioApplication.class)
public class PortfolioTest {

    @Autowired
    private IdentityDAO identityDAO;

    @Autowired
    private PortfolioDAO portfolioDAO;

    @Autowired
    private EducationDAO educationDAO;


    @Test
    @Transactional
    @DirtiesContext
    public void saveNewPortfolioAndNewIdentity() {
        Portfolio portfolio = new Portfolio();
        portfolio.setCategory("Management");
        portfolio.setSpecialization("Food and Beverage");

        Identity identity = new Identity();
        identity.setId(5);
        identity.setVersion(0);
        identity.setCreationTime(new Date());
        identity.setUpdateTime(new Date());
        identity.setFirstName("Jimmy");
        identity.setLastName("Schafer");
        identity.setEmail("jimmy@gmail.com");
        identity.setPhone("780 426 1024");
        identityDAO.saveOrUpdate(identity);

        Identity savedIdentity = identityDAO.find(5);
        portfolio.addIdentity(savedIdentity);
        portfolioDAO.saveOrUpdate(portfolio);

        Portfolio savedPortfolio = portfolioDAO.find(4);

        assertEquals(4, savedPortfolio.getId());
        assertEquals(5, savedPortfolio.getIdentityList().get(0).getId());
    }

    @Test
    @Transactional
    @DirtiesContext
    public void saveNewPortfolioAndSelectedIdentity() {
        Portfolio portfolio = new Portfolio();
        portfolio.setCategory("Management");
        portfolio.setSpecialization("Food and Beverage");

        List<Identity> identities = identityDAO.findAll();
        Identity selectedIdentity = identities.get(0);

        portfolio.addIdentity(selectedIdentity);
        portfolioDAO.saveOrUpdate(portfolio);

        Portfolio savedPortfolio = portfolioDAO.find(4);

        assertEquals(4, savedPortfolio.getId());
        assertEquals(1, savedPortfolio.getIdentityList().get(0).getId());
    }

    @Test
    @Transactional
    @DirtiesContext
    public void deletePortfolioIdentityFromIdentityList() {
        Portfolio portfolio = portfolioDAO.find(1);
        Identity identity = portfolio.getIdentityList().get(1);
        portfolio.getIdentityList().remove(identity);

        assertEquals(1, portfolio.getIdentityList().size());
    }

    @Test
    @Transactional
    @DirtiesContext
    public void saveNewPortfolioNewIdentityAndNewEducation() {
        Portfolio portfolio = new Portfolio();
        portfolio.setCategory("Management");
        portfolio.setSpecialization("Food and Beverage");

        Identity identity = new Identity();
        identity.setId(5);
        identity.setVersion(0);
        identity.setCreationTime(new Date());
        identity.setUpdateTime(new Date());
        identity.setFirstName("Jimmy");
        identity.setLastName("Schafer");
        identity.setEmail("jimmy@gmail.com");
        identity.setPhone("780 426 1024");
        identityDAO.saveOrUpdate(identity);

        Education education = new Education();
        education.setId(3);
        education.setVersion(0);
        education.setCreationTime(new Date());
        education.setUpdateTime(new Date());
        education.setInstitution("Archbishop Jordan");
        education.setCourse("High School Diploma");
        educationDAO.saveOrUpdate(education);

        Identity savedIdentity = identityDAO.find(5);
        portfolio.addIdentity(savedIdentity);

        Education savedEducation = educationDAO.find(3);
        portfolio.addEducation(savedEducation);

        portfolioDAO.saveOrUpdate(portfolio);

        Portfolio savedPortfolio = portfolioDAO.find(4);

        assertEquals(4, savedPortfolio.getId());
        assertEquals(5, savedPortfolio.getIdentityList().get(0).getId());
        assertEquals(3, savedPortfolio.getEducationList().get(0).getId());
    }

    @Test
    @Transactional
    @DirtiesContext
    public void saveNewPortfolioSelectedIdentityAndSelectedEducation() {
        Portfolio portfolio = new Portfolio();
        portfolio.setCategory("Management");
        portfolio.setSpecialization("Food and Beverage");

        List<Identity> identities = identityDAO.findAll();
        Identity selectedIdentity = identities.get(0);

        List<Education> educations = educationDAO.findAll();
        Education selectedEducation = educations.get(0);

        portfolio.addIdentity(selectedIdentity);
        portfolio.addEducation(selectedEducation);
        portfolioDAO.saveOrUpdate(portfolio);

        Portfolio savedPortfolio = portfolioDAO.find(4);

        assertEquals(4, savedPortfolio.getId());
        assertEquals(1, savedPortfolio.getIdentityList().get(0).getId());
        assertEquals(1, savedPortfolio.getEducationList().get(0).getId());
    }
}
