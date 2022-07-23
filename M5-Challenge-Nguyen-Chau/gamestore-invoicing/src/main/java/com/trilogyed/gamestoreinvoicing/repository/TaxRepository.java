package com.trilogyed.gamestoreinvoicing.repository;

import com.trilogyed.gamestoreinvoicing.model.Tax;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaxRepository extends JpaRepository<Tax, String> {

}
