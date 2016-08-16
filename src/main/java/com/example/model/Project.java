package com.example.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SecondaryTable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@SecondaryTable(name = "Additional")
public class Project {

	private int id;
	private String name;
	private String description;
	
	@Temporal(TemporalType.DATE)
	private Date start_date;
	
	@Temporal(TemporalType.DATE)
	private Date end_date;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@OneToOne
	private Address address;
	
	@OneToMany(mappedBy = "project")
	@ElementCollection
	private List<Task> tasks;
	
	@Lob
	@Column(table = "Additional")
	private byte[] image;

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
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

	public Address getAddr() {
		return address;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public void setAddr(Address address) {
		this.address = address;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

}
