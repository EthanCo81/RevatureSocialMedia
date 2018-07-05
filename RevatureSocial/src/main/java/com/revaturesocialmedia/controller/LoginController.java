package com.revaturesocialmedia.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revaturesocialmedia.beans.User;
import com.revaturesocialmedia.services.LoginService;


@RestController
@Controller
@RequestMapping(value="/login")
public class LoginController {
	
	@Autowired
	private LoginService login;

	@RequestMapping(method=RequestMethod.GET)
	public String goLogin(HttpSession session) {
		if(session.getAttribute("user") !=null) {
			return "home";
		}
		return "Static/login.html";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String login(String username, String password, HttpSession session){	
		User u = login.login(username, password);
		if(u != null) {
			session.setAttribute("user", u);
			return "redirect: home";
		}else {
			return "login";
		}
		
	}
	
	
	
	
	public LoginService getLogin() {
		return login;
	}

	public void setLogin(LoginService login) {
		this.login = login;
	}

	
	
}
