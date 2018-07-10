package com.revaturesocialmedia.daos;

import java.util.List;

import com.revaturesocialmedia.beans.ForumPost;

public interface ForumPostDAO {
	

		//CREATE
		int save(ForumPost fp);
		ForumPost persist(ForumPost fp);
		
		//READ
		List<ForumPost> getAllHQL();
		List<ForumPost> getAllCriteria();
		ForumPost getById(int i);
		ForumPost loadById(int i);
		
		//UPDATE
		ForumPost update(ForumPost fp);
		ForumPost merge(ForumPost fp);
		void updateHQL();
		
		//DELETE
		void delete(ForumPost fp);

}
