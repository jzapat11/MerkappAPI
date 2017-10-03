package co.com.merkapp.core.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import co.com.merkapp.core.entity.User;

import java.util.ArrayList;
import java.util.List;

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

	public User getUser(String email, String password){

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
		Root<User> from = criteriaQuery.from(User.class);

		//Setting the criteria parameters for the query
		List<Predicate> criteriaParameters = new ArrayList<Predicate>();
		criteriaParameters.add(criteriaBuilder.equal(from.get("email"), email));
		criteriaParameters.add(criteriaBuilder.equal(from.get("password"), password));

		//Creating the query.
		criteriaQuery.select(from);
		criteriaQuery.where(criteriaParameters.toArray(new Predicate[]{}));

		return entityManager.createQuery(criteriaQuery).getSingleResult();
	}

	public User updateUser(User user) {
		User userUpdated = (User)entityManager.merge(user);
		return userUpdated;
	}
}
