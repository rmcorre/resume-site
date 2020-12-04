package org.academiadecodigo.codezillas.portfolioApp.dao.address;

import org.academiadecodigo.codezillas.portfolioApp.dao.GenericDAO;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.address.Address;
import org.springframework.stereotype.Repository;

@Repository
public class AddressDAOImpl extends GenericDAO<Address> implements AddressDAO {

    public AddressDAOImpl() {
        super(Address.class);
    }
}
