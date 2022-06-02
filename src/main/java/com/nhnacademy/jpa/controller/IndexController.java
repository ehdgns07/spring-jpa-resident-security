package com.nhnacademy.jpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/")
    String viewIndex(){
        return "redirect:/resident/index?page=0&size=5";
    }
}
