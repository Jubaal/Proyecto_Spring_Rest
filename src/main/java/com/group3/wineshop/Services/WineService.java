package com.group3.wineshop.Services;

import com.group3.wineshop.Repositories.WineRepository;
import com.group3.wineshop.Repositories.WineryRepository;
import com.group3.wineshop.entities.Wine;
import com.group3.wineshop.entities.Winery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WineService {
    @Autowired
    private WineRepository wineRepository;

    public List<Wine> findAll(){
        return wineRepository.findAll();
    }

    public Optional<Wine> findById(Integer id){
        return wineRepository.findById(id);
    }
}
