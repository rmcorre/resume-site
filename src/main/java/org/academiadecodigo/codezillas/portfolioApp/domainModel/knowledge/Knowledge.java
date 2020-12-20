package org.academiadecodigo.codezillas.portfolioApp.domainModel.knowledge;

import org.academiadecodigo.codezillas.portfolioApp.domainModel.AbstractModel;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.industry.Industry;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Knowledge extends AbstractModel {

    private String knowledgeItem;

    @ManyToMany(mappedBy = "knowledgeList")
    private final List<Industry> industryList = new ArrayList<>();

    public String getKnowledgeItem() {
        return knowledgeItem;
    }

    public void setKnowledgeItem(String knowledgeItem) {
        this.knowledgeItem = knowledgeItem;
    }

    public List<Industry> getIndustryList() {
        return industryList;
    }

    public void addIndustry(Industry industry) {
        industryList.add(industry);
    }

    public void removeIndustry(Industry industry) {
        industryList.remove(industry);
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
