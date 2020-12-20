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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

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
        List<Education> educationList = educationDAO.findAll();

        model.addAttribute("educationGroup", educationGroup);
        model.addAttribute("educationList", educationList);
        return "educationGroup/create";
    }
}
