package com.group3.wineshop.Controllers;

import com.group3.wineshop.Services.WineService;
import com.group3.wineshop.entities.Wine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class WineController {
    @Autowired
    private WineService wineService;

    @GetMapping("api/wine")
    public ResponseEntity<List<Wine>> getWine(){

        return new ResponseEntity(wineService.findAll(), HttpStatus.OK);
    }

    @GetMapping("api/wine/{id}")
    public ResponseEntity<Optional<Wine>> getWineById(@PathVariable Integer id){

        if(wineService.findById(id).isPresent())
            return new ResponseEntity(wineService.findById(id),new HttpHeaders(), HttpStatus.OK);
        else
            return new ResponseEntity(wineService.findById(id),new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("api/wine/{id}")
    public ResponseEntity deleteWineById(@PathVariable Integer id){
        if(wineService.findById(id).isPresent()) {
            wineService.deleteById(id);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("api/wine")
    public ResponseEntity<Wine> saveWine (@RequestBody Wine wine){
        if(wineService.findById(wine.getId()).isEmpty()) {
            wineService.saveWine(wine);
            return new ResponseEntity(HttpStatus.CREATED);
        } else {
            return new ResponseEntity(HttpStatus.ALREADY_REPORTED);
        }
    }

    @PutMapping("/api/wine")
    public ResponseEntity updateWine(@RequestBody Wine wine) {
        if(wineService.findById(wine.getId()).isEmpty()) {
            wineService.update(wine);
            return new ResponseEntity(HttpStatus.CREATED);
        } else {
            return new ResponseEntity(HttpStatus.ALREADY_REPORTED);
        }
    }
}
