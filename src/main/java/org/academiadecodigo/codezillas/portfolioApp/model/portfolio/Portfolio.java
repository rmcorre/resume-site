package org.academiadecodigo.codezillas.portfolioApp.domainModel.portfolio;

import org.academiadecodigo.codezillas.portfolioApp.domainModel.AbstractModel;

import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class Portfolio extends AbstractModel {

    private Integer industryId;
    private Integer roleId;
    private String summary;

    private Integer identityId;
    private Integer addressId;
    private Integer contactId;

    private Integer educationGroupId;
    private Integer experienceId;
    private Integer knowledgeId;

    public Integer getIndustryId() {
        return industryId;
    }

    public void setIndustryId(Integer industryId) {
        this.industryId = industryId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Integer getIdentityId() {
        return identityId;
    }

    public void setIdentityId(Integer identityId) {
        this.identityId = identityId;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    public Integer getEducationGroupId() {
        return educationGroupId;
    }

    public void setEducationGroupId(Integer educationGroupId) {
        this.educationGroupId = educationGroupId;
    }

    public Integer getExperienceId() {
        return experienceId;
    }

    public void setExperienceId(Integer experienceId) {
        this.experienceId = experienceId;
    }

    public Integer getKnowledgeId() {
        return knowledgeId;
    }

    public void setKnowledgeId(Integer knowledgeId) {
        this.knowledgeId = knowledgeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Portfolio portfolio = (Portfolio) o;
        return Objects.equals(industryId, portfolio.industryId) && Objects.equals(roleId, portfolio.roleId) && Objects.equals(identityId, portfolio.identityId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(industryId, roleId, identityId);
    }

    @Override
    public String toString() {
        return "Portfolio{" +
                "industryId=" + industryId +
                ", roleId=" + roleId +
                ", summary='" + summary + '\'' +
                ", identityId=" + identityId +
                ", addressId=" + addressId +
                ", contactId=" + contactId +
                ", educationGroupId=" + educationGroupId +
                ", experienceId=" + experienceId +
                ", knowledgeId=" + knowledgeId +
                "} " + super.toString();
    }
}
