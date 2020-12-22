package org.academiadecodigo.codezillas.portfolioApp.domainModel.role;

import org.academiadecodigo.codezillas.portfolioApp.PortfolioApplication;
import org.academiadecodigo.codezillas.portfolioApp.dao.role.RoleDAO;
import org.academiadecodigo.codezillas.portfolioApp.dao.skill.SkillDAO;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.skill.Skill;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import javax.transaction.Transactional;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = PortfolioApplication.class)
public class RoleTest {

    @Autowired
    private RoleDAO roleDAO;

    @Autowired
    private SkillDAO skillDAO;

    @Test
    @Transactional
    @DirtiesContext
    public void new_Role() {
        Role role = new Role();

        role.setId(1);
        role.setVersion(0);
        role.setCreationTime(new Date());
        role.setUpdateTime(new Date());
        role.setRole("Fullstack Developer");
        roleDAO.saveOrUpdate(role);

        Role savedRole = roleDAO.find(1);

        assertEquals(1, savedRole.getId());
        assertEquals(0, savedRole.getVersion());
        assertEquals("Fullstack Developer", savedRole.getRole());
    }

    @Test
    @Transactional
    @DirtiesContext
    public void add_skill() {
        Role role = new Role();
        Skill skill = new Skill();

        role.setId(1);
        role.setVersion(0);
        role.setCreationTime(new Date());
        role.setUpdateTime(new Date());
        role.setRole("Fullstack Developer");
        roleDAO.saveOrUpdate(role);
        Role savedRole = roleDAO.find(1);

        skill.setId(1);
        skill.setVersion(0);
        skill.setCreationTime(new Date());
        skill.setUpdateTime(new Date());
        skill.setSkillName("JPA");
        skillDAO.saveOrUpdate(skill);
        Skill savedSkill = skillDAO.find(1);

        savedRole.getSkillSet().add(savedSkill);
        Role savedRoleWithSkillAdded = roleDAO.find(1);

        assertTrue(savedRoleWithSkillAdded.getSkillSet().contains(savedSkill));
    }

    @Test
    @Transactional
    @DirtiesContext
    public void remove_skill() {
        Role role = new Role();
        Skill skill = new Skill();

        role.setId(1);
        role.setVersion(0);
        role.setCreationTime(new Date());
        role.setUpdateTime(new Date());
        role.setRole("Fullstack Developer");
        roleDAO.saveOrUpdate(role);
        Role savedRole = roleDAO.find(1);

        skill.setId(1);
        skill.setVersion(0);
        skill.setCreationTime(new Date());
        skill.setUpdateTime(new Date());
        skill.setSkillName("JPA");
        skillDAO.saveOrUpdate(skill);
        Skill savedSkill = skillDAO.find(1);

        savedRole.getSkillSet().add(savedSkill);
        Role roleWithSkillAdded = roleDAO.find(1);

        roleWithSkillAdded.removeSkill(savedSkill);
        Role roleWithSkillRemoved = roleDAO.find(1);

        assertEquals(0, roleWithSkillRemoved.getSkillSet().size());
    }
}
