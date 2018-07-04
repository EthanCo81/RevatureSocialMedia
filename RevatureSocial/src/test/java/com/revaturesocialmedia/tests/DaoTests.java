package com.revaturesocialmedia.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import com.revaturesocialmedia.beans.Employee;
import com.revaturesocialmedia.daos.EmployeeDAO;
import com.revaturesocialmedia.daos.EmployeeManager;

public class DaoTests {
private EmployeeDAO empDaoInst = EmployeeManager.getInst();
	@Test
	public void empDaoTest() {
		Employee emp = new Employee();
		emp.setFirstname("Harry");
		emp.setLastname("Smith");
		emp.setUsername("hsmith");
		emp.setPassword("pass");
		int pk = empDaoInst.save(emp);
		assertNotEquals(null, empDaoInst.getById(pk));
		empDaoInst.delete(emp);
		assertEquals(null, empDaoInst.getById(pk));
		
	}
}
