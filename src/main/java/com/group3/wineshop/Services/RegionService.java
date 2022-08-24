package com.group3.wineshop.Services;

import com.group3.wineshop.Repositories.RegionRepository;
import com.group3.wineshop.entities.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegionService {
    @Autowired
    private RegionRepository regionRepository;

    public List<Region> findAll(){
        return regionRepository.findAll();
    }

    public Optional<Region> findById(Integer id){
        return regionRepository.findById(id);
    }

    public void deleteById(Integer id) {
        regionRepository.deleteById(id);
    }

    public Region saveRegion(Region region){
        return regionRepository.save(region);
    }

    public void update(Region r){
        regionRepository.saveAndFlush(r);
    }
}
