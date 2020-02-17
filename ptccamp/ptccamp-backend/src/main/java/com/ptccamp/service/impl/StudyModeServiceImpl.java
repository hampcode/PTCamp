package com.ptccamp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ptccamp.domain.StudyMode;
import com.ptccamp.repository.StudyModeRepository;
import com.ptccamp.service.StudyModeService;

@Service
public class StudyModeServiceImpl implements StudyModeService {
	
	@Autowired
	private StudyModeRepository studyModeRepository;

	@Override
	public StudyMode insert(StudyMode obj) {
		return studyModeRepository.save(obj);
	}

	@Override
	public StudyMode update(StudyMode obj) {
		return studyModeRepository.save(obj);
	}

	@Override
	public List<StudyMode> getAll() {
		return studyModeRepository.findAll();
	}

	@Override
	public Optional<StudyMode> getById(Long id) {
		//Optional<StudyMode> op = studyModeRepository.findById(id);
		//return op.isPresent() ? op.get() : new StudyMode();
		return studyModeRepository.findById(id);
	}

	@Override
	public void delete(Long id) {
		studyModeRepository.deleteById(id);
	}

	@Override
	public Page<StudyMode> getlAllStudyMode(Pageable pageable) {
		return studyModeRepository.findAll(pageable);
	}

}
