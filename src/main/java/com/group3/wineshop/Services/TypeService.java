package com.group3.wineshop.Services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.group3.wineshop.entities.Winery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.group3.wineshop.Repositories.TypeRepository;
import com.group3.wineshop.entities.Type;


@Service
public class TypeService {
    @Autowired
    private TypeRepository typeRepository;

    public List<Type> findAll(){
        return typeRepository.findAll();
    }

    public Optional<Type> findById(Integer id){
        return typeRepository.findById(id);
    }



    public Type save(Type type) {
        return typeRepository.save(type);
    }

    public void delete(int id){
        typeRepository.deleteById(id);
    }

    public Type update(Type type) {
        return typeRepository.saveAndFlush(type);
    }


}
