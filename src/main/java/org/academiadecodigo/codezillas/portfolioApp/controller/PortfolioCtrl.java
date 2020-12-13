package org.academiadecodigo.codezillas.portfolioApp.controller;

import org.academiadecodigo.codezillas.portfolioApp.dao.education.EducationDAO;
import org.academiadecodigo.codezillas.portfolioApp.dao.role.RoleDAO;
import org.academiadecodigo.codezillas.portfolioApp.dao.identity.IdentityDAO;
import org.academiadecodigo.codezillas.portfolioApp.dao.industry.IndustryDAO;
import org.academiadecodigo.codezillas.portfolioApp.dao.portfolio.PortfolioDAO;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.education.Education;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.role.Role;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.identity.Identity;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.industry.Industry;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.portfolio.Portfolio;
import org.academiadecodigo.codezillas.portfolioApp.dto.PortfolioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@RequestMapping("portfolio")
@SessionAttributes()
public class PortfolioCtrl {

    private final PortfolioDAO portfolioDAO;
    private final IndustryDAO industryDAO;
    private final RoleDAO roleDAO;
    private final IdentityDAO identityDAO;
    private final EducationDAO educationDAO;

    @Autowired
    public PortfolioCtrl(PortfolioDAO portfolioDAO, IndustryDAO industryDAO, RoleDAO roleDAO, EducationDAO educationDAO, IdentityDAO identityDAO) {
        this.portfolioDAO = portfolioDAO;
        this.industryDAO = industryDAO;
        this.roleDAO = roleDAO;
        this.educationDAO = educationDAO;
        this.identityDAO = identityDAO;
    }

    @GetMapping("/create")
    public String create(Model model) {

        PortfolioDTO portfolioDTO = new PortfolioDTO();
        List<Portfolio> portfolioList = portfolioDAO.findAll();

        List<Industry> industryList = industryDAO.findAll();
        List<Role> roleList = roleDAO.findAll();

        List<Identity>  identityList = identityDAO.findAll();
        List<Education> educationList = educationDAO.findAll();

        model.addAttribute("portfolioDTO", portfolioDTO);
        model.addAttribute("industryList", industryList);
        model.addAttribute("functionList", roleList);
        model.addAttribute("identityList", identityList);
        model.addAttribute("educationList", educationList);
        return "portfolio/create";
    }
}
