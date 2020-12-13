package org.academiadecodigo.codezillas.portfolioApp.domainModel.role;

import org.academiadecodigo.codezillas.portfolioApp.domainModel.AbstractModel;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.portfolio.Portfolio;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Role extends AbstractModel {

    private String role;

    @ManyToMany
    private final List<Portfolio> portfolioList = new ArrayList<>();

    public String getRole() {
        return role;
    }

    public void setRole(String function) {
        this.role = function;
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
