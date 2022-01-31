package com.example.anime.model;

import com.sun.jdi.NativeMethodException;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "genres")
public class Genre {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    String genre;

    //JOIN COLUMN WITH ANIME

//    @ManyToMany
//    @JoinTable(
//            name = "anime_genre",
//            joinColumns = @JoinColumn(name = "genre_id"),
//            inverseJoinColumns = @JoinColumn(name = "anime_id")
//    )
//    private Set<Anime> animesgenres = new HashSet<>();
@ManyToMany(fetch = FetchType.LAZY,
        cascade = {CascadeType.DETACH,
                CascadeType.MERGE, CascadeType.REFRESH})
@JoinTable(
        name = "anime_genre",
        joinColumns = @JoinColumn(name = "genre_id"),
        inverseJoinColumns = @JoinColumn(name = "anime_id")
)
private Set<Anime> animesgenres = new HashSet<>();



//    //CONSTRUCTORS

    public Genre() {
    }

    public Genre(Long id, String genre) {
        this.id = id;
        this.genre = genre;
    }

    //GETTERS AND SETTERS



    public Set<Anime> getAnimesgenres() {
        return animesgenres;
    }

    public void setAnimesgenres(Set<Anime> animesgenres) {
        this.animesgenres = animesgenres;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

//    public void assignAnime(Anime anime) {
//        animesgenres.add(anime);
//    }
}
