package com.revaturesocialmedia.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.revaturesocialmedia.beans.Client;
import com.revaturesocialmedia.beans.Employee;
import com.revaturesocialmedia.beans.Instructor;
import com.revaturesocialmedia.daos.ClientDAO;
import com.revaturesocialmedia.daos.ClientManager;
import com.revaturesocialmedia.daos.EmployeeDAO;
import com.revaturesocialmedia.daos.InstructorDAO;
import com.revaturesocialmedia.daos.InstructorManager;

public class ProfileService {
	
	@Autowired
	private EmployeeDAO empDaoInst;
	@Autowired
	private InstructorDAO instructorDaoInst;
	@Autowired
	private ClientDAO clientDaoInst;
	
	public Employee getEmpProfile(int id) {
		Employee emp = null;
		emp = empDaoInst.getById(id);
		return emp;
	}
	
	public Instructor getInstProfile(int id) {
		Instructor ins = null;
		ins = instructorDaoInst.getById(id);
		return ins;
	}
	
	public Client getClientProfile(int id) {
		Client cln = null;
		cln = clientDaoInst.getById(id);
		return cln;
	}
	
	public void updateEmpProfile (Employee e) {
		empDaoInst.save(e);
	}
	
	public void updateInstProfile (Instructor i) {
		instructorDaoInst.save(i);
	}
	
	public void updateClientProfile (Client c) {
		clientDaoInst.save(c);
	}

}
