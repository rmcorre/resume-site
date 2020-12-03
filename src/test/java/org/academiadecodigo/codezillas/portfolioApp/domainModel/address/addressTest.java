package org.academiadecodigo.codezillas.portfolioApp.domainModel.address;

import org.junit.jupiter.api.BeforeAll;

import java.util.Date;

public class addressTest {

    static Address address;

    @BeforeAll
    static void identityAddressInit() {
        address = new Address(
                1, 0, new Date(), new Date(),
                "identity", "19", "Rua Eng Hernani Santos", "Vila De Nordeste",
                "Nordeste", "Azores", "9630-202");
    }

}
