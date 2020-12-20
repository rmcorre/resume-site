package org.academiadecodigo.codezillas.portfolioApp.domainModel.industry;

import org.academiadecodigo.codezillas.portfolioApp.domainModel.AbstractModel;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.knowledge.Knowledge;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.portfolio.Portfolio;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Industry extends AbstractModel {

    private String industry;

    @ManyToMany(mappedBy = "industryList")
    private final List<Portfolio> portfolioList = new ArrayList<>();

    @ManyToMany
    @JoinTable(
        name = "industry_knowledge",
        joinColumns = @JoinColumn(name = "industry_id"),
        inverseJoinColumns = @JoinColumn(name = "knowledge_id"))
    private final List<Knowledge> knowledgeList = new ArrayList<>();

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

    public List<Knowledge> getKnowledgeList() {
        return knowledgeList;
    }

    public void addKnowledge(Knowledge knowledge) {
        knowledgeList.add(knowledge);
    }

    public void removeKnowledge(Knowledge knowledge) {
        knowledgeList.remove(knowledge);
    }
}
