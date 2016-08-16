package com.example.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Project {

	private int id;
	private String name;
	private String description;
	private Date start_date;
	private Date end_date;
	private Status status;
	private Address addr;
	private List<Task> tasks;

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
		return addr;
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

	public void setAddr(Address addr) {
		this.addr = addr;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

}
