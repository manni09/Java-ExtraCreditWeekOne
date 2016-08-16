package com.example.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Project {
	@Id
	@GeneratedValue
	private int id;

	private String description;
	private Date start_date;
	private Date end_date;
	private Status status;

	List<Task> tasks;
}