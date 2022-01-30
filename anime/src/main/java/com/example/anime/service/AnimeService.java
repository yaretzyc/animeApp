package com.example.anime.service;

import com.example.anime.exceptions.InformationExistException;
import com.example.anime.exceptions.InformationNotFoundException;
import com.example.anime.model.Anime;
import com.example.anime.model.Summary;
import com.example.anime.repository.AnimeRepository;
import com.example.anime.repository.SummaryRepository;
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

    private SummaryRepository summaryRepository;

    @Autowired
    public void setSummaryRepository(SummaryRepository summaryRepository){
        this.summaryRepository = summaryRepository;
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
    */


    public Anime updateAnime(Long animeId, Anime animeObj){
        System.out.println("Service calling updateAnime ==>");
        Optional<Anime> anime = animeRepository.findById(animeId);
        if(anime.isPresent()){
            Anime updateAnime = animeRepository.findById(animeId).get();
            updateAnime.setName(animeObj.getName());
            updateAnime.setStudio(animeObj.getStudio());
            updateAnime.setScore(animeObj.getScore());
            updateAnime.setEpisodes(animeObj.getEpisodes());
            updateAnime.setComplete(animeObj.getComplete());
            updateAnime.setSeason(animeObj.getSeason());
            return animeRepository.save(updateAnime);
        }else{
            throw new InformationNotFoundException("Anime with id " + animeId + " not found");
        }

    }
    /*

    //OPTION TO ALSO DELETE AN ANIME WITH  ID
    @DeleteMapping("/animes/{animeId}")
    public Anime deleteAnime(@PathVariable(value = "animeId")Long animeId){
        return animeService.deleteAnime(animeId);
    }
     */

    public Optional<Anime> deleteAnime(long animeId){
        Optional<Anime> anime = animeRepository.findById(animeId);
        if(anime.isPresent()){
            animeRepository.deleteById(animeId);
            return anime;
        }else{
            throw new InformationNotFoundException("Anime with id " + animeId + " not found");
        }
    }

    /////////////////////////////SUMMARY \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    //CREATE SUMMARY
//    @PostMapping("/animes/{animeId}/summary")
//    public Summary createAnimeSummary(@PathVariable (value = "animeId")Long animeId){
//        return animeService.createAnimeSummary(animeId);
//    }

    public Summary createAnimeSummary(Long animeId, Summary sumObj){
        Optional<Anime> anime = animeRepository.findById(animeId);
        if(anime.isPresent()){
            sumObj.setAnime(anime.get());
            return summaryRepository.save(sumObj);
        }else{
            throw new InformationNotFoundException("Anime with id " + animeId + " not found");
        }
    }


     /*
    //GET SUMMARY
    @GetMapping("/animes/{animeId}/summary")
    public Summary getAnimeSummary(@PathVariable(value = "animeId")Long animeId){
        return animeService.getAnimeSummary(animeId);
    }
    */
    



    /*

    //UPDATE SUMMARY
    @PutMapping("/animes/{animeId}/summary")
    public Summary updateAnimeSummary(@PathVariable(value = "animeId")Long animeId){
        return animeService.updateAnimeSummary(animeId);
    }

    //DELETE SUMMARY
    @DeleteMapping("/animes/{animeId}/summary")
    public Summary deleteAnimeSummary(@PathVariable(value = "animeId")Long animeId){
        return animeService.deleteAnimeSummary(animeId);
    }


       */

}
