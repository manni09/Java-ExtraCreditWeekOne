package com.example.service;

import java.util.List;

import com.example.model.*;

public interface IVolunteerService {
	void createProject(Project project);

	List<Project> getAll();

	List<Project> searchProjectByStatus(Status status);

	List<Project> getProjectByKeyword(String keyword);

	List<Project> getProjectByLocation(Address addr);
}
