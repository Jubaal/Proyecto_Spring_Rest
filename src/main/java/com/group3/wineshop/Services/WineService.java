package com.group3.wineshop.Services;

import com.group3.wineshop.Repositories.WineRepository;
import com.group3.wineshop.entities.Wine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WineService {

    @Autowired
    WineRepository WineRepo;

    public List<Wine> findAll(){
        return WineRepo.findAll();
    }
}
