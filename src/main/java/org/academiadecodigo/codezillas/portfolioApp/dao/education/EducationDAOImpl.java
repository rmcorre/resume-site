package org.academiadecodigo.codezillas.portfolioApp.dao.education;

import org.academiadecodigo.codezillas.portfolioApp.dao.GenericDAO;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.education.Education;
import org.springframework.stereotype.Repository;

@Repository
public class EducationDAOImpl extends GenericDAO<Education> implements EducationDAO {

    public EducationDAOImpl() {
        super(Education.class);
    }
}
