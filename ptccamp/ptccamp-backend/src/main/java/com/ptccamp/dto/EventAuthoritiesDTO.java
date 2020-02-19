package com.ptccamp.dto;

import java.util.List;

import com.ptccamp.domain.Authority;
import com.ptccamp.domain.Event;

public class EventAuthoritiesDTO {

	private Event event;
	private List<Authority> authorities;

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public List<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}

}
