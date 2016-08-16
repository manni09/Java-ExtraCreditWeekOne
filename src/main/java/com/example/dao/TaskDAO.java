package com.example.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.model.Project;
import com.example.model.User;

public class TaskDAO {
	@SuppressWarnings("unchecked")
	public List<Project> getTaskByProject(Project project) throws Exception {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		List<Project> projects = new ArrayList<>();

		try {

			tx = session.beginTransaction();
			Query query = session.createQuery("FROM Task t join t.project p WHERE p.id = :id");
			query.setParameter("id", project.getId());

			projects = query.list();

			tx.commit();

		} catch (Exception e) {

			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			throw new Exception(e);
		}

		return projects;

	}
	
	@SuppressWarnings("unchecked")
	public List<Project> getTaskByVolunteer(User volunteer) throws Exception {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		List<Project> projects = new ArrayList<>();

		try {

			tx = session.beginTransaction();
			Query query = session.createQuery("FROM Task t join t.volunteers v WHERE v.id = :id order by t.start_date");
			query.setParameter("id", volunteer.getId());

			projects = query.list();

			tx.commit();

		} catch (Exception e) {

			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			throw new Exception(e);
		}

		return projects;

	}
}
