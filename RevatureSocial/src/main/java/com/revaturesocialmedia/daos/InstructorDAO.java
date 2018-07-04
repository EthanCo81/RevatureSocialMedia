package com.revaturesocialmedia.daos;

import java.util.List;

import com.revaturesocialmedia.beans.Instructor;
import com.revaturesocialmedia.beans.User;

public interface InstructorDAO {

	//CREATE
	int save(Instructor in);
	Instructor persist(Instructor in);
	
	//READ
	List<Instructor> getAllHQL();
	List<Instructor> getAllCriteria();
	Instructor getById(int i);
	Instructor loadById(int i);
	Instructor login(String username, String password);
	
	//UPDATE
	Instructor update(Instructor in);
	Instructor merge(Instructor in);
	void updateHQL();
	
	//DELETE
	void delete(Instructor in);
	

}
