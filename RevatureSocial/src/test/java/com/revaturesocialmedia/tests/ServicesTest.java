package com.revaturesocialmedia.tests;

import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revaturesocialmedia.services.LoginService;

@Component
public class ServicesTest {
	@Autowired
	private LoginService ls = new LoginService();
	
	@Test
	public void loginServiceTest() {
		assertNotEquals(null, ls.login("gsmith", "pass"));
	}
}
