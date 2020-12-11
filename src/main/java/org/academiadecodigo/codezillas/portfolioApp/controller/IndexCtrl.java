package org.academiadecodigo.codezillas.portfolioApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexCtrl {

    @GetMapping("/index")
    public String index() {
        return "index";
    }
}
