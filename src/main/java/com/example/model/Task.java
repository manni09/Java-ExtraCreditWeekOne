package com.example.model;

import java.util.Date;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Task {

	private int id;

	@Temporal(TemporalType.DATE)
	private Date start_date;
	
	@Temporal(TemporalType.DATE)
	private Date end_date;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@ElementCollection
	private List<String> resource;
	
	@ElementCollection
	private List<String> beneficiaries;

	@ManyToMany
	@ElementCollection
	List<User> volunteers;
	
	@ManyToOne
	private Project project;

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public Date getStart_date() {
		return start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public Status getStatus() {
		return status;
	}

	public List<String> getResource() {
		return resource;
	}

	public List<String> getBeneficiaries() {
		return beneficiaries;
	}

	public List<User> getVolunteers() {
		return volunteers;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public void setResource(List<String> resource) {
		this.resource = resource;
	}

	public void setBeneficiaries(List<String> beneficiaries) {
		this.beneficiaries = beneficiaries;
	}

	public void setVolunteers(List<User> volunteers) {
		this.volunteers = volunteers;
	}

}
