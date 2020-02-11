package com.ptccamp.service;

import java.util.List;

import com.ptccamp.domain.Menu;

public interface MenuService extends ICRUD<Menu> {

	List<Menu> getAllMenuByAccount(String name);
}
