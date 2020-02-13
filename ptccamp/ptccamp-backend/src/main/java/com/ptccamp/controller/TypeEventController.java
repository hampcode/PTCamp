package com.ptccamp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ptccamp.domain.TypeEvent;
import com.ptccamp.exception.ModelNotFoundException;

import com.ptccamp.service.TypeEventService;

@RestController
@RequestMapping("/typeevents")
public class TypeEventController {

	@Autowired
	private TypeEventService typeService;
	
	@GetMapping
	public ResponseEntity<List<TypeEvent>> getAll() {
		List<TypeEvent> typeEvents = typeService.getAll();

		return new ResponseEntity<List<TypeEvent>>(typeEvents, HttpStatus.OK);
	}
	
	@GetMapping(value="/pageable", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<TypeEvent>> getAllPageable(Pageable pageable){
		Page<TypeEvent> typeEvents;
		typeEvents = typeService.getlAllTypeEvent(pageable);
		return new ResponseEntity<Page<TypeEvent>>(typeEvents, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<TypeEvent> getById(@PathVariable("id") Long id) {

		TypeEvent typeEvents = typeService.getById(id);
		if (typeEvents.getId() == null) {
			throw new ModelNotFoundException("ID NO ENCONTRADO : " + id);
		}

		return new ResponseEntity<TypeEvent>(typeEvents, HttpStatus.OK);
	}
}
