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

import com.ptccamp.domain.Attention;
import com.ptccamp.exception.ModelNotFoundException;
import com.ptccamp.service.AttentionService;

@RestController
@RequestMapping("/attentions")
public class AttentionController {

	@Autowired
	private AttentionService attentionService;

	@GetMapping
	public ResponseEntity<List<Attention>> getAll() {
		List<Attention> attentions = attentionService.getAll();

		return new ResponseEntity<List<Attention>>(attentions, HttpStatus.OK);
	}

	@GetMapping(value = "/pageable", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<Attention>> getAllPageable(Pageable pageable) {
		Page<Attention> attentions;
		attentions = attentionService.getlAllAttention(pageable);
		return new ResponseEntity<Page<Attention>>(attentions, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Attention> getById(@PathVariable("id") Long id) {

		Attention attention = attentionService.getById(id);
		if (attention.getId() == null) {
			throw new ModelNotFoundException("ID NO ENCONTRADO : " + id);
		}

		return new ResponseEntity<Attention>(attention, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Attention> register(@RequestBody Attention attention) {
		Attention attentionNew = attentionService.insert(attention);

		// localhost:8080/generos/2
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(attentionNew.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping
	public ResponseEntity<Object> update(@RequestBody Attention attention) {
		attentionService.update(attention);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

}
