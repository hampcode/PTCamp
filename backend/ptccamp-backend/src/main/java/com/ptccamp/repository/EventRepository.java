package com.ptccamp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ptccamp.domain.Event;

public interface EventRepository extends JpaRepository<Event, Long>{

}
