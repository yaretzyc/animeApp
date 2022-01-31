package com.example.anime.repository;

import com.example.anime.model.Summary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SummaryRepository extends JpaRepository<Summary, Long> {
//    Summary findByAnimeIdAneSummaryTitle(Long animeId, String summaryTitle);
//
//    Summary findByTitle(String summaryTitle);
//    Summary findByAnimeId(Long animeId);
//
}
