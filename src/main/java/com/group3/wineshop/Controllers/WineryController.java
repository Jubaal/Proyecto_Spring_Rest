package com.group3.wineshop.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.group3.wineshop.Services.WineryService;
import com.group3.wineshop.entities.Winery;

@RestController
public class WineryController {
	@Autowired
	private WineryService wineryService;
	
	@GetMapping("/api/winery")
	public List<Winery> getWinery(){
		return wineryService.findAll();
	}
	
	@GetMapping("/api/winery/{id}")
	public Optional<Winery> getWineryById(@PathVariable Integer id){
		return wineryService.findById(id);
	}
	
	@PostMapping("/api/winery")
	public void postWinery(@RequestBody Winery w) {
		wineryService.save(w);
	}
	
	@DeleteMapping("/api/winery/{id}")
	public void deleteWinery(@PathVariable Integer id) {
		wineryService.delete(id);
	}
	
	@PutMapping("/api/winery")
	public void updateWinery(@RequestBody Winery w) {
		wineryService.update(w);
	}
}
