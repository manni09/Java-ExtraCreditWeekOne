package com.example.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.model.Address;
import com.example.model.Project;

public class TaskDAO {
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
}
