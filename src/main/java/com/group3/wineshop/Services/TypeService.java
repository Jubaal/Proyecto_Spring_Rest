package com.group3.wineshop.Services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.group3.wineshop.entities.Winery;
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

    public Type save(Type type) { return typeRepository.save(type); }

    public Map<String,Boolean> delete(int id){
        typeRepository.deleteById(id);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return response;
    }
}
