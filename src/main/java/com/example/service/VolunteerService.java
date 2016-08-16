package com.example.service;

import java.util.List;

import com.example.model.Address;
import com.example.model.Project;
import com.example.model.Status;
import com.example.dao.ProjectDAO;

public class VolunteerService implements IVolunteerService {

	private ProjectDAO projectDAO;

	@Override
	public void createProject(Project project) {
		// TODO Auto-generated method stub
		try {

			projectDAO.createProject(project);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Project> getAll() {
		try {

			List<Project> projectList = (List<Project>) projectDAO.getAllProject();
			return projectList;

		} catch (Exception e) {
			e.printStackTrace();
			throw new IllegalArgumentException(e);
		}
	}
	
	@Override
	public List<Project> searchProjectByStatus(Status status) {
		try {

			List<Project> projects = (List<Project>) projectDAO.getProjectByStatus(status);
			return projects;

		} catch (Exception e) {
			e.printStackTrace();
			throw new IllegalArgumentException(e);
		}
	}
	
	@Override
	public List<Project> getProjectByKeyword(String keyword) {
		try {

			List<Project> projects = (List<Project>) projectDAO.getProjectByKeyword(keyword);
			return projects;

		} catch (Exception e) {
			e.printStackTrace();
			throw new IllegalArgumentException(e);
		}
	}
	
	@Override
	public List<Project> getProjectByLocation(Address addr) {
		try {

			List<Project> projects = (List<Project>) projectDAO.getProjectByLocation(addr);
			return projects;

		} catch (Exception e) {
			e.printStackTrace();
			throw new IllegalArgumentException(e);
		}
	}
	

}
