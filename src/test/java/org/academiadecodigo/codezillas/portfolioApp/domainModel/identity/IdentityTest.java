package org.academiadecodigo.codezillas.portfolioApp.domainModel.identity;

import org.junit.jupiter.api.BeforeAll;

import java.util.Date;


public class IdentityTest {

    static Identity identity;

    @BeforeAll
    static void identityInit() {
        identity = new Identity(
                1, 0, new Date(), new Date(),
                "Horacio", "Correia", "rmcorre@gmail.com", "91 421 3861");
    }

}
