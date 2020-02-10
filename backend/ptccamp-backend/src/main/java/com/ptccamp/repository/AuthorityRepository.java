package com.ptccamp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ptccamp.domain.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {

}
