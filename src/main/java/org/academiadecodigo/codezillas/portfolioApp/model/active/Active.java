package org.academiadecodigo.codezillas.portfolioApp.domainModel.active;

import org.academiadecodigo.codezillas.portfolioApp.domainModel.AbstractModel;

import javax.persistence.Entity;

@Entity
public class Active extends AbstractModel {

    private String entity;
    private Integer entityId;

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public Integer getEntityId() {
        return entityId;
    }

    public void setEntityId(Integer entityId) {
        this.entityId = entityId;
    }
}
