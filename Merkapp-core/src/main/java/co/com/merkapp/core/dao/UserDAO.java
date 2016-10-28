package co.com.merkapp.core.dao;

import co.com.merkapp.core.entity.User;

public interface UserDAO {
	
	/**
	 * Inserts a new user in the database.
	 * @param user
	 */
	public int insertUser(User user);
	
}
