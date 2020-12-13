package org.academiadecodigo.codezillas.portfolioApp.domainModel.portfolio;

import org.academiadecodigo.codezillas.portfolioApp.PortfolioApplication;
import org.academiadecodigo.codezillas.portfolioApp.dao.industry.IndustryDAO;
import org.academiadecodigo.codezillas.portfolioApp.dao.education.EducationDAO;
import org.academiadecodigo.codezillas.portfolioApp.dao.identity.IdentityDAO;
import org.academiadecodigo.codezillas.portfolioApp.dao.portfolio.PortfolioDAO;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.education.Education;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.identity.Identity;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.industry.Industry;
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
    private IndustryDAO categoryDAO;

    @Autowired
    private IdentityDAO identityDAO;

    @Autowired
    private PortfolioDAO portfolioDAO;

    @Autowired
    private EducationDAO educationDAO;


    @Test
    @Transactional
    @DirtiesContext
    public void saveNewPortfolioNewCategoryAndNewIdentity() {
        Portfolio portfolio = new Portfolio();
//        portfolio.setSpecialization("Food and Beverage");

        Industry industry = new Industry();
        industry.setId(1);
        industry.setVersion(0);
        industry.setCreationTime(new Date());
        industry.setUpdateTime(new Date());
        industry.setIndustry("Development");
        categoryDAO.saveOrUpdate(industry);

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

        Industry savedIndustry = categoryDAO.find(1);
        Identity savedIdentity = identityDAO.find(5);
        portfolio.addIndustry(savedIndustry);
        portfolio.addIdentity(savedIdentity);
        portfolioDAO.saveOrUpdate(portfolio);

        Portfolio savedPortfolio = portfolioDAO.find(4);

        assertEquals(4, savedPortfolio.getId());
        assertEquals(1, savedPortfolio.getIndustryList().get(0).getId());
        assertEquals(5, savedPortfolio.getIdentityList().get(0).getId());
    }

    @Test
    @Transactional
    @DirtiesContext
    public void saveNewPortfolioSelectedCategoryAndSelectedIdentity() {
        Portfolio portfolio = new Portfolio();
//        portfolio.setSpecialization("Food and Beverage");

        List<Industry> categories = categoryDAO.findAll();
        List<Identity> identities = identityDAO.findAll();

        Industry selectedIndustry = categories.get(0);
        Identity selectedIdentity = identities.get(0);

        portfolio.addIndustry(selectedIndustry);
        portfolio.addIdentity(selectedIdentity);
        portfolioDAO.saveOrUpdate(portfolio);

        Portfolio savedPortfolio = portfolioDAO.find(4);

        assertEquals(4, savedPortfolio.getId());
        assertEquals(1, savedPortfolio.getIdentityList().get(0).getId());
        assertEquals(1, savedPortfolio.getIndustryList().get(0).getId());
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
    public void deletePortfolioIndustryFromIndustryList() {
        Portfolio portfolio = portfolioDAO.find(1);
        Industry industry = portfolio.getIndustryList().get(0);
        portfolio.getIndustryList().remove(industry);

        assertEquals(1, portfolio.getIndustryList().size());
    }

    @Test
    @Transactional
    @DirtiesContext
    public void saveNewPortfolioNewIdentityNewEducationAndNewCategory() {
        Portfolio portfolio = new Portfolio();
//        portfolio.setSpecialization("Food and Beverage");

        Industry industry = new Industry();
        industry.setId(1);
        industry.setVersion(0);
        industry.setCreationTime(new Date());
        industry.setUpdateTime(new Date());
        industry.setIndustry("Development");
        categoryDAO.saveOrUpdate(industry);

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

        Industry savedIndustry = categoryDAO.find(1);
        portfolio.addIndustry(savedIndustry);

        Identity savedIdentity = identityDAO.find(5);
        portfolio.addIdentity(savedIdentity);

        Education savedEducation = educationDAO.find(3);
        portfolio.addEducation(savedEducation);

        portfolioDAO.saveOrUpdate(portfolio);

        Portfolio savedPortfolio = portfolioDAO.find(4);

        assertEquals(4, savedPortfolio.getId());
        assertEquals(1, savedPortfolio.getIndustryList().get(0).getId());
        assertEquals(5, savedPortfolio.getIdentityList().get(0).getId());
        assertEquals(3, savedPortfolio.getEducationList().get(0).getId());
    }

    @Test
    @Transactional
    @DirtiesContext
    public void saveNewPortfolioSelectedCategorySelectedIdentityAndSelectedEducation() {
        Portfolio portfolio = new Portfolio();
//        portfolio.setSpecialization("Food and Beverage");

        List<Industry> categories = categoryDAO.findAll();
        Industry selectedIndustry = categories.get(0);

        List<Identity> identities = identityDAO.findAll();
        Identity selectedIdentity = identities.get(0);

        List<Education> educations = educationDAO.findAll();
        Education selectedEducation = educations.get(0);

        portfolio.addIndustry(selectedIndustry);
        portfolio.addIdentity(selectedIdentity);
        portfolio.addEducation(selectedEducation);
        portfolioDAO.saveOrUpdate(portfolio);

        Portfolio savedPortfolio = portfolioDAO.find(4);

        assertEquals(4, savedPortfolio.getId());
        assertEquals(1, savedPortfolio.getIndustryList().get(0).getId());
        assertEquals(1, savedPortfolio.getIdentityList().get(0).getId());
        assertEquals(1, savedPortfolio.getEducationList().get(0).getId());
    }
}
