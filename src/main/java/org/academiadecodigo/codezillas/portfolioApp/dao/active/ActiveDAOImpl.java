package org.academiadecodigo.codezillas.portfolioApp.dao.active;

import org.academiadecodigo.codezillas.portfolioApp.dao.GenericDAO;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.active.Active;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

@Repository
public class ActiveDAOImpl extends GenericDAO<Active> implements ActiveDAO {

    public ActiveDAOImpl() {
        super(Active.class);
    }

    public Active findByEntity(String entity) {
        TypedQuery<Active> query = em.createQuery("Select a FROM Active a where a.entity=:entity", Active.class);
        query.setParameter("entity", entity);
        return query.getSingleResult();
    }
}
