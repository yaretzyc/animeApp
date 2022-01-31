package com.example.anime.service;

import com.example.anime.exceptions.InformationExistException;
import com.example.anime.exceptions.InformationNotFoundException;
import com.example.anime.model.Anime;
import com.example.anime.model.Genre;
import com.example.anime.model.Manga;
import com.example.anime.model.Summary;
import com.example.anime.repository.AnimeRepository;
import com.example.anime.repository.GenreRepository;
import com.example.anime.repository.MangaRepository;
import com.example.anime.repository.SummaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

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

    private MangaRepository mangaRepository;

    @Autowired
    public void setMangaRepository(MangaRepository mangaRepository){
        this.mangaRepository = mangaRepository;
    }

    private GenreRepository genreRepository;

    @Autowired
    public void setGenreRepository(GenreRepository genreRepository){
        this.genreRepository = genreRepository;
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

//    public Summary createAnimeSummary(Long animeId, Summary sumObj){
//        System.out.println("Service calling createAnimeSummary ==> ");
//        Optional<Anime> anime = animeRepository.findById(animeId);
//        if(anime.isPresent()){
//            sumObj.setAnime(anime.get());
//            return summaryRepository.save(sumObj);
//        }else{
//            throw new InformationNotFoundException("Anime with id " + animeId + " not found");
//        }
//    }


////NEED TO ADD INOFMATION NOT FOUND IN CASE SUMMARY DOESN'T EXIST
//    public Summary getAnimeSummary(Long animeId){
//        Optional<Anime> anime = animeRepository.findById(animeId);
//        if(anime != null){
//            return anime.get().getSummary();
//        }else{
//            throw new InformationNotFoundException("Anime with id " + animeId + " not found");
//        }
//
////        Summary summary = summaryRepository.findByAnimeId(animeId);
////        if (summary == null) {
////            throw new InformationNotFoundException("anime with id " + null +
////                    " does not have an existing summary");
//        }


////        Optional<Summary> summary = summaryRepository.findByAnimeId(animeId).getAnime().getSummary();
//        Summary summary = summaryRepository.findByAnimeId();
//
//        if(summary == false){
//            return null;
//        }else{
////        if(anime.get().getSummary() != null){
//            throw new InformationExistException("Anime with id " + animeId + " does not have a summary");
//        }



    //UPDATE SUMMARY
//    public Summary updateAnimeSummary(Long animeId, Summary summaryObj){
//        Optional<Anime> anime = animeRepository.findById(animeId);
//        if (anime == null ){
//            throw new InformationNotFoundException("anime with id " + animeId + " was not found");
//        }

//        Summary oldSummary = summaryRepository.findByAnimeIdAneSummaryTitle(animeId, summaryObj.getTitle());
//        if(oldSummary != null){
//            throw new InformationExistException("summary with title " + oldSummary.getTitle() + " already exists");
//        }

//        return  summaryRepository.findById(animeId).map(sum -> {
//            sum.setTitle(summaryObj.getTitle());
//            sum.setSummary(summaryObj.getSummary());
//            sum.setTags(summaryObj.getTags());
//            return summaryRepository.save(sum);
//                }).orElseThrow(() -> new InformationNotFoundException("summary not found"));
//
////        Optional<Summary> summary = summaryRepository.findByAnimeId(animeId);
//        */

//    }

//    public Summary createAnimeSummary(Long animeId, Summary sumObj){
//        System.out.println("Service calling createAnimeSummary ==> ");
//        Optional<Anime> anime = animeRepository.findById(animeId);
//        if(anime.isPresent()){
//            sumObj.setAnime(anime.get());
//            return summaryRepository.save(sumObj);
//        }else{
//            throw new InformationNotFoundException("Anime with id " + animeId + " not found");
//        }
//    }
       /*
    //DELETE SUMMARY
    @DeleteMapping("/animes/{animeId}/summary")
    public Summary deleteAnimeSummary(@PathVariable(value = "animeId")Long animeId){
        return animeService.deleteAnimeSummary(animeId);
    }


       */

    /////////////////////MANGAS''''''''''''''''

    public Manga createAnimeManga(Long animeId, Manga mangaObj){

        System.out.println("service calling createAnimeManga ==>");
        Optional<Anime> anime = animeRepository.findById(animeId);
        if(anime == null){
            throw new InformationNotFoundException("anime with id " + animeId + "not found");
        }
        mangaObj.setAnime(anime.get());
        return mangaRepository.save(mangaObj);

    }

    //GET MANGA FROM ANIME
    public Manga getAnimeManga(Long animeId, Long mangaId){
        Optional<Anime> anime = animeRepository.findById(animeId);
        if(anime.isPresent()){
            for(Manga manga: anime.get().getMangaList()){
                if(manga.getId() == mangaId){
                    return manga;
                }
            }
            throw new InformationNotFoundException("Manga with id " +  mangaId + " not found");
        }else{
            throw new InformationNotFoundException("anime with id " + animeId + " not found");
        }

    }

    public List<Manga> getAllAnimeManga(Long animeId){
        System.out.println("service calling getAllAnimeManga ==>");
        Optional<Anime> anime = animeRepository.findById(animeId);
        if(anime.isPresent()){
            return anime.get().getMangaList();
                }
            throw new InformationNotFoundException("anime with id " + animeId + " not found");
    }


    //UPDATE A MANGA
    public Manga updateAnimeManga(Long animeId, Long mangaId, Manga mangaObj){

        Optional<Anime> anime = animeRepository.findById(animeId);
        if (anime.isPresent()) {
            for (Manga manga : anime.get().getMangaList()) {
                if (manga.getId() == mangaId) {
                    Manga updateManga = mangaRepository.findById(mangaId).get();
                    updateManga.setTitle(mangaObj.getTitle());
                    updateManga.setAuthor(mangaObj.getAuthor());
                    updateManga.setVolumeNum(mangaObj.getVolumeNum());

                    return mangaRepository.save(updateManga);
                }
                throw new InformationNotFoundException("manga with id " + mangaId + " not found");
            }
        }
        throw new InformationNotFoundException("anime with id "+ animeId + " not found");
    }


    public Optional<Manga> deleteAnimeManga(Long animeId, Long mangaId){
        Optional<Anime> anime = animeRepository.findById(animeId);
        if(anime.isPresent()){
            for (Manga manga : anime.get().getMangaList()) {
                if (manga.getId() == mangaId) {
                    Manga mangaFind = mangaRepository.findById(mangaId).get();
                    mangaRepository.deleteById(mangaId);
                    return Optional.of(mangaFind);
                }
                throw new InformationNotFoundException("manga with id " + mangaId + " not found");
            }

        }
        throw new InformationNotFoundException("anime with id "+ animeId + " not found");

    }


    /////////////////////////GENRES \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
//    public Genre createAnimeGenre(Long animeId, Genre genreObj){
//
//        System.out.println("service calling createAnimeGenre ==>");
//        Optional<Anime> anime = animeRepository.findById(animeId);
//        if(anime == null){
//            throw new InformationNotFoundException("anime with id " + animeId + "not found");
//        }
////        mangaObj.setAnime(anime.get());
//        genreObj.setAnimesgenres(anime.get());
//        return genreRepository.save(genreObj);
//
//    }
//    REFERENCE: https://www.youtube.com/watch?v=f5bdUjEIbrg&t=478s&ab_channel=KrisFoster
    public Genre createGenre(Genre genreObj){
        return genreRepository.save(genreObj);
    }

    //putmapping
    public Genre putAnimeGenre(Long genreId, Long animeId){
        Anime anime = animeRepository.findById(animeId).get();
        Genre genre = genreRepository.findById(genreId).get();
        genre.assignAnime(anime);
        return genreRepository.save(genre);

        //handle if the ids dont exist /not found
    }
}










