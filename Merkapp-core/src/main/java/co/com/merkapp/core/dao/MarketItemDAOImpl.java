package co.com.merkapp.core.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import co.com.merkapp.core.entity.MarketItem;

@Component
@Repository
public class MarketItemDAOImpl implements MarketItemDAO{

	@PersistenceContext
	private EntityManager entityManager;

	public int insertItem(MarketItem marketItem) {
		entityManager.persist(marketItem);
		entityManager.flush();
		
		return marketItem.getId();
	}
	
	

}
