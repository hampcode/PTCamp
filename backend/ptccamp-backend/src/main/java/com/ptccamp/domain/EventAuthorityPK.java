package com.ptccamp.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class EventAuthorityPK implements Serializable {


	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "event_id", nullable = false, foreignKey = @ForeignKey(name = "event_authority_id"))
	private Event event;

	@ManyToOne
	@JoinColumn(name = "authority_id", nullable = false, foreignKey = @ForeignKey(name = "authority_event"))
	private Authority authority;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authority == null) ? 0 : authority.hashCode());
		result = prime * result + ((event == null) ? 0 : event.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EventAuthorityPK other = (EventAuthorityPK) obj;
		if (authority == null) {
			if (other.authority != null)
				return false;
		} else if (!authority.equals(other.authority))
			return false;
		if (event == null) {
			if (other.event != null)
				return false;
		} else if (!event.equals(other.event))
			return false;
		return true;
	}

}
