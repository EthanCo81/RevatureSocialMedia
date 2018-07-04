package com.revaturesocialmedia.tests;

import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import com.revaturesocialmedia.services.LoginService;

public class ServicesTest {
	
	
	@Test
	public void loginServiceTest() {
		LoginService ls = LoginService.getInst();
		assertNotEquals(null, ls.login("gsmith", "pass"));
	}
}
