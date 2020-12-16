package org.academiadecodigo.codezillas.portfolioApp.controller;

import org.academiadecodigo.codezillas.portfolioApp.dao.role.RoleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/role")
@SessionAttributes({})
public class RoleCtrl {

    private final RoleDAO roleDAO;

    @Autowired
    public RoleCtrl(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

}
