package org.academiadecodigo.codezillas.portfolioApp.domainModel.skill;

import org.academiadecodigo.codezillas.portfolioApp.domainModel.AbstractModel;

import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class Skill extends AbstractModel {

    private String skillName;

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Skill skill = (Skill) o;
        return Objects.equals(skillName, skill.skillName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(skillName);
    }

    @Override
    public String toString() {
        return "Skill{" +
                "skillName='" + skillName + '\'' +
                "} " + super.toString();
    }
}
