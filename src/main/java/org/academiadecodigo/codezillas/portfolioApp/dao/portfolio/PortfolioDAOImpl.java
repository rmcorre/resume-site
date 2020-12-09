package org.academiadecodigo.codezillas.portfolioApp.dao.portfolio;

import org.academiadecodigo.codezillas.portfolioApp.dao.GenericDAO;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.portfolio.Portfolio;
import org.springframework.stereotype.Repository;

@Repository
public class PortfolioDAOImpl extends GenericDAO<Portfolio> implements PortfolioDAO {
    public PortfolioDAOImpl() {
        super(Portfolio.class);
    }
}
