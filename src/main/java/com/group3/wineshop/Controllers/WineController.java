package com.group3.wineshop.Controllers;

import com.group3.wineshop.Services.WineService;
import com.group3.wineshop.entities.Wine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@RestController
//@RequestMapping("/api")

public class WineController {

    @Autowired
    WineService wineService;

    @GetMapping("/api/wine")
    public List<Wine> getAllWines(){
        return wineService.findAll();
    }
  /*
    @GetMapping("api/wine/{id}")
    public ResponseEntity<Wine> getWineById(@PathVariable("id") int id){
        Optional<Wine> wineData = WineRepository.findById(id);
        if(wineData.isPresent()){
            return new ResponseEntity<>(wineData.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

   */
}
