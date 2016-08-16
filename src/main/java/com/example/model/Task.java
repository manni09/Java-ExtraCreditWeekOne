package com.example.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Task {
	@Id
	@GeneratedValue
	private int id;
	private Date start_date;
	private Date end_date;
	private Status status;
	private String resource;
	private List<String> beneficiaries;
	
	List<User> volunteers;
}
