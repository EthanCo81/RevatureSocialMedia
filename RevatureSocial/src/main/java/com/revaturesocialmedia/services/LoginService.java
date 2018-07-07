package com.revaturesocialmedia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revaturesocialmedia.beans.User;
import com.revaturesocialmedia.daos.ClientDAO;
import com.revaturesocialmedia.daos.EmployeeDAO;
import com.revaturesocialmedia.daos.InstructorDAO;


@Service
public class LoginService {
	@Autowired
	private EmployeeDAO empDaoInst;
	
	@Autowired
	private ClientDAO clientDaoInst;
	
	@Autowired
	private InstructorDAO instructorDaoInst;


	public User login(String username, String password) {
		User u = null;
		u = empDaoInst.login(username, password);
		if(u==null) u = instructorDaoInst.login(username, password);
		if(u==null) u = clientDaoInst.login(username, password);
		return u;
	}
}
