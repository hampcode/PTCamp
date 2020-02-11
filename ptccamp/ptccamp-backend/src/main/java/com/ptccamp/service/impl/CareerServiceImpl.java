package com.ptccamp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ptccamp.domain.Career;
import com.ptccamp.repository.CareerRepository;
import com.ptccamp.service.CareerService;

@Service
public class CareerServiceImpl implements CareerService {

	@Autowired
	private CareerRepository careerRepository;

	@Override
	public Career insert(Career obj) {
		return careerRepository.save(obj);
	}

	@Override
	public Career update(Career obj) {
		return careerRepository.save(obj);
	}

	@Override
	public List<Career> getAll() {
		return careerRepository.findAll();
	}

	@Override
	public Career getById(Long id) {
		Optional<Career> op = careerRepository.findById(id);
		return op.isPresent() ? op.get() : new Career();
	}

	@Override
	public void delete(Long id) {
		careerRepository.deleteById(id);

	}

	@Override
	public Page<Career> getlAllCareer(Pageable pageable) {
		return careerRepository.findAll(pageable);
	}

}
