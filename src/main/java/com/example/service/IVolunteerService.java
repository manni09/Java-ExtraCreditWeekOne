package com.example.service;

import java.util.List;

import com.example.model.*;

public interface IVolunteerService {
	void createMovie(Project project);

	List<Project> getAll();
}
