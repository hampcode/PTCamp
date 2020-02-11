package com.ptccamp.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import com.ptccamp.domain.Career;
import com.ptccamp.exception.ModelNotFoundException;

import com.ptccamp.service.CareerService;

@RestController
@RequestMapping("/careers")
public class CareerController {


	@Autowired
	private CareerService careerService;
	
	@GetMapping
	public ResponseEntity<List<Career>> getAll() {
		List<Career> careers = careerService.getAll();

		return new ResponseEntity<List<Career>>(careers, HttpStatus.OK);
	}
	
	@GetMapping(value="/pageable", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<Career>> getAllPageable(Pageable pageable){
		Page<Career> careers;
		careers = careerService.getlAllCareer(pageable);
		return new ResponseEntity<Page<Career>>(careers, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Career> getById(@PathVariable("id") Long id) {

		Career career = careerService.getById(id);
		if (career.getId() == null) {
			throw new ModelNotFoundException("ID NO ENCONTRADO : " + id);
		}

		return new ResponseEntity<Career>(career, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Career> register(@RequestBody Career career) {
		Career careerNew = careerService.insert(career);
			
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(careerNew.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Object> update(@RequestBody Career career) {
		careerService.update(career);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public void deleteById(@PathVariable("id") Long id){
		Career career = careerService.getById(id);

		if (career.getId() == null) {
			throw new ModelNotFoundException("ID NO ENCONTRADO: " + id);
		} else {
			careerService.delete(id);
		}
	}
}
