package org.academiadecodigo.codezillas.portfolioApp.persistence.identity;

import org.academiadecodigo.codezillas.portfolioApp.domainModel.identity.Identity;
import org.academiadecodigo.codezillas.portfolioApp.persistence.GenericPersist;

public class PersistIdentities extends GenericPersist<Identity> {

    public PersistIdentities(Class<Identity> modelType) {
        super(modelType);
    }
}
