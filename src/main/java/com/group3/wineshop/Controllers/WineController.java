package com.group3.wineshop.Controllers;

import com.group3.wineshop.Services.WineService;
import com.group3.wineshop.entities.Wine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class WineController {
    @Autowired
    private WineService wineService;

    @GetMapping("api/wine")
    public List<Wine> getWine(){
        return wineService.findAll();
    }

    @GetMapping("api/wine/{id}")
    public Optional<Wine> getWineById(@PathVariable Integer id){
        return wineService.findById(id);
    }
}
