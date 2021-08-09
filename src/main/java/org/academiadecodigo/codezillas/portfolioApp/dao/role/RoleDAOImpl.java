package org.academiadecodigo.codezillas.portfolioApp.dao.role;

import org.academiadecodigo.codezillas.portfolioApp.dao.GenericDAO;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.role.Role;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public class RoleDAOImpl extends GenericDAO<Role> implements RoleDAO {
    public RoleDAOImpl() {
        super(Role.class);
    }

    @Override
    public List<Role> findAllById(Integer id) {

        return em.createQuery("SELECT r FROM Role r where r.id=:roleId", Role.class)
                .setParameter("roleId", id)
                .getResultList();
    }
}
