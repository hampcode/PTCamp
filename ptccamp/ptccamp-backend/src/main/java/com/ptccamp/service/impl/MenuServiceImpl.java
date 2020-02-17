package com.ptccamp.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptccamp.domain.Menu;
import com.ptccamp.repository.MenuRepository;
import com.ptccamp.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService{

	
	@Autowired
	private MenuRepository menuRepository;

	@Override
	public Menu insert(Menu obj) {
		return menuRepository.save(obj);
	}

	@Override
	public Menu update(Menu obj) {
		return menuRepository.save(obj);
	}

	@Override
	public List<Menu> getAll() {
		return menuRepository.findAll();
	}

	@Override
	public Optional<Menu> getById(Long id) {
		//Optional<Menu> op = menuRepository.findById(id);
		//return op.isPresent() ? op.get() : new Menu();
		return menuRepository.findById(id);
	}

	@Override
	public void delete(Long id) {
		menuRepository.deleteById(id);
	}

	@Override
	public List<Menu> getAllMenuByAccount(String name) {
		List<Menu> menus = new ArrayList<>();
		menuRepository.getAllMenuPorAccount(name).forEach( x -> {
			Menu m = new Menu();
			m.setId((Long.parseLong(String.valueOf(x[0]))));
			m.setIcon(String.valueOf(x[1]));
			m.setName(String.valueOf(x[2]));
			m.setUrl(String.valueOf(x[3]));		
	
			menus.add(m);
		});
		return menus;		
	}
	
	
}
