package org.academiadecodigo.codezillas.portfolioApp.controller;

import org.academiadecodigo.codezillas.portfolioApp.dao.industry.IndustryDAO;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.industry.Industry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/industry")
@SessionAttributes({"industry"})
public class IndustryCtrl {

    private final IndustryDAO industryDAO;

    @Autowired
    public IndustryCtrl(IndustryDAO industryDAO) {
        this.industryDAO = industryDAO;
    }

    @GetMapping("/create")
    public String create(Model model) {

        Industry industry = new Industry();

        model.addAttribute("industry", industry);
        return "industry/create";
    }

    @PostMapping("/process")
    public String process(
            Industry industry,
            RedirectAttributes redirectAttributes) {

        Industry industry1 = industryDAO.saveOrUpdate(industry);

        redirectAttributes.addAttribute("industryId", industry1.getId());
        return "redirect:/industry/createConfirmation";
    }
    
    @GetMapping("/createConfirmation")
    public String createConfirmation(
            @RequestParam("industryId") Integer industryId,
            Model model) {

        Industry retrievedIndustry = industryDAO.find(industryId);

        model.addAttribute("industry", retrievedIndustry);
        return "industry/createConfirmation";
    }
}
