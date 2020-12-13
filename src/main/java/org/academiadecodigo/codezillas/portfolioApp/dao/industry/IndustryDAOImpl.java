package org.academiadecodigo.codezillas.portfolioApp.dao.industry;

import org.academiadecodigo.codezillas.portfolioApp.dao.GenericDAO;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.industry.Industry;
import org.springframework.stereotype.Repository;

@Repository
public class IndustryDAOImpl extends GenericDAO<Industry> implements IndustryDAO {
    public IndustryDAOImpl() {
        super(Industry.class);
    }
}
