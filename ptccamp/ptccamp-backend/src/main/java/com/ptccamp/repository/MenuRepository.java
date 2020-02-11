package com.ptccamp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ptccamp.domain.Menu;

public interface MenuRepository extends JpaRepository<Menu, Long>{


	@Query(value="select distinct mr.*  from menu_role mr inner join account_role ac on ac.role_id = mr.role_id inner join menu m on m.id = mr.menu_id inner join accounts a on a.id = ac.account_id inner join full_time_teachers ftt on ftt.id = a.id where ftt.name = :name", nativeQuery = true)
	List<Object[]> getAllMenuPorAccount(@Param("name") String name);
	
	//0 | [ 1, 'search', 'search', '/search']
	//1 | [ 2, 'register', 'register', '/register']
	
	
	
}
