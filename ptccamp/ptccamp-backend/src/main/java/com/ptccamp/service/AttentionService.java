package com.ptccamp.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ptccamp.domain.Attention;

public interface AttentionService extends ICRUD<Attention> {
	Page<Attention> getlAllAttention(Pageable pageable);
}
