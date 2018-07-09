package com.revaturesocialmedia.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revaturesocialmedia.beans.Client;
import com.revaturesocialmedia.beans.Employee;
import com.revaturesocialmedia.beans.Instructor;
import com.revaturesocialmedia.services.ProfileService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class ProfileController {
	private ObjectMapper om = new ObjectMapper();
	@Autowired
	private ProfileService profile;
	
	
	@RequestMapping(value="/employee_profile/{id}", method=RequestMethod.GET)
	public Employee getEmployee(@PathVariable("id") int id) {
		System.out.println("Employee Profile Getter");
		return profile.getEmpProfile(id);
	}
	
	@RequestMapping(value="/instructor_profile/{id}", method=RequestMethod.GET)
	public Instructor getInstructor(@PathVariable("id") int id) {
		return profile.getInstProfile(id);
	}
	
	@RequestMapping(value="/client_profile/{id}", method=RequestMethod.GET)
	public Client getClient(@PathVariable("id") int id) {
		return profile.getClientProfile(id);
	}
	
	@RequestMapping(value="/employee_profile/{id}", method=RequestMethod.PUT)
	public @ResponseBody Employee updateEmployee(@PathVariable("id") String id, HttpServletRequest request, @RequestBody Employee e) {
		profile.updateEmpProfile(e);
		return e;
	}
	
	@RequestMapping(value="/instructor_profile/{id}", method=RequestMethod.PUT)
	public @ResponseBody Instructor updateInstructor(@PathVariable("id") String id, HttpServletRequest request, @RequestBody Instructor i) {
		profile.updateInstProfile(i);
		return i;
	}
	
	@RequestMapping(value="/client_profile/{id}", method=RequestMethod.PUT)
	public @ResponseBody Client updateClient(@PathVariable("id") String id, HttpServletRequest request, @RequestBody Client c) {
		profile.updateClientProfile(c);
		return c;
	}
}
