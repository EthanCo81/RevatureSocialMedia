package com.revaturesocialmedia.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revaturesocialmedia.beans.Client;
import com.revaturesocialmedia.beans.Employee;
import com.revaturesocialmedia.beans.Instructor;
import com.revaturesocialmedia.services.ProfileService;

@Controller
@CrossOrigin(origins="http://localhost:4200")
public class ProfileController {
	private ObjectMapper om = new ObjectMapper();
	@Autowired
	private ProfileService profile;
	
	
	@RequestMapping(value="/employee_profile/{id}", method=RequestMethod.GET)
	public Employee getEmployee(@RequestParam("id") int id) {
		return profile.getEmpProfile(id);
	}
	
	@RequestMapping(value="/instructor_profile/{id}", method=RequestMethod.GET)
	public Instructor getInstructor(@RequestParam("id") int id) {
		return profile.getInstProfile(id);
	}
	
	@RequestMapping(value="/client_profile/{id}", method=RequestMethod.GET)
	public Client getClient(@RequestParam("id") int id) {
		return profile.getClientProfile(id);
	}
	
	@RequestMapping(value="/employee_profile/{id}", method=RequestMethod.PUT)
	public void updateEmployee(@RequestParam("id") int id, HttpServletRequest request, @ModelAttribute("employee") Employee e) {
		profile.updateEmpProfile(e);
	}
	
	@RequestMapping(value="/instructor_profile/{id}", method=RequestMethod.PUT)
	public void updateInstructor(@RequestParam("id") int id, HttpServletRequest request, @ModelAttribute("instructor") Instructor i) {
		profile.updateInstProfile(i);
	}
	
	@RequestMapping(value="/client_profile/{id}", method=RequestMethod.PUT)
	public void updateClient(@RequestParam("id") int id, HttpServletRequest request, @ModelAttribute("client") Client c) {
		profile.updateClientProfile(c);
	}
}
