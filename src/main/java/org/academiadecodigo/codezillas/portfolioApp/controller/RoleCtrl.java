package org.academiadecodigo.codezillas.portfolioApp.controller;

import org.academiadecodigo.codezillas.portfolioApp.dao.role.RoleDAO;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.role.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/role")
@SessionAttributes({"newRole"})
public class RoleCtrl {

    private final RoleDAO roleDAO;

    @Autowired
    public RoleCtrl(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    @GetMapping("/getRoles")
    public void getRoles(@RequestParam Integer id, Model model) {
        Set<Role> roleSet = new HashSet<Role>(roleDAO.findAllById(id));

        model.addAttribute("roleSet", roleSet);
    }

    @GetMapping("/create")
    public String create(Model model) {

        Role newRole = new Role();

        model.addAttribute("newRole", newRole);
        return "role/create";
    }

    @PostMapping("/showPortfolioCreate")
    public String showPortfolioCreate(
            Role newRole,
            HttpSession httpSession) {

        Role savedRole = roleDAO.saveOrUpdate(newRole);
        httpSession.setAttribute("savedRole", savedRole.getRole());

        return "redirect:/portfolio/create";
    }

}
