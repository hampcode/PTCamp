	package com.ptccamp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "students")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	@Column(name = "code", nullable = false, length = 10)
	private String code;

	@NotEmpty
	@Column(name = "first_name", nullable = false, length = 255)
	private String firstName;

	@NotEmpty
	@Column(name = "last_name", nullable = false, length = 255)
	private String lastName;

	@ManyToOne
	@JoinColumn(name = "career_id", nullable = false, foreignKey = @ForeignKey(name = "fk_student_career"))
	private Career career;
	
	@ManyToOne
	@JoinColumn(name = "study_mode_id", nullable = false, foreignKey = @ForeignKey(name = "fk_student_study_mode"))
	private StudyMode studyMode;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Career getCareer() {
		return career;
	}

	public void setCareer(Career career) {
		this.career = career;
	}

	public StudyMode getStudyMode() {
		return studyMode;
	}

	public void setStudyMode(StudyMode studyMode) {
		this.studyMode = studyMode;
	}
	
	

}
