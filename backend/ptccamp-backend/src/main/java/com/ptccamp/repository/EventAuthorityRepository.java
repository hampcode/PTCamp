package com.ptccamp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ptccamp.domain.EventAuthority;

public interface EventAuthorityRepository extends JpaRepository<EventAuthority, Long> {

	// @Transactional
	@Modifying
	@Query(value = "INSERT INTO event_authority(event_id, authority_id) VALUES (:eventId, :authorityId)", nativeQuery = true)
	Integer register(@Param("eventId") Long eventId, @Param("authorityId") Long authorityId);
}
