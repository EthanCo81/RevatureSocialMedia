package com.revaturesocialmedia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revaturesocialmedia.beans.ForumPost;
import com.revaturesocialmedia.daos.ForumPostDAO;


@Service
public class ForumPostService {
	@Autowired
	private ForumPostDAO fpDaoInst;

	public ForumPost submitPost(String nameOfPoster, String datePosted, String questionTitle, 
			String relevantLanguages, String relevantTechnologies, String description, String likes, String comments) {
		ForumPost fp = new ForumPost();
		fp.setNameOfPoster(nameOfPoster);
		fp.setDatePosted(datePosted);
		fp.setQuestionTitle(questionTitle);
		fp.setRelevantLanguages(relevantLanguages);
		fp.setRelevantTechnologies(relevantTechnologies);
		fp.setDescription(description);
		fp.setLikes(likes);
		
//		fp = fpDaoInst.submitQuestion(fp);
//		if(u==null) u = instructorDaoInst.login(username, password);
//		if(u==null) u = clientDaoInst.login(username, password);
//		return u;
		
		fpDaoInst.update(fp);
		return fp;
	}
	
	public ForumPost updateForumPost(ForumPost fp) {
		fpDaoInst.update(fp);
		return fp;
	}
	
}
