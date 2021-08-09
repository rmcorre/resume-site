package org.academiadecodigo.codezillas.portfolioApp.dao.contact;

import org.academiadecodigo.codezillas.portfolioApp.dao.GenericDAO;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.contact.Contact;
import org.springframework.stereotype.Repository;

@Repository
public class ContactDAOImpl extends GenericDAO<Contact> implements ContactDAO {
    public ContactDAOImpl() {
        super(Contact.class);
    }
}
