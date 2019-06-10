package com.deok.movieapi.controller;

import com.deok.movieapi.model.MovieVO;
import com.deok.movieapi.service.MovieAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@RestController
@RequestMapping(value = "/api")

public class MainController {
    @Autowired
    MovieAPIService movieAPIService;

    @GetMapping("/")
    public String something(){
        return "index";
    }
    @GetMapping("/find/{title}")
    public List<MovieVO> findByTitle(@PathVariable(value = "title") String title){
        return movieAPIService.findMovie(title);
    }
    @GetMapping("/rank")
    public List<MovieVO> getRanking(){
        return movieAPIService.getRanking();
    }
}
