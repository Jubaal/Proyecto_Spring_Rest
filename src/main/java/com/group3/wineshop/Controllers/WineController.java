package com.group3.wineshop.Controllers;

import com.group3.wineshop.Repositories.WineRepository;
import com.group3.wineshop.Services.WineService;
import com.group3.wineshop.entities.Wine;
import com.group3.wineshop.entities.Winery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("api/wine/{id}")
    public void deleteWineById(@PathVariable Integer id){
        wineService.deleteById(id);
    }

    @PostMapping("api/wine")
    public void saveWine (@RequestBody Wine wine){wineService.saveWine(wine);

    }
    @PutMapping("/api/wine")
    public void updateWine(@RequestBody Wine wine) {wineService.update(wine);
    }

}
