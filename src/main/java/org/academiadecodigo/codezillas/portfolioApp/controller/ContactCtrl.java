package org.academiadecodigo.codezillas.portfolioApp.controller;

import org.academiadecodigo.codezillas.portfolioApp.dao.contact.ContactDAO;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.contact.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/contact")
@SessionAttributes({"newContact"})
public class ContactCtrl {

    private final ContactDAO contactDAO;


    @Autowired
    public ContactCtrl(ContactDAO contactDAO) {
        this.contactDAO = contactDAO;
    }

    @GetMapping("/create")
    public String create(Model model) {

        Contact newContact = new Contact();
        model.addAttribute("newContact", newContact);

        return "contact/create";
    }

    @PostMapping("/showPortfolioCreate")
    public String showPortfolioCreate(
            Contact newContact,
            HttpSession httpSession) {

        Contact savedContact = contactDAO.saveOrUpdate(newContact);
        httpSession.setAttribute("savedContact", savedContact);

        return "redirect:/portfolio/create";
    }
}
