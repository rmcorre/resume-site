package org.academiadecodigo.codezillas.portfolioApp.dao;


import org.academiadecodigo.codezillas.portfolioApp.domainModel.Model;

import java.util.List;

/**
 * Base interface for data access objects
 *
 * @param <T> the model type
 */
public interface DAO<T extends Model> {

    /**
     * Gets the model
     *
     * @param id the model id
     * @return the model
     */
    T find(Integer id);

    /**
     * Gets a list of the model
     *
     * @return the model list
     */
    List<T> findAll();


    /**
     * Saves or updates the model
     *
     * @param modelObject the model to be saved or updated
     */
    T saveOrUpdate(T modelObject);

    /**
     * Delete the model
     *
     * @param id the id of the model to be deleted
     */
    void delete(Integer id);
}
