package com.example.main;

import static org.assertj.core.api.Assertions.setRemoveAssertJRelatedElementsFromStackTrace;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.model.Address;
import com.example.model.Project;
import com.example.model.Role;
import com.example.model.Status;
import com.example.model.Task;
import com.example.model.User;
import com.example.service.IVolunteerService;
import com.example.service.VolunteerService;

public class ExtraCreditWeekOneApplication {

	public static void main(String[] args) {

		populateData();

	}

	public static void populateData() {

		Project project1 = new Project();
		//Project project2 = new Project();

		project1.setName("GTZ Action Aid");
		project1.setDescription("Help Poor and Needy People by Providing Food, Cloth and Shoes");
		project1.setStart_date(new Date(2016, 7, 01));
		project1.setEnd_date(new Date(2016, 8, 01));
		project1.setStatus(Status.PENDING);

		//project2.setName("Green Environment");
		//project2.setDescription("Plant a tree everywhere");
		//project2.setStart_date(new Date(2016, 04, 12));
		//project2.setEnd_date(new Date(2016, 04, 27));
		//project2.setStatus(Status.COMPLETE);
		
		Task task1 = new Task();
		
		List<String> Beneficiaries1 = new ArrayList<>();
		Beneficiaries1.add("Community");
		
		List<String> resources1 = new ArrayList<>();
		resources1.add("200 pair shoes");
		
		task1.setBeneficiaries(Beneficiaries1);
		task1.setResource(resources1);
		task1.setStart_date(new Date(2016, 7, 01));
		task1.setStart_date(new Date(2016, 8, 01));
		task1.setStatus(Status.PENDING);
		
		List<User> volunteers = new ArrayList<>();
		
		User volunteer1 = new User();
		Address address1 = new Address();
		address1.setCity("FairField");
		address1.setState("Iowa");
		address1.setZip("52557");
		address1.setStreet("1000 N. 9th St.");
				
		volunteer1.setFirst_name("Jemes");
		volunteer1.setLast_name("Cooker");
		volunteer1.setRole(Role.VOLTUNEER);
		volunteer1.setAddress(address1);
		
		volunteers.add(volunteer1);
		
		task1.setVolunteers(volunteers);
		List<Task> tasks = new ArrayList<>();
		tasks.add(task1);
		
		project1.setTasks(tasks);
		
		IVolunteerService volunteerService = new VolunteerService();
		
		volunteerService.createProject(project1);
		
	}
	
	public static void readProject(){
		IVolunteerService volunteerService = new VolunteerService();
		List<Project> projects = volunteerService.getProjectByKeyword("GTZ");
		
		for(Project project : projects){
			System.out.println(String.format("%1$10s %2$10s %3$10s %4$10s", project.getName(), project.getDescription(), project.getStart_date().toString(), project.getStatus().toString()));
		}
		
		
		
	}

}
