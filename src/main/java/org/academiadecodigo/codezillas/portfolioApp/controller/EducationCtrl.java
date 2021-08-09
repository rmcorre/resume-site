package org.academiadecodigo.codezillas.portfolioApp.controller;

import org.academiadecodigo.codezillas.portfolioApp.dao.education.EducationDAO;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.education.Education;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/education")
@SessionAttributes({"newEducation"})
public class EducationCtrl {

    private final EducationDAO educationDAO;

    @Autowired
    public EducationCtrl(EducationDAO educationDAO) {
        this.educationDAO = educationDAO;
    }

    @GetMapping("/create")
    public String create(Model model) {

        Education newEducation = new Education();
        model.addAttribute("newEducation", newEducation);

        return "education/create";
    }

    @PostMapping("/saveAndRedirectToPortfolioCreate")
    public String saveAndRedirectToPortfolioCreate(Education newEducation, HttpSession httpSession) {

        Education savedEducation = educationDAO.saveOrUpdate(newEducation);
        httpSession.setAttribute("savedEducation", savedEducation);

        return "redirect:/portfolio/create";
    }
}
