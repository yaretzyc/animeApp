package com.example.anime.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @Column
    Integer season;

    //map to manga


    // MAP TO  summary
//    @JsonIgnore
//    @OneToOne(mappedBy = "anime")
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "summary_id", referencedColumnName = "id")
    private Summary summary;

    //one anime has many mangas
    @OneToMany(mappedBy = "anime", orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Manga> mangaList;

    //JOIN COLUMM WITH GENRE

//    @JsonIgnore
//    @ManyToMany(mappedBy = "animesgenres")
//    private Set<Genre> genres = new HashSet<>();
    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,
                    CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(name = "anime_genre",
            joinColumns = {@JoinColumn(name = "anime_id")},
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private Set<Genre> genres = new HashSet<>();



    //NO ARGS CONSTRUCTOR AND ALL ARGS CONSTRUCTOR
    public Anime() {
    }

    public Anime(Long id, String name, String studio, Integer score, Integer episodes, Boolean isComplete, Integer season) {
        this.id = id;
        this.name = name;
        this.studio = studio;
        this.score = score;
        this.episodes = episodes;
        this.isComplete = isComplete;
        this.season = season;
    }

    //GENERATE GETTERS AND SETTERS


    public Summary getSummary() {
        return summary;
    }

    public void setSummary(Summary summary) {
        this.summary = summary;
    }

    public List<Manga> getMangaList() {
        return mangaList;
    }

    public void setMangaList(List<Manga> mangaList) {
        this.mangaList = mangaList;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

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

    public Integer getSeason() {
        return season;
    }

    public void setSeason(Integer season) {
        this.season = season;
    }
}
