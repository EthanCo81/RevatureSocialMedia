package com.revaturesocialmedia.services;

import com.revaturesocialmedia.beans.Client;
import com.revaturesocialmedia.beans.Employee;
import com.revaturesocialmedia.beans.Instructor;
import com.revaturesocialmedia.beans.User;
import com.revaturesocialmedia.daos.ClientDAO;
import com.revaturesocialmedia.daos.ClientManager;
import com.revaturesocialmedia.daos.EmployeeDAO;
import com.revaturesocialmedia.daos.EmployeeManager;
import com.revaturesocialmedia.daos.InstructorDAO;
import com.revaturesocialmedia.daos.InstructorManager;

public class ProfileService {
	
	private static final EmployeeDAO empDaoInst = EmployeeManager.getInst();
	private static final InstructorDAO instructorDaoInst = InstructorManager.getInst();
	private static final ClientDAO clientDaoInst = ClientManager.getInst();
	
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
