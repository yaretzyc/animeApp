package com.example.anime.controller;

import com.example.anime.model.Anime;
import com.example.anime.model.Manga;
import com.example.anime.model.Summary;
import com.example.anime.service.AnimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api")
public class AnimeController {

    //////////////////dependecy injections\\\\\\\\\\\\\\\\\\\
    @Autowired
    public AnimeService animeService;


    @GetMapping(path = "/hello-world/")
    public String getHelloWorld(){
        return "hello world";
    }

    /////////////////////////CRUD ANIME \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    //GET THE LIST OF ALL ANIMES
    @GetMapping("/animes/")
    public List<Anime> getAllAnimes(){
        return animeService.getAllAnimes();
    }

    //CREATE AN ANIME
    @PostMapping("/animes/")
    public Anime createAnime(@RequestBody Anime animeObj){
        return animeService.createAnime(animeObj);
    }



    //GET A SPECIFIC ANIME WITH ITS ID
    @GetMapping("/animes/{animeId}")
    public Optional<Anime> getAnime(@PathVariable Long animeId){
        return animeService.getAnime(animeId);
    }


    //UPDATE AN ANIME WITH ITS ID GIVEN
    @PutMapping("/animes/{animeId}")
    public Anime updateAnime(@PathVariable(value = "animeId")Long animeId,
                             @RequestBody Anime animeObj){
        return animeService.updateAnime(animeId, animeObj);
    }


    //OPTION TO ALSO DELETE AN ANIME WITH  ID
    @DeleteMapping("/animes/{animeId}")
    public Optional<Anime> deleteAnime(@PathVariable(value = "animeId")Long animeId){
        return animeService.deleteAnime(animeId);
    }

///////////////////////////////SUMMARY\\\\\\\\\\\\\\\\\\\
/*
    //CREATE SUMMARY
    @PostMapping("/animes/{animeId}/summary")
    public Summary createAnimeSummary(@PathVariable (value = "animeId")Long animeId,
                                      @RequestBody Summary sumObj){
        return animeService.createAnimeSummary(animeId, sumObj);
    }


    //GET SUMMARY
    @GetMapping("/animes/{animeId}/summary/")
    public Summary getAnimeSummary(@PathVariable(value = "animeId")Long animeId){
        return animeService.getAnimeSummary(animeId);
    }


    //UPDATE SUMMARY
    @PutMapping("/animes/{animeId}/summary/")
    public Summary updateAnimeSummary(@PathVariable(value = "animeId")Long animeId,
                                      @RequestBody Summary summaryObj){
        return animeService.updateAnimeSummary(animeId, summaryObj);
    }


    //DELETE SUMMARY
    @DeleteMapping("/animes/{animeId}/summary")
    public Summary deleteAnimeSummary(@PathVariable(value = "animeId")Long animeId){
        return animeService.deleteAnimeSummary(animeId);
    }
 */
    //////////////MANGAS\\\\\\\\\\\\\\\\\\\\\ONE TO MANY
    //CREATE A MANGA
    @PostMapping("/animes/{animeId}/mangas/")
    public Manga createAnimeManga(@PathVariable(value = "animeId")Long animeId,
                                  @RequestBody Manga mangaObj){
        return animeService.createAnimeManga(animeId, mangaObj);
    }
 /*

    ///GET A MANGA FOR A ANIME
    @GetMapping("/animes/{animeId}/mangas/{mangaId}")
    public Manga getAnimeManga(@PathVariable(value = "animeId")Long animeId,
                                  @PathVariable(value = "mangaId")Long mangaId){
        return animeService.getAnimeManga(animeId, mangaId);
    }
    //GET ALL MANGAS FOR AN ANIME
    @GetMapping("/animes/{animeId}/mangas")
    public List<Manga> getAllAnimeManga(@PathVariable(value = "animeId")Long animeId){
        return animeService.getAllAnimeManga(animeId);
    }

    ///UPDATE A MANGA
    @PutMapping("/animes/{animeId}/mangas/{mangaId}")
    public Manga updateAnimeManga(@PathVariable(value = "animeId")Long animeId,
                                  @PathVariable(value = "mangaId")Long mangaId,
                                  @RequestBody Manga mangaObj){
        return animeService.updateAnimeManga(animeId, mangaId, mangaObj);
    }

    ///DELETE A MANGA
    @DeleteMapping("/animes/{animeId}/mangas/{mangaId}")
    public Manga deleteAnimeManga(@PathVariable (value = "animeId")Long animeId,
                                  @PathVariable(value = "mangaId")Long mangaId){
        return animeService.deleteAnimeManga(animeId, mangaId);
    }



    //////////////////GENRE\\\\\\\\\\\\\\\\\\ MANY TO MANY RELATIONSHIP
    @PutMapping("/anime/{animeId}/genres/{genreId}")




     */

}
