package com.example.anime.service;

import com.example.anime.exceptions.InformationExistException;
import com.example.anime.exceptions.InformationNotFoundException;
import com.example.anime.model.Anime;
import com.example.anime.repository.AnimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimeService {

    private AnimeRepository animeRepository;

    @Autowired
    public void setAnimeRepository(AnimeRepository animeRepository){
        this.animeRepository = animeRepository;
    }

    /*
    @GetMapping("/animes/")
    public List<Anime> getAllAnimes(){
        return animeService.getAllAnimes();
    }
    */

    public List<Anime> getAllAnimes(){
        System.out.println("service calling getAllAnimes ==>");
        return animeRepository.findAll();
    }


    /*

    //CREATE AN ANIME
    @PostMapping("/animes/")
    public Anime createAnime(@RequestBody Anime animeObj){
        return animeService.createAnime(animeObj);
    }
    */

    public Anime createAnime(Anime animeObj){
        System.out.println("service calling createAnime ==>");

        Anime anime = animeRepository.findByName(animeObj.getName());
        if(anime != null){
            throw new InformationExistException("Anime with title " + anime.getName() + " already exists");
        }else{
            return animeRepository.save(animeObj);
        }

    }
    /*
    //GET A SPECIFIC ANIME WITH ITS ID
    @GetMapping("/animes/{animeId}")
    public Anime getAnime(@PathVariable Long animeId){
        return animeService.getAnime(animeId);
    }
    */

    public Optional<Anime> getAnime(Long animeId){

        Optional<Anime> anime = animeRepository.findById(animeId);
        if(anime.isPresent()){
            return anime;
        }else{
            throw new InformationNotFoundException("Anime with id of " + animeId +  " not found");
        }

    }

    /*

    //UPDATE AN ANIME WITH ITS ID GIVEN
    @PutMapping("/animes/{animeId}")
    public Anime updateAnime(@PathVariable(value = "animeId")Long animeId,
                             @RequestBody Anime animeObj){
        return animeService.updateAnime(animeId, animeObj);
    }

    //OPTION TO ALSO DELETE AN ANIME WITH  ID
    @DeleteMapping("/animes/{animeId}")
    public Anime deleteAnime(@PathVariable(value = "animeId")Long animeId){
        return animeService.deleteAnime(animeId);
    }
     */

}
