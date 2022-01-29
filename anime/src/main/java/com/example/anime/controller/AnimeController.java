package com.example.anime.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class AnimeController {

    @GetMapping(path = "/hello-world/")
    public String getHelloWorld(){
        return "hello world";
    }

    //CRUD
    //Create an anime

//    @PutMapping("/anime/{animeId}/genres/{genreId}")




}
