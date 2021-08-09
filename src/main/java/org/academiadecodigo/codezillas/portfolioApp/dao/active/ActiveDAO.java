package org.academiadecodigo.codezillas.portfolioApp.dao.active;

import org.academiadecodigo.codezillas.portfolioApp.dao.DAO;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.active.Active;

public interface ActiveDAO extends DAO<Active> {

    Active findByEntity(String entity);
}
