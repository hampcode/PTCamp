package com.ptccamp.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ptccamp.domain.Authority;


public interface AuthorityService extends ICRUD<Authority> {
	public Page<Authority> getlAllAuthority(Pageable pageable);

}
