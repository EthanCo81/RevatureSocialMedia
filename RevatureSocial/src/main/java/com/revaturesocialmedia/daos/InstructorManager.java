package com.revaturesocialmedia.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.revaturesocialmedia.beans.Client;
import com.revaturesocialmedia.beans.Instructor;
import com.revaturesocialmedia.util.HibernateUtil;


@Component
public class InstructorManager implements InstructorDAO {
	private HibernateUtil hu = HibernateUtil.getInstance();

	@Override
	public int save(Instructor in) {
		Session session = hu.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			int i = (Integer) session.save(in);
			
			tx.commit();
			
			return i;
		} catch(Exception e) {
			tx.rollback();
			e.printStackTrace();
			return -1;
		} finally {
			session.close();
		}

	}

	@Override
	public Instructor persist(Instructor in) {
		Session session = hu.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.persist(in);
			
			tx.commit();
			
			return in;
		} catch(Exception e) {
			tx.rollback();
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public List<Instructor> getAllHQL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Instructor> getAllCriteria() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Instructor getById(int i) {
		Session su = hu.getSession();
		Instructor in = (Instructor) su.get(Instructor.class, i);
		su.close();
		return in;

	}

	@Override
	public Instructor loadById(int i) {
		Session su = hu.getSession();
		Instructor in = (Instructor) su.load(Instructor.class, i);
		// We have to actually access the data or we just return a proxy.
		// LazyInitializationException gets thrown if we try to access a PROXY with the session CLOSED
		su.close();
		return in;

	}

	@Override
	public Instructor update(Instructor in) {
		Session s = hu.getSession();
		Transaction tx = s.beginTransaction();
		s.update(in);
		tx.commit();
		s.close();
		return in;

	}

	@Override
	public Instructor merge(Instructor in) {
		Session s = hu.getSession();
		Transaction tx = s.beginTransaction();
		in = (Instructor)s.merge(in);
		tx.commit();
		s.close();
		return in;
	}

	@Override
	public void updateHQL() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Instructor in) {
		Session s = hu.getSession();
		Transaction tx = s.beginTransaction();
		s.delete(in);
		tx.commit();
		s.close();

		
	}
	@Override
	public Instructor login(String username, String password) {
        Session s = hu.getSession();
        String query = "from Instructor i where i.username=:username and i.password=:password";
        Query<Instructor> q = s.createQuery(query, Instructor.class);
        q.setParameter("username", username);
        q.setParameter("password", password);
        Instructor i = q.uniqueResult();
        s.close();
        return i;
	}


}
