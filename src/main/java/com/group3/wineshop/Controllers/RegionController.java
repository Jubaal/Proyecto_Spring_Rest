package com.group3.wineshop.Controllers;

import com.group3.wineshop.Services.RegionService;
import com.group3.wineshop.entities.Region;
import com.group3.wineshop.entities.Winery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("api/region/{id}")
    public void eliminarporId(@PathVariable Integer id){
        regionService.deleteById(id);
    }

    /*@PostMapping("api/region")
    public Region crearRegion(@RequestBody Region region){
        Region temp = regionService.saveRegion(region);
        return temp;
    }*/

    @PostMapping("api/region")
    public ResponseEntity<Region> crearRegion(@RequestBody Region region){
        Region tmp = regionService.saveRegion(region);
        return new ResponseEntity<Region>(tmp, HttpStatus.CREATED);
    }

    @PutMapping("/api/region")
    public void modificarRegion(@RequestBody Region r) {
        regionService.update(r);
    }
}
