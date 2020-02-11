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
import com.ptccamp.domain.Faculty;
import com.ptccamp.exception.ModelNotFoundException;

import com.ptccamp.service.FacultyService;

@RestController
@RequestMapping("/faculties")
public class FacultyController {
	
	@Autowired
	private FacultyService facultyService;
	
	@GetMapping
	public ResponseEntity<List<Faculty>> getAll() {
		List<Faculty> faculties = facultyService.getAll();

		return new ResponseEntity<List<Faculty>>(faculties, HttpStatus.OK);
	}
	
	@GetMapping(value="/pageable", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<Faculty>> getAllPageable(Pageable pageable){
		Page<Faculty> faculties;
		faculties = facultyService.getlAllFaculties(pageable);
		return new ResponseEntity<Page<Faculty>>(faculties, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Faculty> getById(@PathVariable("id") Long id) {

		Faculty faculty = facultyService.getById(id);
		if (faculty.getId() == null) {
			throw new ModelNotFoundException("ID NO ENCONTRADO : " + id);
		}

		return new ResponseEntity<Faculty>(faculty, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Career> register(@RequestBody Faculty faculty) {
		Faculty facultyNew = facultyService.insert(faculty);
			
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(facultyNew.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Object> update(@RequestBody Faculty faculty) {
		facultyService.update(faculty);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public void deleteById(@PathVariable("id") Long id){
		Faculty faculty = facultyService.getById(id);

		if (faculty.getId() == null) {
			throw new ModelNotFoundException("ID NO ENCONTRADO: " + id);
		} else {
			facultyService.delete(id);
		}
	}
	

}
