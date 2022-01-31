package com.example.anime.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "summaries")
public class Summary {


    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    String title;

    @Column
    String summary;

    @Column
    String tags;

    //map to anime ONE TO ONE
//    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "anime_id", referencedColumnName = "id")
    @JsonIgnore
    @OneToOne(mappedBy = "summary")
    private Anime anime;



    //constructors

    public Summary() {
    }

    public Summary(Long id, String title, String summary, String tags) {
        this.id = id;
        this.title = title;
        this.summary = summary;
        this.tags = tags;
    }


    //getters and setters


    public Anime getAnime() {
        return anime;
    }

    public void setAnime(Anime anime) {
        this.anime = anime;
    }

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

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
}
