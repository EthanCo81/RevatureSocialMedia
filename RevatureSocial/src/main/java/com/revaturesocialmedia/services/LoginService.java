package com.revaturesocialmedia.services;

import com.revaturesocialmedia.beans.User;
import com.revaturesocialmedia.daos.ClientDAO;
import com.revaturesocialmedia.daos.ClientManager;
import com.revaturesocialmedia.daos.EmployeeDAO;
import com.revaturesocialmedia.daos.EmployeeManager;
import com.revaturesocialmedia.daos.InstructorDAO;
import com.revaturesocialmedia.daos.InstructorManager;

public class LoginService {
	private static final EmployeeDAO empDaoInst = EmployeeManager.getInst();
	private static final ClientDAO clientDaoInst = ClientManager.getInst();
	private static final InstructorDAO instructorDaoInst = InstructorManager.getInst();
	private static LoginService inst =null;
	
	private LoginService() {}
	
	public static LoginService getInst() {
		if(inst==null) inst = new LoginService();
		return inst;
	}

	public User login(String username, String password) {
		User u = null;
		u = empDaoInst.login(username, password);
		if(u==null) u = instructorDaoInst.login(username, password);
		if(u==null) u = clientDaoInst.login(username, password);
		return u;
	}
}
