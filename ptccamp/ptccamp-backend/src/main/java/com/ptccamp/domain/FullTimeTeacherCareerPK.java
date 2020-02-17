package com.ptccamp.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class FullTimeTeacherCareerPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "full_time_teacher_id", nullable = false, foreignKey = @ForeignKey(name = "fulltimeteacher_career_id"))
	private FullTimeTeacher fullTimeTeacher;

	@ManyToOne
	@JoinColumn(name = "career_id", nullable = false, foreignKey = @ForeignKey(name = "career_fulltimeteacher_id"))
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
