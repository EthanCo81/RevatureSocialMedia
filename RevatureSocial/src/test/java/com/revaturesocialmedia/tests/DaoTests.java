package com.revaturesocialmedia.tests;

import java.util.Iterator;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import org.apache.log4j.Logger;
import com.revaturesocialmedia.beans.Client;
import com.revaturesocialmedia.beans.Employee;
import com.revaturesocialmedia.beans.Instructor;
import com.revaturesocialmedia.daos.ClientDAO;
import com.revaturesocialmedia.daos.ClientManager;
import com.revaturesocialmedia.daos.EmployeeDAO;
import com.revaturesocialmedia.daos.EmployeeManager;
import com.revaturesocialmedia.daos.InstructorDAO;
import com.revaturesocialmedia.daos.InstructorManager;
import com.revaturesocialmedia.util.HibernateUtil;

public class DaoTests {
	
	private static Logger log = Logger.getLogger(DaoTests.class);
	
	EmployeeDAO ed = EmployeeManager.getInst();
	ClientDAO cd = ClientManager.getInst();
	InstructorDAO id = InstructorManager.getInst();
	
	@BeforeClass
	public static void setupDaoTests() {
		log.trace("Setting up tests-----------------------------------------------");
		
		// not really necessary, maybe a bad idea,
		// wanted to keep connecting to the db separate from the first test
		HibernateUtil.getInstance().getSession();
	}
	
	/* testEmployeeQueries()
	 * Tests to see if the getAllHQL() function in the EmployeeManager class is working appropriately.
	 * Additional query testing to be added as implemented.
	 * Should print the first name of every employee in the database to the console.
	 * At the moment this needs to be verified manually.
	 */
	@Test
	public void testEmployeeGetAll() {
		log.debug("Testing Employee getAllHQL-----------------------------------------------------");
		
		List<Employee> employees;
		employees = ed.getAllHQL();
		
		for (Iterator<Employee> iterator = employees.iterator(); iterator.hasNext();) {
			Employee ee = (Employee) iterator.next();
			log.debug("First name: " + ee.getFirstname());
		}
	}
	
	@Test
	public void testEmployeeGetAllCriteria() {
		log.debug("Testing Employee getAllCriteria-----------------------------------------------------");
		
		List<Employee> employees;
		employees = ed.getAllCriteria();
		
		for (Iterator<Employee> iterator = employees.iterator(); iterator.hasNext();) {
			Employee ee = (Employee) iterator.next();
			log.debug("First name: " + ee.getFirstname());
		}
	}
	
	
	/* testEmployeeGetByKeyword()
	 * Tests to see if we can retrieve an employee from the db via a keyword.
	 * Should print the first name of employees which match.
	 * Currently hard coded to find employee with keyword "Test".
	 */
	@Test
	public void testEmployeeGetByKeyword() {
		log.debug("Testing Employee getByKeyword-----------------------------------------------------");
		
		List<Employee> employees;
		employees = ed.getByKeyword("Test");
		
		for (Iterator<Employee> iterator = employees.iterator(); iterator.hasNext();) {
			Employee ee = (Employee) iterator.next();
			log.debug("First name: " + ee.getFirstname());
		}
	} 
	
	@Test
	public void testEmployeeGetByKeywordCriteria() {
		log.debug("Testing Employee getByKeywordCriteria-----------------------------------------------------");
		
		List<Employee> employees;
		employees = ed.getByKeywordCriteria("Test");
		
		for (Iterator<Employee> iterator = employees.iterator(); iterator.hasNext();) {
			Employee ee = (Employee) iterator.next();
			log.debug("First name: " + ee.getFirstname());
		}
	} 
	
	@Test
	public void testClientGetAll() {
		log.debug("Testing Client getAllHQL-----------------------------------------------------");
		
		List<Client> clients;
		clients = cd.getAllHQL();
		
		for (Iterator<Client> iterator = clients.iterator(); iterator.hasNext();) {
			Client ee = (Client) iterator.next();
			log.debug("First name: " + ee.getFirstname());
		}
	}
	
	@Test
	public void testInstructorGetAll() {
		log.debug("Testing Instructor getAllHQL-----------------------------------------------------");
		
		List<Instructor> instructors;
		instructors = id.getAllHQL();
		
		for (Iterator<Instructor> iterator = instructors.iterator(); iterator.hasNext();) {
			Instructor ee = (Instructor) iterator.next();
			log.debug("First name: " + ee.getFirstname());
		}
	}
}
