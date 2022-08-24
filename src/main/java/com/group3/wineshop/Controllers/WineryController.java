package com.group3.wineshop.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<List<Winery>> getWinery(){
		return new ResponseEntity(wineryService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/api/winery/{id}")
	public ResponseEntity<Optional<Winery>> getWineryById(@PathVariable Integer id){
		if(wineryService.findById(id).isPresent())
			return new ResponseEntity(wineryService.findById(id),new HttpHeaders(), HttpStatus.OK);
		else 
			return new ResponseEntity(wineryService.findById(id),new HttpHeaders(), HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/api/winery")
	public ResponseEntity postWinery(@RequestBody Winery w) {
		if(this.getWineryById(w.getId()).getBody().isEmpty()) {
			wineryService.save(w);
			return new ResponseEntity(HttpStatus.CREATED);
		} else {
			return new ResponseEntity(HttpStatus.ALREADY_REPORTED);
		}
	}
	
	@DeleteMapping("/api/winery/{id}")
	public ResponseEntity deleteWinery(@PathVariable Integer id) {
		wineryService.delete(id);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/api/winery")
	public ResponseEntity updateWinery(@RequestBody Winery w) {
		if(this.getWineryById(w.getId()).getBody().isPresent()) {
			wineryService.update(w);
			return new ResponseEntity(HttpStatus.OK);
		} else {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}
}
