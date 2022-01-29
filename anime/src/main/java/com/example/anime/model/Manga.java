package com.example.anime.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "mangas")
public class Manga {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    String title;

    @Column
    String author;

    @Column
    Integer volumeNum;

    //CONNECT TO THE ANIME_ID
//
    @JsonIgnore//IN THE JSON WILL NOT SHOW CATEGORY ID AS A COLUMN
    @ManyToOne
    @JoinColumn(name = "anime_id") //fk for the recipes table creating a new column
    private Anime anime;



    //CONSTRUCTORS

    public Manga() {
    }

    public Manga(Long id, String title, String author, Integer volumeNum) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.volumeNum = volumeNum;
    }

    //GETTERS AND SETTERS


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getVolumeNum() {
        return volumeNum;
    }

    public void setVolumeNum(Integer volumeNum) {
        this.volumeNum = volumeNum;
    }
}
