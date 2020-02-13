package com.ptccamp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ptccamp.domain.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
