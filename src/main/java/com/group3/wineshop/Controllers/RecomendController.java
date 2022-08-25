package com.group3.wineshop.Controllers;


import com.group3.wineshop.Services.WineService;
import com.group3.wineshop.entities.Wine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;

@RestController
public class RecomendController {

    @Autowired
    private WineService wineService;

    @GetMapping("api/recommend/expensive")
    public ResponseEntity<List<Wine>> getExpensive(@RequestParam(name = "top", required = false, defaultValue = "10") Integer top) {
        Comparator<Wine> comparador = Comparator.comparing(Wine::getPrice);
        return new ResponseEntity(wineService.findAll().stream()
                .sorted(comparador.reversed())
                .limit(top)
                .toList()
                ,new HttpHeaders(), HttpStatus.OK);
    }
    @GetMapping("/api/recommend/best")
    public ResponseEntity<List<Wine>> getBestRated(@RequestParam(name = "top", required = false, defaultValue = "10") Integer topRated){

        Comparator<Wine> comparador= Comparator.comparing(Wine::getRating);
        return new ResponseEntity(wineService.findAll().stream()
                .sorted(comparador.reversed())
                .limit(topRated)
                .toList(),new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/api/recommend/bang")
    public ResponseEntity<List<Wine>> getbestBang(@RequestParam(name = "top", required = false, defaultValue = "10") Integer topRated){

        Comparator<Wine> comparadorCalidad= Comparator.comparing(Wine::getRating);
        Comparator<Wine> comparadorPrecio= Comparator.comparing(Wine::getPrice);
        return new ResponseEntity(wineService.findAll().stream()
                .sorted(comparadorCalidad.thenComparing(comparadorPrecio))
                .limit(topRated)
                .toList(),new HttpHeaders(), HttpStatus.OK);
    }
}
