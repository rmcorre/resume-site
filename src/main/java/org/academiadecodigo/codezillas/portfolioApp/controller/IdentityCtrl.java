package org.academiadecodigo.codezillas.portfolioApp.controller;

import org.academiadecodigo.codezillas.portfolioApp.dao.active.ActiveDAO;
import org.academiadecodigo.codezillas.portfolioApp.dao.identity.IdentityDAO;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.active.Active;
import org.academiadecodigo.codezillas.portfolioApp.domainModel.identity.Identity;
import org.academiadecodigo.codezillas.portfolioApp.service.identity.IdentitySvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/identity")
@SessionAttributes({"identity"})
public class IdentityCtrl {

    private final IdentitySvc identitySvc;
    private final ActiveDAO activeDAO;

    @Autowired
    public IdentityCtrl(IdentitySvc identitySvc, ActiveDAO activeDAO) {
        this.identitySvc = identitySvc;
        this.activeDAO = activeDAO;
    }

    @GetMapping("/list")
    public String list(Model model, HttpSession httpSession) {

        Set<Identity> identitySet = new HashSet<>(identitySvc.findAll());
        Identity identity = new Identity();

        model.addAttribute("identitySet", identitySet);
        model.addAttribute("identity", identity);
        httpSession.setAttribute("identitySet", identitySet);

        return "identity/list";
    }

//    @GetMapping("/create")
//    public String createForm(Model model) {
//
//        Identity identity = new Identity();
//        model.addAttribute("identity", identity);
//
//        return "identity/create";
//    }
//
    @PostMapping("/saveAndRedirectToIdentityList")
    public String saveAndRedirectToIdentityList(@RequestBody Identity identity, HttpSession httpSession) {

        System.out.println("###############################" + identity.getId());

        Identity savedIdentity = identitySvc.saveOrUpdate(identity);
        String activeName;

//        if (identity.getActive()) {
//
//            // Get current active Identity
//            Active currentActive = activeDAO.findByEntity("Identity");
//
//            // Change active field in Identity to false
//            Identity formerActiveIdentity = identityDAO.find(currentActive.getEntityId());
//            formerActiveIdentity.setActive(false);
//
//
//            // Make saved Identity active
//            Active active = activeDAO.findByEntity("Identity");
//            active.setEntityId(savedIdentity.getId());
//            Active savedActive = activeDAO.saveOrUpdate(active);
//
//            // Create first name and last name string from active Identity
//            Identity activeIdentity = identityDAO.find(savedActive.getEntityId());
//            activeName = activeIdentity.getFirstName() + " " + activeIdentity.getLastName();
//
//            // Add active name to httpSession
//            httpSession.setAttribute("activeName", activeName);
//        }

        return "redirect:/identity/list";
    }

//    @RequestMapping("/getIdentity")
//    public Identity getIdentity(@RequestParam int id, Model model, HttpSession httpSession) {
//
//        return identityDAO.find(id);
//    }
}
