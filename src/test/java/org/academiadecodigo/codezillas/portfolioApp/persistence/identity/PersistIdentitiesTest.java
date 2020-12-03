package org.academiadecodigo.codezillas.portfolioApp.persistence.identity;

import org.academiadecodigo.codezillas.portfolioApp.domainModel.address.Address;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.identity.Identity;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersistIdentitiesTest {

    static Identity identity1;
    static Address address1;
    static Identity identity2;
    static Address address2;

    static PersistIdentities identitiesList;

    @BeforeAll
    static void persistIdentitiesInit() {
        identitiesList = new PersistIdentities(Identity.class);

        identity1 = new Identity(
                1, 0, new Date(), new Date(),
                "Horacio", "Correia", "rmcorre@gmail.com", "91 421 3861");
        identity2 = new Identity(
                2, 0, new Date(), new Date(),
                "Ross", "Correia", "rmcorre@gmail.com", "91 421 3861");
    }

    @Test
    void saveOrUpdateTest() {
        identitiesList.saveOrUpdate(identity1);
        identitiesList.saveOrUpdate(identity2);

        assertEquals(2, identitiesList.getList().size());
    }


}
