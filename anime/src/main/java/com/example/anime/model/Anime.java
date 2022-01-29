package com.example.anime.model;

import javax.persistence.*;

@Entity
@Table(name = "animes")
public class Anime {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    String name;

    @Column
    String studio;

    @Column
    Integer score;

    @Column
    Integer episodes;

    @Column
    Boolean isComplete;

    //map to manga

    // MAP TO  summary

    //JOIN COLUMM WITH GENRE



    //NO ARGS CONSTRUCTOR AND ALL ARGS CONSTRUCTOR
    public Anime() {
    }

    public Anime(Long id, String name, String studio, Integer score, Integer episodes, Boolean isComplete) {
        this.id = id;
        this.name = name;
        this.studio = studio;
        this.score = score;
        this.episodes = episodes;
        this.isComplete = isComplete;
    }


//GENERATE GETTERS AND SETTERS


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getEpisodes() {
        return episodes;
    }

    public void setEpisodes(Integer episodes) {
        this.episodes = episodes;
    }

    public Boolean getComplete() {
        return isComplete;
    }

    public void setComplete(Boolean complete) {
        isComplete = complete;
    }
}
