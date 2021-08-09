package org.academiadecodigo.codezillas.portfolioApp.domainModel.knowledge;

import org.academiadecodigo.codezillas.portfolioApp.domainModel.AbstractModel;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.industry.Industry;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.portfolio.Portfolio;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.*;

@Entity
public class Knowledge extends AbstractModel {

    private String knowledgeItem;

//    @ManyToMany(mappedBy = "knowledgeSet")
//    private final Set<Portfolio> portfolioSet = new HashSet<>();

    @ManyToMany(mappedBy = "knowledgeSet")
    private final Set<Industry> industrySet = new HashSet<>();

    public String getKnowledgeItem() {
        return knowledgeItem;
    }

    public void setKnowledgeItem(String knowledgeItem) {
        this.knowledgeItem = knowledgeItem;
    }

//    public Set<Portfolio> getPortfolioSet() {
//        return portfolioSet;
//    }

//    public void addPortfolio(Portfolio portfolio) {
//        portfolioSet.add(portfolio);
//        portfolio.getKnowledgeSet().add(this);
//    }

//    public void removePortfolio(Portfolio portfolio) {
//        portfolioSet.remove(portfolio);
//        portfolio.getKnowledgeSet().remove(this);
//    }

    public Set<Industry> getIndustrySet() {
        return industrySet;
    }

    public void addIndustry(Industry industry) {
        industrySet.add(industry);
        industry.getKnowledgeSet().remove(this);
    }

    public void removeIndustry(Industry industry) {
        industrySet.remove(industry);
        industry.getKnowledgeSet().remove(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Knowledge knowledge = (Knowledge) o;
        return Objects.equals(knowledgeItem, knowledge.knowledgeItem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(knowledgeItem);
    }

    @Override
    public String toString() {
        return "Knowledge{" +
                "knowledgeItem='" + knowledgeItem + '\'' +
                "} " + super.toString();
    }
}
