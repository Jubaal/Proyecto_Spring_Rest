package com.group3.wineshop.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.group3.wineshop.Services.TypeService;
import com.group3.wineshop.entities.Type;

@RestController
public class TypeController {
    @Autowired
    private TypeService typeService;

    @GetMapping("/api/type")
    public List<Type> getType(){
        return typeService.findAll();
    }

    @GetMapping("/api/type/{id}")
    public Optional<Type> getTypeById(@PathVariable Integer id){
        return typeService.findById(id);
    }
}
