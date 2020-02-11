package com.ptccamp.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import com.ptccamp.domain.FullTimeTeacher;

public interface FullTimeTeacherService extends ICRUD<FullTimeTeacher>{

	Page<FullTimeTeacher> getlAllFullTimeTeacher(Pageable pageable);
}
