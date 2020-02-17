package com.ptccamp.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(FullTimeTeacherCareerPK.class)
public class FullTimeTeacherCareer {

	@Id
	private FullTimeTeacher fullTimeTeacher;
	@Id
	private Career career;

	public FullTimeTeacher getFullTimeTeacher() {
		return fullTimeTeacher;
	}

	public void setFullTimeTeacher(FullTimeTeacher fullTimeTeacher) {
		this.fullTimeTeacher = fullTimeTeacher;
	}

	public Career getCareer() {
		return career;
	}

	public void setCareer(Career career) {
		this.career = career;
	}

}
