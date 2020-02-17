package com.ptccamp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ptccamp.domain.Attention;

import com.ptccamp.repository.AttentionRepository;
import com.ptccamp.service.AttentionService;

@Service
public class AttentionServiceImpl implements AttentionService {

	@Autowired
	private AttentionRepository attentionRepository;

	@Override
	public Attention insert(Attention obj) {
		return attentionRepository.save(obj);
	}

	@Override
	public Attention update(Attention obj) {
		return attentionRepository.save(obj);
	}

	@Override
	public List<Attention> getAll() {
		return attentionRepository.findAll();
	}

	@Override
	public Optional<Attention> getById(Long id) {
		//Optional<Attention> op = attentionRepository.findById(id);
		//return op.isPresent() ? op.get() : new Attention();
		return attentionRepository.findById(id);
	}

	@Override
	public void delete(Long id) {
		attentionRepository.deleteById(id);
	}

	@Override
	public Page<Attention> getlAllAttention(Pageable pageable) {
		return attentionRepository.findAll(pageable);
	}

}
