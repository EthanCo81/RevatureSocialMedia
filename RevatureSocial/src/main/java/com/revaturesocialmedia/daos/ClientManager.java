package com.revaturesocialmedia.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.revaturesocialmedia.beans.Client;
import com.revaturesocialmedia.util.HibernateUtil;


@Component
public class ClientManager implements ClientDAO {
	private HibernateUtil hu = HibernateUtil.getInstance();
	
	@Override
	public int save(Client c) {
		Session session = hu.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			int i = (Integer) session.save(c);
			
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
	public Client persist(Client c) {
		Session session = hu.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.persist(c);
			
			tx.commit();
			
			return c;
		} catch(Exception e) {
			tx.rollback();
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public List<Client> getAllHQL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Client> getAllCriteria() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client getById(int i) {
		Session su = hu.getSession();
		Client c = (Client) su.get(Client.class, i);
		su.close();
		return c;

	}

	@Override
	public Client loadById(int i) {
		Session su = hu.getSession();
		Client c = (Client) su.load(Client.class, i);
		// We have to actually access the data or we just return a proxy.
		// LazyInitializationException gets thrown if we try to access a PROXY with the session CLOSED
		su.close();
		return c;

	}

	@Override
	public Client update(Client c) {
		Session s = hu.getSession();
		Transaction tx = s.beginTransaction();
		s.update(c);
		tx.commit();
		s.close();
		return c;

	}

	@Override
	public Client merge(Client c) {
		Session s = hu.getSession();
		Transaction tx = s.beginTransaction();
		c = (Client)s.merge(c);
		tx.commit();
		s.close();
		return c;
	}

	@Override
	public void updateHQL() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Client c) {
		Session s = hu.getSession();
		Transaction tx = s.beginTransaction();
		s.delete(c);
		tx.commit();
		s.close();

		
	}

	@Override
	public Client login(String username, String password) {
        Session s = hu.getSession();
        String query = "from Client c where c.username=:username and c.password=:password";
        Query<Client> q = s.createQuery(query, Client.class);
        q.setParameter("username", username);
        q.setParameter("password", password);
        Client c = q.uniqueResult();
        s.close();
        return c;
	}
}
