package org.academiadecodigo.codezillas.portfolioApp.dao.role;

import org.academiadecodigo.codezillas.portfolioApp.dao.GenericDAO;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.role.Role;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDAOImpl extends GenericDAO<Role> implements RoleDAO {
    public RoleDAOImpl() {
        super(Role.class);
    }
}
