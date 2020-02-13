package com.ptccamp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ptccamp.domain.Student;
import com.ptccamp.repository.StudentRepository;
import com.ptccamp.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public Student insert(Student obj) {
		return studentRepository.save(obj);
	}

	@Override
	public Student update(Student obj) {
		return studentRepository.save(obj);
	}

	@Override
	public List<Student> getAll() {
		return studentRepository.findAll();
	}

	@Override
	public Student getById(Long id) {
		Optional<Student> op = studentRepository.findById(id);
		return op.isPresent() ? op.get() : new Student();
	}

	@Override
	public void delete(Long id) {
		studentRepository.deleteById(id);
	}

	@Override
	public Page<Student> getlAllStudent(Pageable pageable) {
		return studentRepository.findAll(pageable);
	}

}
