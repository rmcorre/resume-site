package org.academiadecodigo.codezillas.portfolioApp.domainModel.industry;

import org.academiadecodigo.codezillas.portfolioApp.domainModel.AbstractModel;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.portfolio.Portfolio;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Industry extends AbstractModel {

    private String industry;

    @ManyToMany(mappedBy = "industryList")
    private final List<Portfolio> portfolioList = new ArrayList<>();

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String category) {
        this.industry = category;
    }

    public List<Portfolio> getPortfolioList() {
        return portfolioList;
    }

    public void addPortfolio(Portfolio portfolio) {
        portfolioList.add(portfolio);
    }

    public void removePortfolio(Portfolio portfolio) {
        portfolioList.remove(portfolio);
    }


}
