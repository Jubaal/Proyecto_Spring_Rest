package com.group3.wineshop.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
}
