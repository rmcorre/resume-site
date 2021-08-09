package org.academiadecodigo.codezillas.portfolioApp.controller;

import org.academiadecodigo.codezillas.portfolioApp.dao.address.AddressDAO;
import org.academiadecodigo.codezillas.portfolioApp.dao.contact.ContactDAO;
import org.academiadecodigo.codezillas.portfolioApp.dao.education.EducationDAO;
import org.academiadecodigo.codezillas.portfolioApp.dao.educationGroup.EducationGroupDAO;
import org.academiadecodigo.codezillas.portfolioApp.dao.identity.IdentityDAO;
import org.academiadecodigo.codezillas.portfolioApp.dao.industry.IndustryDAO;
import org.academiadecodigo.codezillas.portfolioApp.dao.knowledge.KnowledgeDAO;
import org.academiadecodigo.codezillas.portfolioApp.dao.portfolio.PortfolioDAO;
import org.academiadecodigo.codezillas.portfolioApp.dao.role.RoleDAO;
import org.academiadecodigo.codezillas.portfolioApp.dao.skill.SkillDAO;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.address.Address;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.contact.Contact;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.education.Education;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.education.EducationGroup;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.identity.Identity;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.industry.Industry;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.knowledge.Knowledge;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.portfolio.Portfolio;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.role.Role;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.skill.Skill;
import org.academiadecodigo.codezillas.portfolioApp.dto.PortfolioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("portfolio")
@SessionAttributes({"portfolio, portfolioDTO"})
public class PortfolioCtrl {

    private final PortfolioDAO portfolioDAO;

    private final IdentityDAO identityDAO;
    private final AddressDAO addressDAO;
    private final ContactDAO contactDAO;
    private final IndustryDAO industryDAO;
    private final RoleDAO roleDAO;
    private final EducationGroupDAO educationGroupDAO;
    private final KnowledgeDAO knowledgeDAO;
    private final SkillDAO skillDAO;

    @Autowired
    public PortfolioCtrl(PortfolioDAO portfolioDAO, IndustryDAO industryDAO, RoleDAO roleDAO, IdentityDAO identityDAO, AddressDAO addressDAO, ContactDAO contactDAO, EducationGroupDAO educationGroupDAO, KnowledgeDAO knowledgeDAO, SkillDAO skillDAO) {
        this.portfolioDAO = portfolioDAO;
        this.industryDAO = industryDAO;
        this.roleDAO = roleDAO;
        this.identityDAO = identityDAO;
        this.addressDAO = addressDAO;
        this.contactDAO = contactDAO;
        this.educationGroupDAO = educationGroupDAO;
        this.knowledgeDAO = knowledgeDAO;
        this.skillDAO = skillDAO;
    }

    @GetMapping("/create")
    public String create(Model model, HttpSession httpSession) {

        Portfolio portfolio = new Portfolio();

        Set<Industry> industrySet = new HashSet<>(industryDAO.findAll());
        Set<Role> roleSet = new HashSet<>(roleDAO.findAll());
        Set<Identity> identitySet = new HashSet<>(identityDAO.findAll());
        Set<Address> addressSet = new HashSet<>(addressDAO.findAll());
        Set<Contact> contactSet = new HashSet<>(contactDAO.findAll());
        Set<EducationGroup> educationGroupSet = new HashSet<>(educationGroupDAO.findAll());

        model.addAttribute("portfolio", portfolio);
        model.addAttribute("industrySet", industrySet);
        model.addAttribute("roleSet", roleSet);
        model.addAttribute("identitySet", identitySet);
        model.addAttribute("addressSet", addressSet);
        model.addAttribute("contactSet", contactSet);
        model.addAttribute("educationGroupSet", educationGroupSet);

        model.addAttribute("savedIndustry", httpSession.getAttribute("savedIndustry"));
        model.addAttribute("savedRole", httpSession.getAttribute("savedRole"));
        model.addAttribute("savedIdentity", httpSession.getAttribute("savedIdentity"));
        model.addAttribute("savedAddress", httpSession.getAttribute("savedAddress"));
        model.addAttribute("savedContact", httpSession.getAttribute("savedContact"));
        model.addAttribute("savedEducationGroup", httpSession.getAttribute("savedEducationGroup"));



        return "portfolio/create";
    }

    @PostMapping("/process")
    public String process(Portfolio portfolio) {

        Portfolio savedPortfolio = portfolioDAO.saveOrUpdate(portfolio);

        return "redirect:/portfolio/createConfirmation";
    }

    @GetMapping("/createConfirmation")
    public String createConfirmation() {

        return "portfolio/createConfirmation";
    }

}
