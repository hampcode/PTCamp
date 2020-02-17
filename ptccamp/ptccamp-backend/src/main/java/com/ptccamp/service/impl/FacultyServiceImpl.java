package com.ptccamp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ptccamp.domain.Faculty;
import com.ptccamp.repository.FacultyRepository;
import com.ptccamp.service.FacultyService;

@Service
public class FacultyServiceImpl implements FacultyService {

	@Autowired
	private FacultyRepository facultyRepository;

	@Override
	public Faculty insert(Faculty obj) {
		return facultyRepository.save(obj);
	}

	@Override
	public Faculty update(Faculty obj) {
		return facultyRepository.save(obj);
	}

	@Override
	public List<Faculty> getAll() {
		return facultyRepository.findAll();
	}

	@Override
	public Optional<Faculty> getById(Long id) {
		//Optional<Faculty> op = facultyRepository.findById(id);
		//return op.isPresent() ? op.get() : new Faculty();
		return facultyRepository.findById(id);
	}

	@Override
	public void delete(Long id) {
		facultyRepository.deleteById(id);

	}

	@Override
	public Page<Faculty> getlAllFaculties(Pageable pageable) {
		return facultyRepository.findAll(pageable);
	}

}
