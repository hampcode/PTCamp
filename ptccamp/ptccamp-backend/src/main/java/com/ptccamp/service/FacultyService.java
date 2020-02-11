package com.ptccamp.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ptccamp.domain.Faculty;

public interface FacultyService extends ICRUD<Faculty>{
	 Page<Faculty> getlAllFaculties(Pageable pageable);
}
