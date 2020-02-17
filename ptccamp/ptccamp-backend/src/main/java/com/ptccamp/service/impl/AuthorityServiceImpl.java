package com.ptccamp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ptccamp.domain.Authority;
import com.ptccamp.repository.AuthorityRepository;
import com.ptccamp.service.AuthorityService;

@Service
public class AuthorityServiceImpl implements AuthorityService{
	
	@Autowired
	private AuthorityRepository authorityRepository;

	@Override
	public Authority insert(Authority obj) {
		return authorityRepository.save(obj);
	}

	@Override
	public Authority update(Authority obj) {
		return authorityRepository.save(obj);
	}

	@Override
	public List<Authority> getAll() {
		return authorityRepository.findAll();
	}

	@Override
	public Optional<Authority> getById(Long id) {
		//Optional<Authority> op = authorityRepository.findById(id);
		//return op.isPresent() ? op.get() : new Authority();
		return authorityRepository.findById(id);
	}

	@Override
	public void delete(Long id) {
		authorityRepository.deleteById(id);
	}

	@Override
	public Page<Authority> getlAllAuthority(Pageable pageable) {
		return authorityRepository.findAll(pageable);
	}
	
	

}
