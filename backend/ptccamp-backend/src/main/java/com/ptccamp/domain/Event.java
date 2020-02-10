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
@Table(name = "events")
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonSerialize(using = ToStringSerializer.class)
	private LocalDateTime dateEvent;

	@Column(name = "number_quests", length = 2)
	private int numberOfQuests;

	@Column(name = "number_attendees", length = 2)
	private int numberOfAttendees;

	@Column(name = "comments", nullable = false, length = 255)
	private String comments;

	@ManyToOne
	@JoinColumn(name = "campus_id", nullable = false, foreignKey = @ForeignKey(name = "fk_event_campus"))
	private Campus campus;

	@ManyToOne
	@JoinColumn(name = "career_id", nullable = false, foreignKey = @ForeignKey(name = "fk_event_career"))
	private Career career;

	@ManyToOne
	@JoinColumn(name = "type_event_id", nullable = false, foreignKey = @ForeignKey(name = "fk_event_type_event"))
	private TypeEvent typeEvent;

	@ManyToOne
	@JoinColumn(name = "full_time_teacher_id", nullable = false, foreignKey = @ForeignKey(name = "fk_event_full_time_teacher"))
	private FullTimeTeacher fullTimeTeacher;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDateEvent() {
		return dateEvent;
	}

	public void setDateEvent(LocalDateTime dateEvent) {
		this.dateEvent = dateEvent;
	}

	public int getNumberOfQuests() {
		return numberOfQuests;
	}

	public void setNumberOfQuests(int numberOfQuests) {
		this.numberOfQuests = numberOfQuests;
	}

	public int getNumberOfAttendees() {
		return numberOfAttendees;
	}

	public void setNumberOfAttendees(int numberOfAttendees) {
		this.numberOfAttendees = numberOfAttendees;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Campus getCampus() {
		return campus;
	}

	public void setCampus(Campus campus) {
		this.campus = campus;
	}

	public Career getCareer() {
		return career;
	}

	public void setCareer(Career career) {
		this.career = career;
	}

	public TypeEvent getTypeEvent() {
		return typeEvent;
	}

	public void setTypeEvent(TypeEvent typeEvent) {
		this.typeEvent = typeEvent;
	}

	public FullTimeTeacher getFullTimeTeacher() {
		return fullTimeTeacher;
	}

	public void setFullTimeTeacher(FullTimeTeacher fullTimeTeacher) {
		this.fullTimeTeacher = fullTimeTeacher;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Event other = (Event) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
