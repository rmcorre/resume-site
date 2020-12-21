package org.academiadecodigo.codezillas.portfolioApp.domainModel.skill;

import org.academiadecodigo.codezillas.portfolioApp.PortfolioApplication;
import org.academiadecodigo.codezillas.portfolioApp.dao.skill.SkillDAO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = PortfolioApplication.class)
public class SkillTest {

    @Autowired
    private SkillDAO skillDAO;

    @Test
    @DirtiesContext
    public void new_skill() {
        Skill skill = new Skill();

        skill.setId(1);
        skill.setVersion(0);
        skill.setCreationTime(new Date());
        skill.setUpdateTime(new Date());
        skill.setSkillName("JPA");
        skillDAO.saveOrUpdate(skill);

        Skill savedSkill = skillDAO.find(1);

        assertEquals(1, savedSkill.getId());
        assertEquals(0, savedSkill.getVersion());
        assertEquals("JPA", savedSkill.getSkillName());
    }
}
