package com.ptccamp.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

@Entity
@Table(name = "attentions")
public class Attention {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonSerialize(using = ToStringSerializer.class)
	private LocalDateTime dateAttention;

	@Column(name = "type_attention", nullable = false, length = 255)
	private String typeAttention;

	@ManyToOne
	@JoinColumn(name = "student_id", nullable = false, foreignKey = @ForeignKey(name = "fk_attention_student"))
	private Student student;

	@ManyToOne
	@JoinColumn(name = "fulltimeteacher_id", nullable = false, foreignKey = @ForeignKey(name = "fk_attention_fulltimeteacher"))
	private FullTimeTeacher fullTimeTeacher;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDateAttention() {
		return dateAttention;
	}

	public void setDateAttention(LocalDateTime dateAttention) {
		this.dateAttention = dateAttention;
	}

	public String getTypeAttention() {
		return typeAttention;
	}

	public void setTypeAttention(String typeAttention) {
		this.typeAttention = typeAttention;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public FullTimeTeacher getFullTimeTeacher() {
		return fullTimeTeacher;
	}

	public void setFullTimeTeacher(FullTimeTeacher fullTimeTeacher) {
		this.fullTimeTeacher = fullTimeTeacher;
	}

}
