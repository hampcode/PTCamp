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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ptccamp.domain.Attention;
import com.ptccamp.service.AttentionService;

@RestController
@RequestMapping("/attentions")
public class AttentionController {

	@Autowired
	private AttentionService attentionService;

	@GetMapping
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok().body(attentionService.getAll());
	}

	@GetMapping(value = "/pageable")
	public ResponseEntity<?> getAllPageable(Pageable pageable) {
		/*Page<Attention> attentions;
		attentions = attentionService.getlAllAttention(pageable);
		return new ResponseEntity<Page<Attention>>(attentions, HttpStatus.OK);*/
		return ResponseEntity.ok().body(attentionService.getlAllAttention(pageable));
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getById(@PathVariable("id") Long id) {

		Optional<Attention> attention = attentionService.getById(id);
		if (!attention.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(attention.get());
	}

	@PostMapping
	public ResponseEntity<?> register(@Valid @RequestBody Attention attention, BindingResult result) {
		
		if(result.hasErrors()) {
			return this.validar(result);
		}
		Attention attentionNew = attentionService.insert(attention);

		
		//URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
		//		.buildAndExpand(attentionNew.getId()).toUri();
		//return ResponseEntity.created(location).build();*/
		return ResponseEntity.status(HttpStatus.CREATED).body(attentionNew);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Attention attention,BindingResult result,@PathVariable Long id) {
		//attentionService.update(attention);
		//return new ResponseEntity<Object>(HttpStatus.OK);

		if(result.hasErrors()) {
			return this.validar(result);
		}
		
		Optional<Attention> attentionFound=attentionService.getById(id);
		
		if (attentionFound.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		Attention attentionUpdate=attentionFound.get();
		attentionUpdate.setFullTimeTeacher(attention.getFullTimeTeacher());
		attentionUpdate.setStudent(attention.getStudent());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(attentionService.insert(attentionUpdate));
	}

	
	//Utilitario
	protected ResponseEntity<?> validar(BindingResult result){
		Map<String, Object> errores = new HashMap<>();
		result.getFieldErrors().forEach(err -> {
			errores.put(err.getField(), " El campo " + err.getField() + " " + err.getDefaultMessage());
		});
		return ResponseEntity.badRequest().body(errores);
	}
}
