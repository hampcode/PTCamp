package com.ptccamp.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class CampusCareerPK implements Serializable  {

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "campus_id", nullable = false, foreignKey = @ForeignKey(name = "campus_career_id"))
	private Campus campus;

	@ManyToOne
	@JoinColumn(name = "career_id", nullable = false, foreignKey = @ForeignKey(name = "career_campus_id"))
	private Career career;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((campus == null) ? 0 : campus.hashCode());
		result = prime * result + ((career == null) ? 0 : career.hashCode());
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
		CampusCareerPK other = (CampusCareerPK) obj;
		if (campus == null) {
			if (other.campus != null)
				return false;
		} else if (!campus.equals(other.campus))
			return false;
		if (career == null) {
			if (other.career != null)
				return false;
		} else if (!career.equals(other.career))
			return false;
		return true;
	}

	

}
