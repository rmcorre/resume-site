package org.academiadecodigo.codezillas.portfolioApp.domainModel.role;

import org.academiadecodigo.codezillas.portfolioApp.domainModel.AbstractModel;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.portfolio.Portfolio;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.skill.Skill;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.*;

@Entity
public class Role extends AbstractModel {

    private String role;

    @ManyToMany
    private final List<Portfolio> portfolioList = new ArrayList<>();

    @ManyToMany
    @JoinTable(
        name = "role_skill",
        joinColumns = @JoinColumn(name = "role_id"),
        inverseJoinColumns = @JoinColumn(name = "skill_id"))
    private final Set<Skill> skillSet = new HashSet<>();

    public String getRole() {
        return role;
    }

    public void setRole(String function) {
        this.role = function;
    }

    public Set<Skill> getSkillSet() {
        return skillSet;
    }

    public void addSkill(Skill skill) {
        skillSet.add(skill);
        skill.getRoleSet().add(this);
    }

    public void removeSkill(Skill skill) {
        skillSet.remove(skill);
        skill.getRoleSet().remove(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role1 = (Role) o;
        return Objects.equals(role, role1.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(role);
    }

    @Override
    public String toString() {
        return "Role{" +
                "role='" + role + '\'' +
                "} " + super.toString();
    }
}
