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

import com.ptccamp.domain.StudyMode;
import com.ptccamp.exception.ModelNotFoundException;
import com.ptccamp.service.StudyModeService;

@RestController
@RequestMapping("/studiesmodality")
public class StudyModeController {
	
	@Autowired
	private StudyModeService studyModeService;
	
	@GetMapping
	public ResponseEntity<List<StudyMode>> getAll() {
		List<StudyMode> studiesModality = studyModeService.getAll();

		return new ResponseEntity<List<StudyMode>>(studiesModality, HttpStatus.OK);
	}
	
	@GetMapping(value="/pageable", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<StudyMode>> getAllPageable(Pageable pageable){
		Page<StudyMode> studiesModality;
		studiesModality = studyModeService.getlAllStudyMode(pageable);
		return new ResponseEntity<Page<StudyMode>>(studiesModality, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<StudyMode> getById(@PathVariable("id") Long id) {

		Optional<StudyMode> studyMode = studyModeService.getById(id);
		if (studyMode.isPresent()) {
			throw new ModelNotFoundException("ID NO ENCONTRADO : " + id);
		}

		return new ResponseEntity<StudyMode>(studyMode.get(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<StudyMode> register(@RequestBody StudyMode studyMode) {
		StudyMode studyModeNew = studyModeService.insert(studyMode);
			
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(studyModeNew.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Object> update(@RequestBody StudyMode studyMode) {
		studyModeService.update(studyMode);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public void deleteById(@PathVariable("id") Long id){
		Optional<StudyMode> studyMode = studyModeService.getById(id);

		if (studyMode.isPresent()) {
			throw new ModelNotFoundException("ID NO ENCONTRADO: " + id);
		} else {
			studyModeService.delete(id);
		}
	}
	

}
