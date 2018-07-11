package com.revaturesocialmedia.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revaturesocialmedia.beans.ForumPost;
import com.revaturesocialmedia.services.ForumPostService;


@RestController
@CrossOrigin(origins="http://localhost:4200")
public class ForumPostController {
	private ObjectMapper om = new ObjectMapper();
	@Autowired
	private ForumPostService fpService;

	@RequestMapping(value="/createpost", method=RequestMethod.POST)
	public @ResponseBody ForumPost submitForumPost(@PathVariable("id") int id, HttpServletRequest request, @RequestBody ForumPost fp) {
		fpService.updateForumPost(fp);
		return fp;
	}
}
