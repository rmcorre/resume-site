package org.academiadecodigo.codezillas.portfolioApp.dao.educationGroup;

import org.academiadecodigo.codezillas.portfolioApp.dao.GenericDAO;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.education.EducationGroup;
import org.springframework.stereotype.Repository;

@Repository
public class EducationGroupDAOImpl extends GenericDAO<EducationGroup> implements EducationGroupDAO {
    public EducationGroupDAOImpl() {
        super(EducationGroup.class);
    }
}
