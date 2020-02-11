package com.ptccamp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ptccamp.domain.Campus;

public interface CampusRepository extends JpaRepository<Campus, Long>{

}
