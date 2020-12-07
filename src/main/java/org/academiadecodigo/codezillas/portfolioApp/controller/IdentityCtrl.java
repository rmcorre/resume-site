package org.academiadecodigo.codezillas.portfolioApp.controller;

import org.academiadecodigo.codezillas.portfolioApp.dao.identity.IdentityDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IdentityCtrl {

    private final IdentityDAO identityDAO;

    @Autowired
    public IdentityCtrl(IdentityDAO identityDAO) {
        this.identityDAO = identityDAO;
    }

    @GetMapping("/createForm")
    public String createForm() {

        return "createForm";
    }
}
