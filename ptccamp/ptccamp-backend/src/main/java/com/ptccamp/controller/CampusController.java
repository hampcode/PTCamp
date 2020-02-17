package com.ptccamp.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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

import com.ptccamp.domain.Campus;
import com.ptccamp.exception.ModelNotFoundException;
import com.ptccamp.service.CampusService;

@RestController
@RequestMapping("/campus")
public class CampusController {
	
	@Autowired
	private CampusService campusService;
	
	@GetMapping
	public ResponseEntity<List<Campus>> getAll() {
		List<Campus> campus = campusService.getAll();

		return new ResponseEntity<List<Campus>>(campus, HttpStatus.OK);
	}
	
	@GetMapping(value="/pageable", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<Campus>> getAllPageable(Pageable pageable){
		Page<Campus> campus;
		campus = campusService.getlAllCampus(pageable);
		return new ResponseEntity<Page<Campus>>(campus, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Campus> getById(@PathVariable("id") Long id) {

		Optional<Campus> campus = campusService.getById(id);
		if (campus.isPresent()) {
			throw new ModelNotFoundException("ID NO ENCONTRADO : " + id);
		}

		return new ResponseEntity<Campus>(campus.get(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Campus> register(@RequestBody Campus campus) {
		Campus campusNew = campusService.insert(campus);
			
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(campusNew.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Object> update(@RequestBody Campus campus) {
		campusService.update(campus);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public void deleteById(@PathVariable("id") Long id){
		Optional<Campus> campus = campusService.getById(id);

		if (campus.isPresent()) {
			throw new ModelNotFoundException("ID NO ENCONTRADO: " + id);
		} else {
			campusService.delete(id);
		}
	}
	

}
