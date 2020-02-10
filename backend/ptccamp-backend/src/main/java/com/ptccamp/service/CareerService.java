package com.ptccamp.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ptccamp.domain.Career;

public interface CareerService extends ICRUD<Career> {
	Page<Career> getlAllCareer(Pageable pageable);
}
