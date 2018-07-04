package com.revaturesocialmedia.daos;

import java.util.List;

import com.revaturesocialmedia.beans.Employee;

public interface EmployeeDAO {
	

		//CREATE
		int save(Employee e);
		Employee persist(Employee e);
		
		//READ
		List<Employee> getAllHQL();
		List<Employee> getAllCriteria();
		Employee getById(int i);
		Employee loadById(int i);
		
		//UPDATE
		Employee update(Employee e);
		Employee merge(Employee e);
		void updateHQL();
		
		//DELETE
		void delete(Employee e);
	

}
