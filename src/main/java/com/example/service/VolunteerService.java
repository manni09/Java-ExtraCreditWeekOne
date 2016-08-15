package com.example.service;

import java.util.List;

import com.example.model.Project;
import com.example.dao.ProjectDAO;

public class VolunteerService implements IVolunteerService {

	private ProjectDAO projectDAO;

	@Override
	public void createMovie(Project project) {
		// TODO Auto-generated method stub
		try {

			projectDAO.save(project);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Project> getAll() {
		try {

			List<Project> projectList = (List<Project>) projectDAO.findAll();
			return projectList;

		} catch (Exception e) {
			e.printStackTrace();
			throw new IllegalArgumentException(e);
		}
	}

}
