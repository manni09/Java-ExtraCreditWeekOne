package com.example.model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class User {
	
	private int id;
	private String first_name;
	private String last_name;
	
	@OneToOne
	private Address uAddress;

	@Enumerated(EnumType.STRING)
	private Role role;

	@ManyToMany(mappedBy = "volunteers")
	@ElementCollection
	List<Task> tasks;

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public Address getAddress() {
		return uAddress;
	}

	public Role getRole() {
		return role;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public void setAddress(Address address) {
		this.uAddress = address;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	
	
}
