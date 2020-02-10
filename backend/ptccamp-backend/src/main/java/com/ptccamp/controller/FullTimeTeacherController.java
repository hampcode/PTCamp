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


import com.ptccamp.domain.FullTimeTeacher;
import com.ptccamp.exception.ModelNotFoundException;
import com.ptccamp.service.FullTimeTeacherService;

@RestController
@RequestMapping("/fulltimeteachers")
public class FullTimeTeacherController {
	
	@Autowired
	private FullTimeTeacherService fullTimeTeacherService;
	
	@GetMapping
	public ResponseEntity<List<FullTimeTeacher>> getAll() {
		List<FullTimeTeacher> fullTimeTeachers = fullTimeTeacherService.getAll();

		return new ResponseEntity<List<FullTimeTeacher>>(fullTimeTeachers, HttpStatus.OK);
	}
	
	@GetMapping(value="/pageable", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<FullTimeTeacher>> getAllPageable(Pageable pageable){
		Page<FullTimeTeacher> fullTimeTeachers;
		fullTimeTeachers = fullTimeTeacherService.getlAllFullTimeTeacher(pageable);
		return new ResponseEntity<Page<FullTimeTeacher>>(fullTimeTeachers, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<FullTimeTeacher> getById(@PathVariable("id") Long id) {

		FullTimeTeacher fullTimeTeacher = fullTimeTeacherService.getById(id);
		if (fullTimeTeacher.getId() == null) {
			throw new ModelNotFoundException("ID NO ENCONTRADO : " + id);
		}

		return new ResponseEntity<FullTimeTeacher>(fullTimeTeacher, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<FullTimeTeacher> register(@RequestBody FullTimeTeacher fullTimeTeacher) {
		FullTimeTeacher fullTimeTeacherNew = fullTimeTeacherService.insert(fullTimeTeacher);
			
		// localhost:8080/generos/2
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(fullTimeTeacherNew.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Object> update(@RequestBody FullTimeTeacher fullTimeTeacher) {
		fullTimeTeacherService.update(fullTimeTeacher);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public void deleteById(@PathVariable("id") Long id){
		FullTimeTeacher fullTimeTeacher = fullTimeTeacherService.getById(id);

		if (fullTimeTeacher.getId() == null) {
			throw new ModelNotFoundException("ID NO ENCONTRADO: " + id);
		} else {
			fullTimeTeacherService.delete(id);
		}
	}
	
	

}
