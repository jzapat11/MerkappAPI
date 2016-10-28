package co.com.merkapp.core.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import co.com.merkapp.core.entity.User;

@Component
@Repository
public class UserDAOImpl implements UserDAO{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public int insertUser(User user) {
		
		entityManager.persist(user);
		entityManager.flush();
		
		return user.getId();
	}

}
