package com.revaturesocialmedia.controller;

import java.util.List;
import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revaturesocialmedia.beans.Employee;
import com.revaturesocialmedia.daos.EmployeeDAO;
import com.revaturesocialmedia.daos.EmployeeManager;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class SearchController {

	private ObjectMapper om = new ObjectMapper();
	private static Logger log = Logger.getLogger(SearchController.class);
	
	@Autowired
	private EmployeeDAO em;
	
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public List<Employee> getAll() {
		log.debug("Fetching employees from server.");
		List<Employee> employees = em.getAllHQL();
		for (Employee employee : employees) {
			log.debug(employee);
		}
		return employees;
	}
	
	@RequestMapping(value="/search/{id}", method=RequestMethod.GET)
	public Employee getEmployeeById(@PathVariable("id") int id) {
		log.debug("Fetch employee by ID");
		Employee e = em.getById(id);
		log.debug(e);
		return e;
	}
	
	@RequestMapping(value="/search/keyword={key}", method=RequestMethod.GET)
	public List<Employee> getEmployeesByKeyword(@PathVariable("key") String key) {
		log.debug("Fetch employee list by keyword");
		List<Employee> employees = em.getByKeyword(key);
		log.debug(employees);
		return employees;
	}
}
