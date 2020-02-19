package com.ptccamp.controller;

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

import com.ptccamp.domain.Event;
import com.ptccamp.domain.Student;
import com.ptccamp.dto.EventAuthoritiesDTO;
import com.ptccamp.exception.ModelNotFoundException;
import com.ptccamp.service.EventService;

@RestController
@RequestMapping("/events")
public class EventController {

	@Autowired
	private EventService eventService;

	@GetMapping
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok().body(eventService.getAll());
	}
	
	@GetMapping("/pageable")
	public ResponseEntity<Page<Event>> getAllPageable(Pageable pageable){
		return ResponseEntity.ok().body(eventService.getlAllEvent(pageable));
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable("id") Long id) {

		Optional<Event> event = eventService.getById(id);
		if (!event.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(event.get());
	}

	@PostMapping
	public ResponseEntity<Long> register(@RequestBody EventAuthoritiesDTO eventDTO) {

		Long rpta = eventService.registerTransactional(eventDTO);

		return new ResponseEntity<Long>(rpta, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Object> update(@RequestBody Event event) {
		eventService.update(event);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?>  deleteById(@PathVariable Long id) {
		Optional<Event> event = eventService.getById(id);

		if (!event.isPresent()) {
			return ResponseEntity.notFound().build();
		} else {
			eventService.delete(id);
			return ResponseEntity.noContent().build();
		}
	}

}
