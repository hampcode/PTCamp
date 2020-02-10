package com.ptccamp;

import static org.junit.Assert.assertTrue;



import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;


import com.ptccamp.domain.Account;
import com.ptccamp.domain.FullTimeTeacher;
import com.ptccamp.service.AccountService;



@RunWith(SpringRunner.class)
@SpringBootTest
class PtccampBackendApplicationTests {

	@Autowired
	private AccountService accountService;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	@Test
	public void crearUsuario() {
		Account account = new Account();				
		account.setUsername("giovanna.trillo@upc.pe");
		account.setPassword(bcrypt.encode("Upc123456."));
		account.setEnabled(true);		
		
		FullTimeTeacher fullTimeTeacher = new FullTimeTeacher();		
		fullTimeTeacher.setFirstName("Giovanna");
		fullTimeTeacher.setLastName("Trillo Rivera");
		fullTimeTeacher.setAccount(account);
		account.setFullTimeTeacher(fullTimeTeacher);
			
		Account accountNew = accountService.registerTransactional(account);
		
		assertTrue(accountNew.getPassword().equalsIgnoreCase(accountNew.getPassword()));
	}

}
