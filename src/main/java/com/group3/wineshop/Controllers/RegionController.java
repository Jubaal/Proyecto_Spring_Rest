package com.group3.wineshop.Controllers;

import com.group3.wineshop.Services.RegionService;
import com.group3.wineshop.entities.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class RegionController {
    @Autowired
    private RegionService regionService;

    @GetMapping("api/region")
    public List<Region> mostrarTodos() {
        return regionService.findAll();
    }

    @GetMapping("api/region/{id}")
    public Optional<Region> mostrarRegionId(@PathVariable Integer id){
        return regionService.findById(id);
    }
}
