package com.group3.wineshop.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group3.wineshop.Repositories.WineryRepository;
import com.group3.wineshop.entities.Winery;


@Service
public class WineryService {
	@Autowired
	private WineryRepository wineryRepository;
	
	public List<Winery> findAll(){
		return wineryRepository.findAll();
	}
	
	public Optional<Winery> findById(Integer id){
		return wineryRepository.findById(id);
	}
}
