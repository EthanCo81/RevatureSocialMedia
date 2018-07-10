package com.revaturesocialmedia.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revaturesocialmedia.beans.ForumPost;
import com.revaturesocialmedia.services.ForumPostService;


@RestController
@CrossOrigin(origins="http://localhost:4200")
public class ForumPostController {
//	private ObjectMapper om = new ObjectMapper();
//	@Autowired
//	private LoginService login;
//	
//	
//
//	@RequestMapping(value="/login", method=RequestMethod.GET)
//	public String goLogin(HttpSession session) throws JsonProcessingException {
//		System.out.println("get: login");
//		if(session.getAttribute("user") !=null) {
//			return om.writeValueAsString(session.getAttribute("user"));
//		}
//		return "no user found";
//	}
//	
//	@RequestMapping(value="/login", method=RequestMethod.POST)
//	public String login(String username, String password, HttpSession session) throws JsonProcessingException{	
//		
//		System.out.println(username+" "+password);
//		User u = login.login(username, password);
//		System.out.println(username+" "+password+" "+ u);
//		if(u != null) {
//			session.setAttribute("user", u);
//			return om.writeValueAsString(session.getAttribute("user"));
//		}else {
//			return null;
//		}
//		
//	}
//	
//	
//	
//	
//	public LoginService getLogin() {
//		return login;
//	}
//
//	public void setLogin(LoginService login) {
//		this.login = login;
//	}

	
	
}
