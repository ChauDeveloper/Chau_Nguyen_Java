package com.trilogyed.gamestorecatalog.repository;

import com.trilogyed.gamestorecatalog.model.Console;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConsoleRepository extends JpaRepository<Console, Long> {

    List<Console> findAllByManufacturer(String manufacturer);
}
