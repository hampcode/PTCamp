package com.ptccamp.controller;

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

import com.ptccamp.domain.Event;
import com.ptccamp.dto.EventDTO;
import com.ptccamp.exception.ModelNotFoundException;
import com.ptccamp.service.EventService;

@RestController
@RequestMapping("/events")
public class EventController {

	@Autowired
	private EventService eventService;

	@GetMapping
	public ResponseEntity<List<Event>> getAll() {
		List<Event> events = eventService.getAll();

		return new ResponseEntity<List<Event>>(events, HttpStatus.OK);
	}
	
	@GetMapping(value="/pageable", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<Event>> getAllPageable(Pageable pageable){
		Page<Event> events;
		events = eventService.getlAllEvent(pageable);
		return new ResponseEntity<Page<Event>>(events, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Event> getById(@PathVariable("id") Long id) {

		Event event = eventService.getById(id);
		if (event.getId() == null) {
			throw new ModelNotFoundException("ID NO ENCONTRADO : " + id);
		}

		return new ResponseEntity<Event>(event, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Long> register(@RequestBody EventDTO eventDTO) {

		Long rpta = eventService.registerTransactional(eventDTO);

		return new ResponseEntity<Long>(rpta, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Object> update(@RequestBody Event event) {
		eventService.update(event);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public void deleteById(@PathVariable("id") Long id) {
		Event event = eventService.getById(id);

		if (event.getId() == null) {
			throw new ModelNotFoundException("ID NO ENCONTRADO: " + id);
		} else {
			eventService.delete(id);
		}
	}

}
