package com.ptccamp.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import com.ptccamp.domain.TypeEvent;

public interface TypeEventService extends ICRUD<TypeEvent> {

	Page<TypeEvent> getlAllTypeEvent(Pageable pageable);
}
