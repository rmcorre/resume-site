package org.academiadecodigo.codezillas.portfolioApp.dao.knowledge;

import org.academiadecodigo.codezillas.portfolioApp.dao.GenericDAO;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.knowledge.Knowledge;
import org.springframework.stereotype.Repository;

@Repository
public class KnowledgeDAOImpl extends GenericDAO<Knowledge> implements KnowledgeDAO {
    public KnowledgeDAOImpl() {
        super(Knowledge.class);
    }
}
