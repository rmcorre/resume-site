package org.academiadecodigo.codezillas.portfolioApp;

import org.academiadecodigo.codezillas.portfolioApp.dao.address.AddressDAO;
import org.academiadecodigo.codezillas.portfolioApp.dao.identity.IdentityDAO;
import org.academiadecodigo.codezillas.portfolioApp.dao.industry.IndustryDAO;
import org.academiadecodigo.codezillas.portfolioApp.dao.knowledge.KnowledgeDAO;
import org.academiadecodigo.codezillas.portfolioApp.dao.role.RoleDAO;
import org.academiadecodigo.codezillas.portfolioApp.dao.skill.SkillDAO;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.address.Address;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.identity.Identity;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.industry.Industry;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.knowledge.Knowledge;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.role.Role;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.skill.Skill;
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
    private final RoleDAO roleDAO;
    private final SkillDAO skillDAO;

    @Autowired
    public PortfolioApplication(IdentityDAO identityDAO, AddressDAO addressDAO, IndustryDAO industryDAO, KnowledgeDAO knowledgeDAO, RoleDAO roleDAO, SkillDAO skillDAO) {
        this.identityDAO = identityDAO;
        this.addressDAO = addressDAO;
        this.industryDAO = industryDAO;
        this.knowledgeDAO = knowledgeDAO;
        this.roleDAO = roleDAO;
        this.skillDAO = skillDAO;
    }

    public static void main(String[] args) {
        SpringApplication.run(PortfolioApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
//        Role role = new Role();
//        Skill skill = new Skill();
//
//        role.setId(4);
//        role.setVersion(0);
//        role.setCreationTime(new Date());
//        role.setUpdateTime(new Date());
//        role.setRole("JUnit Tester");
//        roleDAO.saveOrUpdate(role);
//        Role savedRole = roleDAO.find(4);
//
//        logger.info("savedRole --> " + savedRole.toString());
//
//        skill.setId(1);
//        skill.setVersion(0);
//        skill.setCreationTime(new Date());
//        skill.setUpdateTime(new Date());
//        skill.setSkillName("JPA");
//        skillDAO.saveOrUpdate(skill);
//        Skill savedSkill = skillDAO.find(1);
//
//        savedRole.getSkillSet().add(savedSkill);
//        Role savedRoleWithSkillAdded = roleDAO.find(1);
//
//        logger.info("savedRoleWithSkillAdded --> " + savedRoleWithSkillAdded.toString());

    }
}
