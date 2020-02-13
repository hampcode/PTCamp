package com.ptccamp.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ptccamp.domain.Student;
import com.ptccamp.exception.ModelNotFoundException;
import com.ptccamp.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping
	public ResponseEntity<List<Student>> getAll() {
		List<Student> students = studentService.getAll();

		return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
	}
	
	@GetMapping(value="/pageable", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<Student>> getAllPageable(Pageable pageable){
		Page<Student> students;
		students = studentService.getlAllStudent(pageable);
		return new ResponseEntity<Page<Student>>(students, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Student> getById(@PathVariable("id") Long id) {

		Student student = studentService.getById(id);
		if (student.getId() == null) {
			throw new ModelNotFoundException("ID NO ENCONTRADO : " + id);
		}

		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Student> register(@RequestBody Student student) {
		Student studentNew = studentService.insert(student);
			
		// localhost:8080/generos/2
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(studentNew.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Object> update(@RequestBody Student student) {
		studentService.update(student);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
}
