package com.ptccamp.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ptccamp.domain.StudyMode;

public interface StudyModeService extends ICRUD<StudyMode> {
	Page<StudyMode> getlAllStudyMode(Pageable pageable);
}
