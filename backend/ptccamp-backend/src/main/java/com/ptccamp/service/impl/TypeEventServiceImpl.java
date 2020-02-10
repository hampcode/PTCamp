package com.ptccamp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ptccamp.domain.TypeEvent;
import com.ptccamp.repository.TypeEventRepository;
import com.ptccamp.service.TypeEventService;

@Service
public class TypeEventServiceImpl implements TypeEventService {

	@Autowired
	private TypeEventRepository typeEventRepository;

	@Override
	public TypeEvent insert(TypeEvent obj) {
		return typeEventRepository.save(obj);
	}

	@Override
	public TypeEvent update(TypeEvent obj) {
		return typeEventRepository.save(obj);
	}

	@Override
	public List<TypeEvent> getAll() {
		return typeEventRepository.findAll();
	}

	@Override
	public TypeEvent getById(Long id) {
		Optional<TypeEvent> op = typeEventRepository.findById(id);
		return op.isPresent() ? op.get() : new TypeEvent();
	}

	@Override
	public void delete(Long id) {
		typeEventRepository.deleteById(id);
	}

	@Override
	public Page<TypeEvent> getlAllTypeEvent(Pageable pageable) {
		return typeEventRepository.findAll(pageable);
	}

}
