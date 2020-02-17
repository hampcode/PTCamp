package com.ptccamp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import com.ptccamp.domain.Event;
import com.ptccamp.dto.EventDTO;
import com.ptccamp.repository.EventAuthorityRepository;
import com.ptccamp.repository.EventRepository;
import com.ptccamp.service.EventService;

@Service
public class EventServiceImpl implements EventService{
	
	@Autowired
	private EventRepository eventRepository;
	
	@Autowired
	private EventAuthorityRepository eventAuthorityRepository;

	@Override
	public Event insert(Event obj) {		
		return eventRepository.save(obj);
	}

	@Override
	public Event update(Event obj) {
		return eventRepository.save(obj);
	}

	@Override
	public List<Event> getAll() {
		return eventRepository.findAll();
	}

	@Override
	public Optional<Event> getById(Long id) {
		//Optional<Event> op = eventRepository.findById(id);
		//return op.isPresent() ? op.get() : new Event();
		return eventRepository.findById(id);
	}

	@Override
	public void delete(Long id) {
		eventRepository.deleteById(id);
	}

	@Override
	public Long registerTransactional(EventDTO eventDTO) {
		
		eventRepository.save(eventDTO.getEvent());
		
		eventDTO.getAuthorities().forEach( ea -> eventAuthorityRepository.register(eventDTO.getEvent().getId() , ea.getId()));
		return 1L;
	}

	@Override
	public Page<Event> getlAllEvent(Pageable pageable) {		
		return eventRepository.findAll(pageable);
	}
	
	

}
