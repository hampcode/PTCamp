package com.ptccamp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ptccamp.domain.Account;



public interface AccountRepository extends JpaRepository<Account, Long> {

	Account findOneByUsername(String username);
	
	@Modifying
	@Query(value = "INSERT INTO account_role (account_id, role_id) VALUES (:accountId, :roleId)", nativeQuery = true)
	void registerRolPorDefault(@Param("accountId") Long accountId, @Param("roleId") Long iroleId);
}
