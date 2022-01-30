package com.example.anime.repository;


import com.example.anime.model.Anime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimeRepository extends JpaRepository<Anime, Long> {


}
