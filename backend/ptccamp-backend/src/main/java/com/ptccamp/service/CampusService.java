package com.ptccamp.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import com.ptccamp.domain.Campus;

public interface CampusService extends ICRUD<Campus>{
	 Page<Campus> getlAllCampus(Pageable pageable);
}
