package com.group3.wineshop.Controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/api/type")
    public Type saveType(@RequestBody Type type){
        return typeService.save(type);
    }
    @DeleteMapping("/api/type/{id}")
    public Map<String, Boolean> deleteTypeById(@PathVariable Integer id){ return typeService.delete(id); }
}
