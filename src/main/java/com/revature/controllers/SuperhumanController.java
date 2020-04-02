package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.domains.Superhuman;
import com.revature.exceptions.SuperhumanInsertionException;
import com.revature.services.SuperhumanService;

@Controller
public class SuperhumanController {
	
	private SuperhumanService superService;
	
	@Autowired
	public void setSuperhumanService(SuperhumanService superService) {
		this.superService = superService;
	}
	
	@GetMapping("/super-human")
	@ResponseBody
	public List<Superhuman> getAllSuperhumans() {
		return superService.getAllSuperhumans();
	}
	
	@GetMapping("/super-human/{SUPER_HUMAN_NAME}")
	@ResponseBody
	public Superhuman getSuperhumanByName(@PathVariable String name) {
		return superService.getSuperhumanByName(name);
	}
	
	@PostMapping("/super-human")
	public ResponseEntity<HttpStatus> addSuperhuman(@RequestBody Superhuman superhuman) {
		try {
			superService.addSuperhuman(superhuman);
			return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
		} catch (SuperhumanInsertionException e) {
			e.printStackTrace();
			return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/super-human")
	public ResponseEntity<HttpStatus> updateSuperhuman(@RequestBody Superhuman superhuman) {
		try {
			superService.updateSuperhuman(superhuman);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		} catch (SuperhumanInsertionException e) {
			e.printStackTrace();
			return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/super-human")
	public void deleteSuperhuman(@RequestBody Superhuman superhuman) {
		superService.deleteSuperhuman(superhuman);
	}
	
}
