package com.ptccamp.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import com.ptccamp.domain.Event;
import com.ptccamp.dto.EventDTO;

public interface EventService  extends ICRUD<Event>{

	public Long registerTransactional(EventDTO eventDTO);
	
	public Page<Event> getlAllEvent(Pageable pageable);
}
