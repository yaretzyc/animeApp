package com.example.anime.repository;


import com.example.anime.model.Anime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimeRepository extends JpaRepository<Anime, Long> {

    Anime findByName(String animeName);

}
