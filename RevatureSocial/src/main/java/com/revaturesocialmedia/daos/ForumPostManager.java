package com.revaturesocialmedia.daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.revaturesocialmedia.beans.ForumPost;
import com.revaturesocialmedia.util.HibernateUtil;

@Component
public class ForumPostManager implements ForumPostDAO{
	private HibernateUtil hu = HibernateUtil.getInstance();
	
	@Override
	public int save(ForumPost fp) {
		Session session = hu.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			int i = (Integer) session.save(fp);
			
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
	public ForumPost persist(ForumPost fp) {
		Session session = hu.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.persist(fp);
			System.out.println("Successful persist");
			tx.commit();
			
			return fp;
		} catch(Exception e) {
			System.out.println("Bad Persist");
			tx.rollback();
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public List<ForumPost> getAllHQL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ForumPost> getAllCriteria() {
        Session s = hu.getSession();
        String query = "from ForumPost f";
        Query<ForumPost> q = s.createQuery(query, ForumPost.class);
        List<ForumPost> fpl = new ArrayList<ForumPost>();
        fpl = q.list();
        s.close();
        return fpl;
	}

	@Override
	public ForumPost getById(int i) {
		Session su = hu.getSession();
		ForumPost fp = (ForumPost) su.get(ForumPost.class, i);
		su.close();
		return fp;

	}

	@Override
	public ForumPost loadById(int i) {
		Session su = hu.getSession();
		ForumPost fp = (ForumPost) su.load(ForumPost.class, i);
		// We have to actually access the data or we just return a proxy.
		// LazyInitializationException gets thrown if we try to access a PROXY with the session CLOSED
		su.close();
		return fp;

	}

	@Override
	public ForumPost update(ForumPost fp) {
		Session s = hu.getSession();
		Transaction tx = s.beginTransaction();
		s.update(fp);
		tx.commit();
		s.close();
		return fp;

	}

	@Override
	public ForumPost merge(ForumPost fp) {
		Session s = hu.getSession();
		Transaction tx = s.beginTransaction();
		fp = (ForumPost)s.merge(fp);
		tx.commit();
		s.close();
		return fp;
	}

	@Override
	public void updateHQL() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(ForumPost fp) {
		Session s = hu.getSession();
		Transaction tx = s.beginTransaction();
		s.delete(fp);
		tx.commit();
		s.close();	
	}

}
