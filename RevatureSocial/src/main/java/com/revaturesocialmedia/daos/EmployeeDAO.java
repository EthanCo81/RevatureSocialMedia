package com.revaturesocialmedia.daos;

import java.util.List;

import com.revaturesocialmedia.beans.Employee;
import com.revaturesocialmedia.beans.User;

public interface EmployeeDAO {
	

		//CREATE
		int save(Employee e);
		Employee persist(Employee e);
		
		//READ
		
		/* getAllHQL()
		 * Retrieves all employees from the database
		 * @return List<Employee> the list of all employees in the db.
		 */
		List<Employee> getAllHQL();
		
		/* getAllCriteria()
		 * retrieves all employees from db using javax persistence criteria
		 * hibernate criteria stuff is deprecated
		 * @return List<Employee> the list of all employees in the db
		 */
		List<Employee> getAllCriteria();
		
		/* getByKeyword(String s)
		 * Retrieves all employees with a match related to parameter.
		 * @param String the keyword to search
		 * @return List<Employee> the list of all employees which match keyword
		 */
		List<Employee> getByKeyword(String s);
		
		/* getByKeywordCriteria(String s)
		 * Retrieves all employees with a match related to parameter.
		 * Does this using javax persistence criteria since hibernate deprecates everything.
		 * @param String the keyword to search
		 * @return List<Employee> the list of all employees which match keyword
		 */
		List<Employee> getByKeywordCriteria(String s);
		
		Employee getById(int i);
		Employee loadById(int i);
		Employee login(String username, String password);
		
		//UPDATE
		Employee update(Employee e);
		Employee merge(Employee e);
		void updateHQL();
		
		//DELETE
		void delete(Employee e);
		
	

}
