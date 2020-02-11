package com.ptccamp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ptccamp.domain.Account;
import com.ptccamp.repository.AccountRepository;
import com.ptccamp.service.AccountService;

@Service
public class AccountServiceImpl implements UserDetailsService, AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Value("${ptccamp.default-rol}")
	private Long DEFAULT_ROL;

	@Transactional
	@Override
	public Account registerTransactional(Account account) {
		Account accountNew = accountRepository.save(account);
		accountRepository.registerRolPorDefault(accountNew.getId(), DEFAULT_ROL);
		return accountNew;

	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account account = accountRepository.findOneByUsername(username); // from usuario where username := username

		if (account == null) {
			throw new UsernameNotFoundException(String.format("Usuario no existe", username));
		}

		List<GrantedAuthority> authorities = new ArrayList<>();

		account.getRoles().forEach(role -> {
			authorities.add(new SimpleGrantedAuthority(role.getNombre()));
		});

		UserDetails userDetails = new User(account.getUsername(), account.getPassword(), authorities);

		return userDetails;
	}

}
