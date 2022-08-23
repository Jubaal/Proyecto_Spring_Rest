package com.group3.wineshop.Repositories;

import com.group3.wineshop.entities.Wine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WineRepository extends JpaRepository<Wine, Integer> {
}
