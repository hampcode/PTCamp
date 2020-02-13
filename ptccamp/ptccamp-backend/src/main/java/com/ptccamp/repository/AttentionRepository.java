package com.ptccamp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ptccamp.domain.Attention;

public interface AttentionRepository extends JpaRepository<Attention, Long> {

}
