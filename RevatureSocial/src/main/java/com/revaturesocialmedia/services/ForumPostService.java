package com.revaturesocialmedia.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revaturesocialmedia.beans.ForumPost;
import com.revaturesocialmedia.daos.ForumPostDAO;


@Service
public class ForumPostService {
	@Autowired
	private ForumPostDAO fpDaoInst;

	public ForumPost submitPost(ForumPost fp) {
		
//		fp = fpDaoInst.submitQuestion(fp);
//		if(u==null) u = instructorDaoInst.login(username, password);
//		if(u==null) u = clientDaoInst.login(username, password);
//		return u;
		fp.setDatePosted(new Date(System.currentTimeMillis()).toString());
		fpDaoInst.save(fp);
		return fp;
	}
	
	public ForumPost updateForumPost(ForumPost fp) {
		fpDaoInst.update(fp);
		return fp;
	}
	
	public List<ForumPost> getCurrentPosts(){
		System.out.println("ForumServices");
		return fpDaoInst.getAllCriteria();
	}
	
}
