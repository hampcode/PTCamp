package com.ptccamp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ptccamp.domain.Menu;
import com.ptccamp.service.MenuService;

@RestController
@RequestMapping("/menus")
public class MenuController {

	@Autowired
	private MenuService menuService;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Menu>> listar() {
		List<Menu> menus = new ArrayList<>();
		menus = menuService.getAll();
		return new ResponseEntity<List<Menu>>(menus, HttpStatus.OK);
	}

	@PostMapping(value = "/usuario", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Menu>> listar(@RequestBody String name) {
		List<Menu> menues = new ArrayList<>();
		menues = menuService.getAllMenuByAccount(name);
		return new ResponseEntity<List<Menu>>(menues, HttpStatus.OK);
	}

}
