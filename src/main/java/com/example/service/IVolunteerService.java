package com.example.service;

import java.util.List;

import com.example.model.*;

public interface IVolunteerService {
	void createProject(Project project);

	List<Project> getAll();
}
