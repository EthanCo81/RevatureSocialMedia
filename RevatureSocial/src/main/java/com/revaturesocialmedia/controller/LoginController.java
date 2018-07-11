package com.revaturesocialmedia.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revaturesocialmedia.beans.Client;
import com.revaturesocialmedia.beans.Employee;
import com.revaturesocialmedia.beans.Instructor;
import com.revaturesocialmedia.beans.User;
import com.revaturesocialmedia.services.LoginService;



@RestController
@CrossOrigin(origins="http://localhost:4200")
public class LoginController {
	private ObjectMapper om = new ObjectMapper();
	@Autowired
	private LoginService login;

	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String goLogin(HttpSession session) throws JsonProcessingException {
		System.out.println("get: login");
		if(session.getAttribute("user") !=null) {
			System.out.println(session.getAttribute("user"));
			return om.writeValueAsString(session.getAttribute("user"));
		}
		return null;
	}
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@RequestBody() UserPass up, HttpSession session) throws JsonProcessingException{	
		
		System.out.println(up.username+" "+up.password);
		User u = login.login(up.username, up.password);
		System.out.println(up.username+" "+up.password+" "+ u);
		if(u != null) {
			session.setAttribute("user", u);
			if(u instanceof Employee) {
				return "{\"employee\": "+om.writeValueAsString(session.getAttribute("user"))+"}";
			}
			if(u instanceof Client) {
				return "{\"client\": "+om.writeValueAsString(session.getAttribute("user"))+"}";
			}
			if(u instanceof Instructor) {
				return "{\"instructor\": "+om.writeValueAsString(session.getAttribute("user"))+"}";
			}
			return om.writeValueAsString(session.getAttribute("user"));
		}else {
			return null;
		}
		
	}
	
	
	
	
	public LoginService getLogin() {
		return login;
	}

	public void setLogin(LoginService login) {
		this.login = login;
	}
	
	

	
	
}
@Component
class UserPass {
	String username;
	String password;
	public UserPass() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserPass(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
