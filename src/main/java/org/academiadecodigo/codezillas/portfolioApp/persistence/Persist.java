package org.academiadecodigo.codezillas.portfolioApp.persistence;

import org.academiadecodigo.codezillas.portfolioApp.domainModel.Model;

import java.util.List;

public interface Persist<T extends Model> {

    T find(Integer id);

    List<T> findAll();

    Boolean saveOrUpdate(T modelObject);

    Boolean delete(T modelObject);
}
