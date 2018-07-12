package com.revaturesocialmedia.daos;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.revaturesocialmedia.beans.Employee;
import com.revaturesocialmedia.util.HibernateUtil;

@Component
public class EmployeeManager implements EmployeeDAO{
	private HibernateUtil hu = HibernateUtil.getInstance();
	private static EmployeeManager inst = null;
	
	private EmployeeManager() {
		
	}
	
	public static EmployeeManager getInst() {
		if (inst == null) inst = new EmployeeManager();
		return inst;
	}
	
	@Override
	public int save(Employee emp) {
		Session session = hu.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			int i = (Integer) session.save(emp);
			
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
	public Employee persist(Employee emp) {
		Session session = hu.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.persist(emp);
			System.out.println("successful persist");	// stahap. use log4j.
			tx.commit();
			
			return emp;
		} catch(Exception e) {
			System.out.println("BAd Persist");
			tx.rollback();
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public List<Employee> getAllHQL() {
		Session session = hu.getSession();
		Query<Employee> query = session.createQuery("from Employee");
		List<Employee> employees = query.list();
		
		return employees;
	}
	
	@Override
	public List<Employee> getByKeyword(String s) {
		Session session = hu.getSession();
		
		String hql = "select e from Employee e where "
				+ "lower(e.firstname) like :keyword "
				+ "OR lower(e.lastname) like :keyword "
				+ "OR lower(e.username) like :keyword "
				+ "OR lower(e.technologies) like :keyword";
		
		Query<Employee> query = session.createQuery(hql);
		query.setParameter("keyword", "%"+s.toLowerCase()+"%");
		List<Employee> employees = query.list();
		
		return employees;
	}
	
	@Override
	public List<Employee> getByKeywordCriteria(String s) {
		
		String hql = "select e from Employee e where "
				+ "lower(e.firstname) like :keyword "
				+ "OR lower(e.lastname) like :keyword "
				+ "OR lower(e.username) like :keyword "
				+ "OR lower(e.technologies) like :keyword";
		
		Session session = hu.getSession();
		
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Employee> criteria = cb.createQuery(Employee.class);
		Root<Employee> employeeRoot = criteria.from(Employee.class);
		Predicate cond = cb.or(cb.equal(employeeRoot.get("firstname"), s), cb.equal(employeeRoot.get("lastname"), s.toLowerCase()));
		criteria.where(cond);			
				
		List<Employee> employees = session.createQuery(criteria).getResultList();
		
		return employees;
	}

	@Override
	public List<Employee> getAllCriteria() {
		Session session = hu.getSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);
		criteria.from(Employee.class);
		List<Employee> employees = session.createQuery(criteria).getResultList();
		
		return employees;
	}

	@Override
	public Employee getById(int i) {
		Session su = hu.getSession();
		Employee emp = (Employee) su.get(Employee.class, i);
		su.close();
		return emp;

	}

	@Override
	public Employee loadById(int i) {
		Session su = hu.getSession();
		Employee emp = (Employee) su.load(Employee.class, i);
		// We have to actually access the data or we just return a proxy.
		// LazyInitializationException gets thrown if we try to access a PROXY with the session CLOSED
		su.close();
		return emp;

	}

	@Override
	public Employee update(Employee emp) {
		Session s = hu.getSession();
		Transaction tx = s.beginTransaction();
		s.update(emp);
		tx.commit();
		s.close();
		return emp;

	}

	@Override
	public Employee merge(Employee emp) {
		Session s = hu.getSession();
		Transaction tx = s.beginTransaction();
		emp = (Employee)s.merge(emp);
		tx.commit();
		s.close();
		return emp;
	}

	@Override
	public void updateHQL() {
		// TODO Auto-generated method stub
	}

	@Override
	public void delete(Employee emp) {
		Session s = hu.getSession();
		Transaction tx = s.beginTransaction();
		s.delete(emp);
		tx.commit();
		s.close();

		
	}

	@Override
	public Employee login(String username, String password) {
        Session s = hu.getSession();
        String query = "from Employee e where e.username=:username and e.password=:password";
        Query<Employee> q = s.createQuery(query, Employee.class);
        q.setParameter("username", username);
        q.setParameter("password", password);
        Employee e = q.uniqueResult();
        s.close();
        return e;
	}

}
