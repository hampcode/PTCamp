package com.ptccamp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.ptccamp.domain.Account;
import com.ptccamp.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@PostMapping(produces = "application/json", consumes = "application/json")
	private ResponseEntity<Object> registrar(@RequestBody Account account){		
		accountService.registerTransactional(account);
		return new ResponseEntity<Object>(HttpStatus.CREATED);
	}
}
