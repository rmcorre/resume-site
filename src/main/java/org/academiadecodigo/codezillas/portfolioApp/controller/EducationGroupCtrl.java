package org.academiadecodigo.codezillas.portfolioApp.controller;

import net.bytebuddy.agent.builder.AgentBuilder;
import org.academiadecodigo.codezillas.portfolioApp.dao.education.EducationDAO;
import org.academiadecodigo.codezillas.portfolioApp.dao.educationGroup.EducationGroupDAO;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.education.Education;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.education.EducationGroup;
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
@RequestMapping("/educationGroup")
@SessionAttributes("educationGroup")
public class EducationGroupCtrl {

    private final EducationGroupDAO educationGroupDAO;
    private final EducationDAO educationDAO;

    @Autowired
    public EducationGroupCtrl(EducationGroupDAO educationGroupDAO, EducationDAO educationDAO) {
        this.educationGroupDAO = educationGroupDAO;
        this.educationDAO = educationDAO;
    }

    @GetMapping("/create")
    public String create(Model model) {

        EducationGroup educationGroup = new EducationGroup();
        Set<Education> educationSet = new HashSet<>(educationDAO.findAll());

        model.addAttribute("educationGroup", educationGroup);
        model.addAttribute("educationSet", educationSet);
        return "educationGroup/create";
    }

    @PostMapping("/saveAndRedirectToPortfolioCreate")
    public String saveAndRedirectToPortfolioCreate(EducationGroup newEducationGroup, HttpSession httpSession) {

        for (Integer education : newEducationGroup.getEducations()) {
            newEducationGroup.addEducation(educationDAO.find(education));
        }

        EducationGroup savedEducationGroup = educationGroupDAO.saveOrUpdate(newEducationGroup);
        httpSession.setAttribute("savedEducationGroup", savedEducationGroup);

        return "redirect:/portfolio/create";
    }
}
