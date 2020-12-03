package org.academiadecodigo.codezillas.portfolioApp.persistence.identity;

import org.academiadecodigo.codezillas.portfolioApp.domainModel.identity.Identity;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PersistIdentitiesTest {

    static Identity identity1;
    static Identity identity2;

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

        identitiesList.saveOrUpdate(identity1);
        identitiesList.saveOrUpdate(identity2);
    }

    @Test
    void saveOrUpdateTest() {
        assertEquals(2, identitiesList.getList().size());
    }

    @Test
    void findAllTest() {
        List<Identity> resultList;
        resultList = identitiesList.findAll();

        assertEquals(2, resultList.size());
    }

    @Test
    void findValidIdTest() {
        Identity result;
        result = identitiesList.find(1);

        assertEquals(1, result.getId());
    }

    @Test
    void findInvalidIdTest() {
        Identity result;
        result = identitiesList.find(4);

        assertNull(result);
    }

    @Test
    void deleteTest() {
        identitiesList.delete(identity2);

        List<Identity> resultList;
        resultList = identitiesList.findAll();

        assertEquals(1, resultList.size());
        assertTrue(resultList.contains(identity1));
    }


}
