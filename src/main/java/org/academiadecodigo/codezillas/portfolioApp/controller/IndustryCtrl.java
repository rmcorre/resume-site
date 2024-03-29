package org.academiadecodigo.codezillas.portfolioApp.controller;

import org.academiadecodigo.codezillas.portfolioApp.dao.industry.IndustryDAO;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.industry.Industry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/industry")
@SessionAttributes({"newIndustry"})
public class IndustryCtrl {

    private final IndustryDAO industryDAO;

    @Autowired
    public IndustryCtrl(IndustryDAO industryDAO) {
        this.industryDAO = industryDAO;
    }

    @GetMapping("/create")
    public String create(Model model) {

        Industry newIndustry = new Industry();

        model.addAttribute("newIndustry", newIndustry);
        return "industry/create";
    }

    @PostMapping("/showPortfolioCreate")
    public String showPortfolioCreate(
            Industry newIndustry,
            HttpSession httpSession) {

        Industry savedIndustry = industryDAO.saveOrUpdate(newIndustry);
        httpSession.setAttribute("savedIndustry", savedIndustry.getIndustry());

        return "redirect:/portfolio/create";
    }
    
    @GetMapping("/createConfirmation")
    public String createConfirmation(
            @RequestParam("id") Integer id,
            Model model) {

        Industry retrievedIndustry = industryDAO.find(id);

        model.addAttribute("industry", retrievedIndustry);
        return "industry/createConfirmation";
    }
}
