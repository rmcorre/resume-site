package org.academiadecodigo.codezillas.portfolioApp.domainModel;

import java.util.Date;

public class AbstractModel implements Model{

    private Integer id;
    private Integer version;
    private Date creationTime;
    private Date updateTime;

    public AbstractModel() {

    }

    public AbstractModel(Integer id, Integer version, Date creationTime, Date updateTime) {
        this.id = id;
        this.version = version;
        this.creationTime = creationTime;
        this.updateTime = updateTime;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "AbstractModel{" +
                "id=" + id +
                ", version=" + version +
                ", creationTime=" + creationTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
