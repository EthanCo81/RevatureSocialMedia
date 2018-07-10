package com.revaturesocialmedia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revaturesocialmedia.beans.ForumPost;
import com.revaturesocialmedia.daos.ForumPostDAO;


@Service
public class ForumPostService {
	@Autowired
	private ForumPostDAO fpDaoInst;

//	public ForumPost submitPost(String nameofPoster, String datePosted, String questionTitle, 
//			String relevantLanguages, String relevantTechnologies, String description, String likes, String comments) {
//		ForumPost fp = null;
//		fp = fpDaoInst.submitQuestion(username, password);
//		if(u==null) u = instructorDaoInst.login(username, password);
//		if(u==null) u = clientDaoInst.login(username, password);
//		return u;
//	}
}
