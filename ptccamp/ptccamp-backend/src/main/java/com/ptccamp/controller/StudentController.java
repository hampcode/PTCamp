package com.ptccamp.controller;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ptccamp.domain.Attention;
import com.ptccamp.domain.Student;
import com.ptccamp.exception.ModelNotFoundException;
import com.ptccamp.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok().body(studentService.getAll());
	}

	@GetMapping("/pageable")
	public ResponseEntity<Page<Student>> getAllPageable(Pageable pageable) {
		return ResponseEntity.ok().body(studentService.getlAllStudent(pageable));
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id) {

		Optional<Student> student = studentService.getById(id);
		if (!student.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(student.get());
	}

	@PostMapping
	public ResponseEntity<?> register(@Valid @RequestBody Student student, BindingResult result) {
		if (result.hasErrors()) {
			return this.validar(result);
		}
		Student studentNew = studentService.insert(student);

		// URI location =
		// ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(studentNew.getId()).toUri();
		// return ResponseEntity.created(location).build();

		return ResponseEntity.status(HttpStatus.CREATED).body(studentNew);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Student student,BindingResult result,@PathVariable Long id) {
		if(result.hasErrors()) {
			return this.validar(result);
		}
		
		Optional<Student> studentFound=studentService.getById(id);
		
		if (!studentFound.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		Student studentUpdate=studentFound.get();
		studentUpdate.setCode(student.getCode());
		studentUpdate.setFirstName(student.getFirstName());
		studentUpdate.setLastName(student.getLastName());
		studentUpdate.setStudyMode(student.getStudyMode());
		studentUpdate.setCareer(student.getCareer());
		
		
		
		return ResponseEntity.status(HttpStatus.CREATED).body(studentService.insert(studentUpdate));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		studentService.delete(id);
		return ResponseEntity.noContent().build();
	}

	// Utilitario
	protected ResponseEntity<?> validar(BindingResult result) {
		Map<String, Object> errores = new HashMap<>();
		result.getFieldErrors().forEach(err -> {
			errores.put(err.getField(), " El campo " + err.getField() + " " + err.getDefaultMessage());
		});
		return ResponseEntity.badRequest().body(errores);
	}

}
