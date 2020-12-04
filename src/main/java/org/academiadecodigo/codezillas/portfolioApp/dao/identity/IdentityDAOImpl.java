package org.academiadecodigo.codezillas.portfolioApp.dao.identity;

import org.academiadecodigo.codezillas.portfolioApp.dao.GenericDAO;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.identity.Identity;
import org.springframework.stereotype.Repository;

@Repository
public class IdentityDAOImpl extends GenericDAO<Identity> implements IdentityDAO {

    public IdentityDAOImpl() {
        super(Identity.class);
    }

}

