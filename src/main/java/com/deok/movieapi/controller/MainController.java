package com.deok.movieapi.controller;

import com.deok.movieapi.model.MovieVO;
import com.deok.movieapi.service.MovieAPIService;
import com.deok.movieapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")

public class MainController {
    @Autowired
    MovieAPIService movieAPIService;
    @Autowired
    UserService userService;

    @GetMapping("/find/{title}/{apikey}")
    public List<MovieVO> findByTitle(@PathVariable(value = "title") String title, @PathVariable(value = "apikey") String apikey){
        return movieAPIService.findMovie(title, apikey);
    }
    @GetMapping("/rank/{apikey}")
    public List<MovieVO> getRanking(@PathVariable(value = "apikey") String apikey){
        return movieAPIService.getRanking(apikey);
    }
    @GetMapping("/getapi")
    public String checkUser(@RequestHeader(value = "Authorization")String id){
        String uid = id.split(" ")[1];
        return userService.checkUser(uid);
    }
}
