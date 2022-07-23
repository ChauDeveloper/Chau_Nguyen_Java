package com.trilogyed.gamestorecatalog.repository;

import com.trilogyed.gamestorecatalog.model.TShirt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TShirtRepository extends JpaRepository<TShirt, Long> {
    List<TShirt> findAllByColor(String color);
    List<TShirt> findAllBySize(String size);
}
