package com.example.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.model.Address;
import com.example.model.Project;
import com.example.model.Status;
import com.example.model.User;

public class ProjectDAO {
	public void createProject(Project project) throws Exception {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;

		try {

			tx = session.beginTransaction();
			session.persist(project);
			tx.commit();

		} catch (Exception e) {

			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	public Project getProject(int id) throws Exception {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;

		try {

			tx = session.beginTransaction();
			Project project = session.get(Project.class, id);
			tx.commit();
			return project;

		} catch (Exception e) {

			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	public void updateProject(Project project) throws Exception {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;

		try {

			tx = session.beginTransaction();

			session.merge(project);

			tx.commit();

		} catch (Exception e) {

			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			throw new Exception(e);

		}

	}

	public void deleteProject(Project project) throws Exception {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;

		try {

			tx = session.beginTransaction();

			session.delete(project);

			tx.commit();

		} catch (Exception e) {

			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			throw new Exception(e);

		}
	}

	
	public List<Project> getProjectByLocation(Address addr) throws Exception {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		List<Project> projects = new ArrayList<>();

		try {

			tx = session.beginTransaction();
			Query query = session.createQuery("FROM Project p join p.address a WHERE a.street = :street Or a.city = :city or a.state = :state Or a.zip = :zip");
			query.setParameter("street", addr.getStreet());
			query.setParameter("city", addr.getCity());
			query.setParameter("state", addr.getState());
			query.setParameter("zip", addr.getZip());

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

	
	public List<Project> getProjectByKeyword(String name) throws Exception {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		List<Project> projects = new ArrayList<>();

		try {

			tx = session.beginTransaction();
			Query query = session.createQuery("FROM Project p where p.name like %:name%");
			query.setParameter("name", name);

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
	
	public List<Project> getAllProject() throws Exception {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		List<Project> projects = new ArrayList<>();

		try {

			tx = session.beginTransaction();
			Query query = session.createQuery("FROM Project");

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
	
	public List<Project> getProjectByStatus(Status status) throws Exception {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		List<Project> projects = new ArrayList<>();

		try {

			tx = session.beginTransaction();
			Query query = session.createQuery("FROM Project p where p.status = :status");
			query.setParameter("status", status.toString());

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
	
	public List<Project> getProjectByVolunteer(User volunteer) throws Exception {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		List<Project> projects = new ArrayList<>();

		try {

			tx = session.beginTransaction();
			Query query = session.createQuery("FROM Project p join p.tasks t join t.volunteers WHERE v.id = :id order by t.start_date");
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
	