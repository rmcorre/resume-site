package org.academiadecodigo.codezillas.portfolioApp.service.identity;

import org.academiadecodigo.codezillas.portfolioApp.domainModel.identity.Identity;

import java.util.Set;

public interface IdentitySvc {

    Identity find(Integer id);

    Set<Identity> findAll();

    Identity saveOrUpdate(Identity identity);

    void delete(Integer id);

//    Identity getActive();
}
