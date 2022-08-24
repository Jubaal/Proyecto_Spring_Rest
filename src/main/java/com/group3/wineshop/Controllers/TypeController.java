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
    public ResponseEntity<List<Type>> getType() {
        return new ResponseEntity<List<Type>>(typeService.findAll(), HttpStatus.FOUND);
    }

    @GetMapping("/api/type/{id}")
    public ResponseEntity<Optional<Type>> getTypeById(@PathVariable Integer id) {

        //Type type = typeService.findById(id).getBody().orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
        
        return new ResponseEntity<Optional<Type>>(typeService.findById(id), HttpStatus.FOUND);

    }

    @PostMapping("/api/type")
    public ResponseEntity<Type> saveType(@RequestBody Type type){

        return new ResponseEntity<Type>(typeService.save(type), HttpStatus.CREATED);
    }
    @DeleteMapping("/api/type/{id}")
    public ResponseEntity<Optional<Type>> deleteTypeById(@PathVariable Integer id){
        return new ResponseEntity<Optional<Type>>(typeService.findById(id), HttpStatus.ACCEPTED);
    }

    @PutMapping("/api/type")
    public ResponseEntity<Type> updateType(@RequestBody Type type) {
        return new ResponseEntity<Type>(typeService.update(type), HttpStatus.OK);
    }
}
