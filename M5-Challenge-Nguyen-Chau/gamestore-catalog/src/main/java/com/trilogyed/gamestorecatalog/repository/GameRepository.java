package com.trilogyed.gamestorecatalog.repository;

import com.trilogyed.gamestorecatalog.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameRepository extends JpaRepository <Game, Long> {
    List<Game> findAllByEsrbRating(String esrbRating);
    List<Game> findAllByStudio(String studio);
    List<Game> findAllByTitle(String title);
}
