package com.group3.wineshop.Repositories;

import com.group3.wineshop.entities.Wine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WineRepository extends JpaRepository<Wine, Integer> {
    List<Wine> findByYear(String year);
}
