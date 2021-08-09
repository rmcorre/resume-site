package org.academiadecodigo.codezillas.portfolioApp.controller;

import org.academiadecodigo.codezillas.portfolioApp.dao.address.AddressDAO;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.address.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("address")
@SessionAttributes({})
public class AddressCtrl {

    private AddressDAO addressDAO;

    @Autowired
    public AddressCtrl(AddressDAO addressDAO) {
        this.addressDAO = addressDAO;
    }

    @GetMapping("/create")
    public String create(Model model) {

        Address address = new Address();
        model.addAttribute("address", address);

        return "address/create";
    }

    @PostMapping("/saveAndRedirectToPortfolioCreate")
    public String saveAndRedirectToPortfolioCreate(Address address, HttpSession httpSession) {

        Address savedAddress = addressDAO.saveOrUpdate(address);
        httpSession.setAttribute("savedAddress", savedAddress);

        return "redirect:/portfolio/create";
    }

}
