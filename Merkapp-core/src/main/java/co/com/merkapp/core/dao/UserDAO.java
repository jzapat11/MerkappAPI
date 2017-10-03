package co.com.merkapp.core.dao;

import co.com.merkapp.core.entity.User;

public interface UserDAO {
	
	/**
	 * Inserts a new user in the database.
	 * @param user
	 */
	public int insertUser(User user);

	/**
	 * Getting the info to login to the app.
	 * @param email
	 * @param password
	 * @return
	 */
	public User getUser(String email, String password);


	/**
	 * Method to update the user
	 * @param user
	 */
	public User updateUser(User user);
	
}
