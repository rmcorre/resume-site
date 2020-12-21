package org.academiadecodigo.codezillas.portfolioApp.dao.skill;

import org.academiadecodigo.codezillas.portfolioApp.dao.GenericDAO;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.skill.Skill;
import org.springframework.stereotype.Repository;

@Repository
public class SkillDAOImpl extends GenericDAO<Skill> implements SkillDAO {
    public SkillDAOImpl() {
        super(Skill.class);
    }
}
