package com.group3.wineshop.Controllers;

import java.net.http.HttpClient;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.group3.wineshop.Services.TypeService;
import com.group3.wineshop.entities.Type;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.HttpStatusCodeException;


@RestController
public class TypeController {
    @Autowired
    private TypeService typeService;

    @GetMapping("/api/type")
    public List<Type> getType(){
        return typeService.findAll();
    }

    @GetMapping("/api/type/{id}")
    public ResponseEntity<Optional<Type>> getTypeById(@PathVariable Integer id) {

        Type type = typeService.findById(id).getBody().orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
        
        return typeService.findById(id);
    }



    @PostMapping("/api/type")
    public Type saveType(@RequestBody Type type){
        return typeService.save(type);
    }
    @DeleteMapping("/api/type/{id}")
    public Map<String, Boolean> deleteTypeById(@PathVariable Integer id){ return typeService.delete(id); }

    @PutMapping("/api/type")
    public Type updateType(@RequestBody Type type) {
        return typeService.update(type);
    }
}
