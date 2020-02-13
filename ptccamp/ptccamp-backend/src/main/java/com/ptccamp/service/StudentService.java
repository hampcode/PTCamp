package com.ptccamp.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ptccamp.domain.Student;

public interface StudentService extends ICRUD<Student>{
	Page<Student> getlAllStudent(Pageable pageable);
}
