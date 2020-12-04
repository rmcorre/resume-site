package org.academiadecodigo.codezillas.portfolioApp.dao;

import org.academiadecodigo.codezillas.portfolioApp.domainModel.Model;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public abstract class GenericDAO<T extends Model> implements DAO<T> {

    @PersistenceContext
    protected EntityManager em;

    protected Class<T> modelType;


    public GenericDAO(Class<T> modelType) {
        this.modelType = modelType;
    }

    @Override
    public T find(Integer id) {
        return em.find(modelType, id);
    }

    @Override
    public List<T> findAll() {

        CriteriaBuilder cB = em.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = cB.createQuery(modelType);
        Root<T> root = criteriaQuery.from(modelType);
        CriteriaQuery<T> select = criteriaQuery.select(root);
        TypedQuery<T> typedQuery = em.createQuery(select);
        return typedQuery.getResultList();
    }

    @Override
    public T saveOrUpdate(T modelObject) {
        return em.merge(modelObject);
    }

    @Override
    public void delete(Integer id) {
        em.remove(em.find(modelType, id));
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public Class<T> getModelType() {
        return modelType;
    }

    public void setModelType(Class<T> modelType) {
        this.modelType = modelType;
    }
}
