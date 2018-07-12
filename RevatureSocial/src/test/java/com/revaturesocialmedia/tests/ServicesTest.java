package com.revaturesocialmedia.tests;

import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revaturesocialmedia.services.LoginService;
import com.revaturesocialmedia.services.ProfileService;

@Component
public class ServicesTest {
	@Autowired
	private LoginService ls = new LoginService();
	
	@Autowired
	private ProfileService ps = new ProfileService();
	
	@Test
	public void loginServiceTest() {
		assertNotEquals(null, ls.login("gsmith", "pass"));
	}
	
	@Test
	public void ProfileServiceTest() {
		assertNotEquals(null, ps.getEmpProfile(2523));
	}
}
