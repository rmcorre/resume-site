package org.academiadecodigo.codezillas.portfolioApp.domainModel.portfolio;

import org.academiadecodigo.codezillas.portfolioApp.domainModel.AbstractModel;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.identity.Identity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Portfolio extends AbstractModel {

    private String category;
    private String specialization;

    @ManyToMany
    @JoinTable(
        name = "portfolio_identity",
        joinColumns = @JoinColumn(name = "portfolio_id"),
        inverseJoinColumns = @JoinColumn(name = "identity_id"))
    private final List<Identity> identityList = new ArrayList<>();

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public List<Identity> getIdentityList() {
        return identityList;
    }

    public void addIdentity(Identity identity) {
        identityList.add(identity);
    }
}
