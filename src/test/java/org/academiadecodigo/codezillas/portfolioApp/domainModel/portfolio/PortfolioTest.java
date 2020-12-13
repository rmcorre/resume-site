package org.academiadecodigo.codezillas.portfolioApp.domainModel.portfolio;

import org.academiadecodigo.codezillas.portfolioApp.PortfolioApplication;
import org.academiadecodigo.codezillas.portfolioApp.dao.role.RoleDAO;
import org.academiadecodigo.codezillas.portfolioApp.dao.industry.IndustryDAO;
import org.academiadecodigo.codezillas.portfolioApp.dao.education.EducationDAO;
import org.academiadecodigo.codezillas.portfolioApp.dao.identity.IdentityDAO;
import org.academiadecodigo.codezillas.portfolioApp.dao.portfolio.PortfolioDAO;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.education.Education;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.role.Role;
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
    private PortfolioDAO portfolioDAO;

    @Autowired
    private IndustryDAO industryDAO;

    @Autowired
    private RoleDAO roleDAO;

    @Autowired
    private IdentityDAO identityDAO;

    @Autowired
    private EducationDAO educationDAO;


    @Test
    @Transactional
    @DirtiesContext
    public void saveNewPortfolioNewIndustryNewFunctionNewIdentityAndNewEducation() {
        Portfolio portfolio = new Portfolio();

        Industry industry = new Industry();
        industry.setId(3);
        industry.setVersion(0);
        industry.setCreationTime(new Date());
        industry.setUpdateTime(new Date());
        industry.setIndustry("Fake Industry");
        industryDAO.saveOrUpdate(industry);

        Role role = new Role();
        role.setId(4);
        role.setVersion(0);
        role.setCreationTime(new Date());
        role.setUpdateTime(new Date());
        role.setRole("Fake Role");
        roleDAO.saveOrUpdate(role);

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
        education.setInstitution("Fake Education");
        education.setCourse("Fake Course");
        educationDAO.saveOrUpdate(education);

        Industry savedIndustry = industryDAO.find(3);
        Role savedRole = roleDAO.find(4);
        Identity savedIdentity = identityDAO.find(5);
        Education savedEducation = educationDAO.find(3);
        portfolio.addIndustry(savedIndustry);
        portfolio.addRole(savedRole);
        portfolio.addIdentity(savedIdentity);
        portfolio.addEducation(savedEducation);
        portfolioDAO.saveOrUpdate(portfolio);

        Portfolio savedPortfolio = portfolioDAO.find(4);

        assertEquals(4, savedPortfolio.getId());
        assertEquals(3, savedPortfolio.getIndustryList().get(0).getId());
        assertEquals(4, savedPortfolio.getRoleList().get(0).getId());
        assertEquals(5, savedPortfolio.getIdentityList().get(0).getId());
        assertEquals(3, savedPortfolio.getEducationList().get(0).getId());
    }

    @Test
    @Transactional
    @DirtiesContext
    public void saveNewPortfolioSelectedIndustrySelectedRoleSelectedIdentityAndSelectedEducation() {
        Portfolio portfolio = new Portfolio();

        List<Industry> industries = industryDAO.findAll();
        List<Role> roles = roleDAO.findAll();
        List<Identity> identities = identityDAO.findAll();
        List<Education> educations = educationDAO.findAll();

        Industry selectedIndustry = industries.get(0);
        Role selectedRole = roles.get(0);
        Identity selectedIdentity = identities.get(0);
        Education selectedEducation = educations.get(0);

        portfolio.addIndustry(selectedIndustry);
        portfolio.addRole(selectedRole);
        portfolio.addIdentity(selectedIdentity);
        portfolio.addEducation(selectedEducation);
        portfolioDAO.saveOrUpdate(portfolio);

        Portfolio savedPortfolio = portfolioDAO.find(4);

        assertEquals(4, savedPortfolio.getId());
        assertEquals(1, savedPortfolio.getIndustryList().get(0).getId());
        assertEquals(1, savedPortfolio.getRoleList().get(0).getId());
        assertEquals(1, savedPortfolio.getIdentityList().get(0).getId());
        assertEquals(1, savedPortfolio.getEducationList().get(0).getId());
    }

    @Test
    @Transactional
    @DirtiesContext
    public void deleteIndustryFromIndustryList() {
        Portfolio portfolio = portfolioDAO.find(1);
        Industry industry = portfolio.getIndustryList().get(0);
        portfolio.getIndustryList().remove(industry);

        assertEquals(1, portfolio.getIndustryList().size());
    }

    @Test
    @Transactional
    @DirtiesContext
    public void deleteRoleFromRoleList() {
        Portfolio portfolio = portfolioDAO.find(1);
        Role role = portfolio.getRoleList().get(0);
        portfolio.getRoleList().remove(role);

        assertEquals(2, portfolio.getRoleList().size());
    }

    @Test
    @Transactional
    @DirtiesContext
    public void deleteIdentityFromIdentityList() {
        Portfolio portfolio = portfolioDAO.find(1);
        Identity identity = portfolio.getIdentityList().get(1);
        portfolio.getIdentityList().remove(identity);

        assertEquals(1, portfolio.getIdentityList().size());
    }

    @Test
    @Transactional
    @DirtiesContext
    public void deleteEducationFromEducationList() {
        Portfolio portfolio = portfolioDAO.find(1);
        Education education = portfolio.getEducationList().get(1);
        portfolio.getEducationList().remove(education);

        assertEquals(1, portfolio.getEducationList().size());
    }

}
