package com.group3.wineshop.Controllers;

import com.group3.wineshop.Services.RegionService;
import com.group3.wineshop.entities.Region;
import com.group3.wineshop.entities.Winery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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
    public ResponseEntity<List<Region>> mostrarTodos() {
        return new ResponseEntity(regionService.findAll(), HttpStatus.OK);
    }

    @GetMapping("api/region/{id}")
    public ResponseEntity<Optional<Region>> mostrarRegionId(@PathVariable Integer id){
        if(regionService.findById(id).isPresent())
            return new ResponseEntity(regionService.findById(id),new HttpHeaders(),HttpStatus.OK);
        else
            return new ResponseEntity(regionService.findById(id),new HttpHeaders(),HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("api/region/{id}")
    public ResponseEntity eliminarporId(@PathVariable Integer id){
        if(regionService.findById(id).isPresent()) {
            regionService.deleteById(id);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("api/region")
    public ResponseEntity<Region> crearRegion(@RequestBody Region region){
        if(regionService.findById(region.getId()).isEmpty()){
            regionService.saveRegion(region);
            return new ResponseEntity(HttpStatus.CREATED);
        }else{
            return new ResponseEntity(HttpStatus.ALREADY_REPORTED);
        }
    }

    @PutMapping("/api/region")
    public ResponseEntity modificarRegion(@RequestBody Region region) {
        if(regionService.findById(region.getId()).isPresent()) {
            regionService.update(region);
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
