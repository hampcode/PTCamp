package com.ptccamp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ptccamp.domain.Career;

public interface CareerRepository extends JpaRepository<Career, Long> {

}
