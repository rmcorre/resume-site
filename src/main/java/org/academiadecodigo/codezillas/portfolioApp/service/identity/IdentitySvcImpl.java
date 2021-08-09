package org.academiadecodigo.codezillas.portfolioApp.service.identity;

import org.academiadecodigo.codezillas.portfolioApp.dao.identity.IdentityDAO;
import org.academiadecodigo.codezillas.portfolioApp.dao.portfolio.PortfolioDAO;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.identity.Identity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class IdentitySvcImpl implements IdentitySvc {

    private IdentityDAO identityDAO;
    private PortfolioDAO portfolioDAO;

    public IdentitySvcImpl() {

    }

    @Autowired
    public IdentitySvcImpl(IdentityDAO identityDAO, PortfolioDAO portfolioDAO) {
        this.identityDAO = identityDAO;
        this.portfolioDAO = portfolioDAO;
    }

    @Override
    @Transactional
    public Identity find(Integer id) {
        return identityDAO.find(id);
    }

    @Override
    @Transactional
    public Set<Identity> findAll() {
        List<Identity> identityList = identityDAO.findAll();
        return new HashSet<>(identityList);
    }

    @Override
    @Transactional
    public Identity saveOrUpdate(Identity identity) {
        return identityDAO.saveOrUpdate(identity);
    }

    @Override
    @Transactional
    public void delete(Integer id) {

        System.out.println("\n************************* inside IdentitySvcImpl#delete");

//        List<Portfolio> portfolioList = portfolioDAO.findByProfileId(id);
//        if (portfolioList != null) {
//            for (Portfolio portfolio : portfolioList) {
//                portfolio.setProfile(null);
//            }
//        }

//
//        List<IdentityAddress>  addressList = profileAddressDAO.findAllByProfileId(id);
//        if (addressList != null) {
//            for (IdentityAddress address : addressList) {
//                address.setProfile(null);
//                profileAddressDAO.deleteAddress(address.getId());
//            }
//        }

        identityDAO.delete(id);
    }

//    @Override
//    @Transactional
//    public Identity getActive() {
//
//        Identity activeIdentity = identityDAO.getActiveProfile();
//
//        //Todo: should enforce uppercase as a form validation
//        String firstName = activeIdentity.getFirstName().toUpperCase();
//        activeIdentity.setFirstName(firstName);
//
//        String lastName = activeIdentity.getLastName().toUpperCase();
//        activeIdentity.setLastName(lastName);
//
//        return activeIdentity;
//    }
}
