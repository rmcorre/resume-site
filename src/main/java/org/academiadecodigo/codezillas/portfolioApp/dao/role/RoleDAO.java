package org.academiadecodigo.codezillas.portfolioApp.dao.role;

import org.academiadecodigo.codezillas.portfolioApp.dao.DAO;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.role.Role;

import java.util.List;

public interface RoleDAO extends DAO<Role> {

    List<Role> findAllById(Integer id);
}
