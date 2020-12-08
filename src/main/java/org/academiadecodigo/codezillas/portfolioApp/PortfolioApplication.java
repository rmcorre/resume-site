package org.academiadecodigo.codezillas.portfolioApp;

import org.academiadecodigo.codezillas.portfolioApp.dao.address.AddressDAO;
import org.academiadecodigo.codezillas.portfolioApp.dao.identity.IdentityDAO;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.address.Address;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.identity.Identity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PortfolioApplication implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final IdentityDAO identityDAO;
    private final AddressDAO addressDAO;

    @Autowired
    public PortfolioApplication(IdentityDAO identityDAO, AddressDAO addressDAO) {
        this.identityDAO = identityDAO;
        this.addressDAO = addressDAO;
    }

    public static void main(String[] args) {
        SpringApplication.run(PortfolioApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        Identity identity = identityDAO.find(1);
//        logger.info("Identity 1 --> {}", identity);

//        Address address = addressDAO.find(1);
//        logger.info("Address 1 --> {}", address);

    }
}
