package org.academiadecodigo.codezillas.portfolioApp.controller;

import org.academiadecodigo.codezillas.portfolioApp.dao.education.EducationDAO;
import org.academiadecodigo.codezillas.portfolioApp.dao.educationGroup.EducationGroupDAO;
import org.academiadecodigo.codezillas.portfolioApp.dao.identity.IdentityDAO;
import org.academiadecodigo.codezillas.portfolioApp.dao.industry.IndustryDAO;
import org.academiadecodigo.codezillas.portfolioApp.dao.portfolio.PortfolioDAO;
import org.academiadecodigo.codezillas.portfolioApp.dao.role.RoleDAO;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.education.Education;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.education.EducationGroup;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.identity.Identity;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.industry.Industry;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.portfolio.Portfolio;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.role.Role;
import org.academiadecodigo.codezillas.portfolioApp.dto.PortfolioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("portfolio")
@SessionAttributes({"portfolioDTO"})
public class PortfolioCtrl {

    private final PortfolioDAO portfolioDAO;
    private final IndustryDAO industryDAO;
    private final RoleDAO roleDAO;
    private final IdentityDAO identityDAO;
    private final EducationGroupDAO educationGroupDAO;

    @Autowired
    public PortfolioCtrl(PortfolioDAO portfolioDAO, IndustryDAO industryDAO, RoleDAO roleDAO, IdentityDAO identityDAO, EducationGroupDAO educationGroupDAO) {
        this.portfolioDAO = portfolioDAO;
        this.industryDAO = industryDAO;
        this.roleDAO = roleDAO;
        this.identityDAO = identityDAO;
        this.educationGroupDAO = educationGroupDAO;
    }

    @GetMapping("/create")
    public String create(Model model, HttpSession httpSession) {

        PortfolioDTO portfolioDTO = new PortfolioDTO();
        List<Portfolio> portfolioList = portfolioDAO.findAll();

        List<Industry> industryList = industryDAO.findAll();
        List<Role> roleList = roleDAO.findAll();
        List<Identity>  identityList = identityDAO.findAll();
        List<EducationGroup> educationGroupList = educationGroupDAO.findAll();

        model.addAttribute("portfolioDTO", portfolioDTO);
        model.addAttribute("industryList", industryList);
        model.addAttribute("roleList", roleList);
        model.addAttribute("identityList", identityList);
        model.addAttribute("educationGroupList", educationGroupList);
        model.addAttribute("savedRole", httpSession.getAttribute("savedRole"));
        model.addAttribute("savedIndustry", httpSession.getAttribute("savedIndustry"));
        return "portfolio/create";
    }

    @PostMapping("/process")
    public String process(
            PortfolioDTO portfolioDTO) {

        Portfolio portfolio = new Portfolio();
        Industry industry = industryDAO.find(portfolioDTO.getIndustry());

        portfolio.addIndustry(industry);
        Portfolio savedPortfolio = portfolioDAO.saveOrUpdate(portfolio);

        System.out.println(savedPortfolio.getIndustryList().get(0));

        return "redirect:/portfolio/createConfirmation";
    }

    @GetMapping("/createConfirmation")
    public String createConfirmation() {

        return "portfolio/createConfirmation";
    }

}
