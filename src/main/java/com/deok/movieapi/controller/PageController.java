package com.deok.movieapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "")

public class PageController {

    @GetMapping("")
    public String something(){
        return "index";
    }
}
