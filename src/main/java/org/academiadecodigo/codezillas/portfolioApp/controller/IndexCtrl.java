package org.academiadecodigo.codezillas.portfolioApp.controller;

import org.academiadecodigo.codezillas.portfolioApp.dao.identity.IdentityDAO;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.identity.Identity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class IndexCtrl {

    private final IdentityDAO identityDAO;

    @Autowired
    public IndexCtrl(IdentityDAO identityDAO) {
        this.identityDAO = identityDAO;
    }

    @GetMapping("/index")
    public String index(Model model, HttpSession httpSession) {

        Identity defaultIdentity = identityDAO.find(1);
        String name;

        if (httpSession.getAttribute("activeName") != null) {
            name = (String) httpSession.getAttribute("activeName");
        }
        else {
            name = defaultIdentity.getFirstName() + " " + defaultIdentity.getLastName();
        }

        model.addAttribute("name", name);

        return "index";
    }
}
