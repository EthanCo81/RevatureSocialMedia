package com.revaturesocialmedia.daos;

import java.util.List;
import com.revaturesocialmedia.beans.Answer;

public interface AnswerDAO {

	//CREATE
	int save(Answer a);
	Answer persist(Answer a);
	
	//READ
	List<Answer> getAllHQL();
	List<Answer> getAllCriteria();
	Answer getById(int i);
	Answer loadById(int i);
	
	//UPDATE
	Answer update(Answer a);
	Answer merge(Answer a);
	void updateHQL();
	
	//DELETE
	void delete(Answer a);
}
