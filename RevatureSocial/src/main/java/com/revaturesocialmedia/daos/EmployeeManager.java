package com.revaturesocialmedia.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revaturesocialmedia.beans.Employee;

public class EmployeeManager implements EmployeeDAO{

	private static EmployeeManager inst = null;
	private EmployeeManager() {
		
	}
	
	public static EmployeeDAO getInst() {
		if(inst == null) inst = new EmployeeManager();
		return inst;
	}
	
	@Override
	public Employee save(Employee emp) {
		Session session = hu.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			int i = (Integer) session.save(emp);
			
			tx.commit();
			
			return emp;
		} catch(Exception e) {
			tx.rollback();
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}

	}

	@Override
	public Employee persist(Employee e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getAllHQL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getAllCriteria() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getById(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee loadById(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee update(Employee e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee merge(Employee e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateHQL() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Employee e) {
		// TODO Auto-generated method stub
		
	}

}
