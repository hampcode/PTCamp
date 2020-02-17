package com.ptccamp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import com.ptccamp.domain.FullTimeTeacher;
import com.ptccamp.repository.FullTimeTeacherRepository;
import com.ptccamp.service.FullTimeTeacherService;

@Service
public class FullTimeTeacherServiceImpl implements FullTimeTeacherService{
	
	@Autowired
	private FullTimeTeacherRepository fullTimeTeacherRepository;

	@Override
	public FullTimeTeacher insert(FullTimeTeacher obj) {
		return fullTimeTeacherRepository.save(obj);
	}

	@Override
	public FullTimeTeacher update(FullTimeTeacher obj) {
		return fullTimeTeacherRepository.save(obj);
	}

	@Override
	public List<FullTimeTeacher> getAll() {
		return fullTimeTeacherRepository.findAll();
	}

	@Override
	public Optional<FullTimeTeacher> getById(Long id) {
		//Optional<FullTimeTeacher> op = fullTimeTeacherRepository.findById(id);
		//return op.isPresent() ? op.get() : new FullTimeTeacher();
		return fullTimeTeacherRepository.findById(id);
	}

	@Override
	public void delete(Long id) {
		fullTimeTeacherRepository.deleteById(id);
	}

	@Override
	public Page<FullTimeTeacher> getlAllFullTimeTeacher(Pageable pageable) {
		return fullTimeTeacherRepository.findAll(pageable);
	}

	
}
