package com.ptccamp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import com.ptccamp.domain.Campus;

import com.ptccamp.repository.CampusRepository;
import com.ptccamp.service.CampusService;

@Service
public class CampusServiceImpl implements CampusService {

	@Autowired
	private CampusRepository campusRepository;

	@Override
	public Campus insert(Campus obj) {
		return campusRepository.save(obj);
	}

	@Override
	public Campus update(Campus obj) {
		return campusRepository.save(obj);
	}

	@Override
	public List<Campus> getAll() {
		return campusRepository.findAll();
	}

	@Override
	public Campus getById(Long id) {
		Optional<Campus> op = campusRepository.findById(id);
		return op.isPresent() ? op.get() : new Campus();
	}

	@Override
	public void delete(Long id) {
		campusRepository.deleteById(id);

	}

	@Override
	public Page<Campus> getlAllCampus(Pageable pageable) {
		return campusRepository.findAll(pageable);
	}

}
