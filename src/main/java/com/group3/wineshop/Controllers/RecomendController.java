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

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
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

    @GetMapping("/api/recommend/vintage")
    public ResponseEntity<List<Wine>> getVintage(@RequestParam(name = "top", required = false, defaultValue = "10") Integer topRated){
        Comparator<Wine> comparador = Comparator.comparing(Wine::getRating);
        List<Wine> listFinal = new ArrayList<>();
        HashMap<String, Wine> yearWine = new HashMap<>(wineService.findAll().stream()
                .reduce(new HashMap(),(h,w) -> {
                    Wine tmp = (Wine) h.get(w.getYear());
                    if(tmp==null)h.put(w.getYear(),w);
                    else {if (w.getRating()>=tmp.getRating()) h.put(w.getYear(),w);}
                    return h;
                },(h1,h2)-> h1));
        
        List<String> list = new ArrayList<>(yearWine.values()).stream()
                .sorted(comparador.reversed())
                .limit(topRated)
                .map(v-> v.getYear())
                .toList();

        for(String year : list){
            listFinal.addAll(wineService.findByYear(year).stream()
                    .sorted(comparador.reversed())
                    .limit(10)
                    .toList());
        }

        return new ResponseEntity(listFinal,new HttpHeaders(), HttpStatus.OK);
    }

}
