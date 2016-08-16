package com.example.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue
	private int id;
	private String first_name;
	private String last_name;

	@Enumerated(EnumType.STRING)
	private Role role;

	List<Task> tasks;

}
