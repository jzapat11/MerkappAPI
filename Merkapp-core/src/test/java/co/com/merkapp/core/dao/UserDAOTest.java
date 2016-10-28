package co.com.merkapp.core.dao;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.com.merkapp.core.entity.MarketItem;
import co.com.merkapp.core.entity.User;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:application-context.xml"})
public class UserDAOTest {
	
	@Autowired
	private UserDAO userDAO;	
	
	@Autowired
	private MarketItemDAO MarketItemDAO;
	
	@Test
	@Transactional
	//@Rollback(false)
	public void insertUser(){
		User user = new User();
		user.setName("Juan David");
		user.setLastame("Zapata Calle");
		user.setEmail("juan.zapata@globant.com");
		user.setPassword("232455");
		
		int userID = userDAO.insertUser(user);
		
		//If id different to 0, then the register was inserted in DB.
		Assert.assertNotSame(0, userID);
	}
	
	@Test
	@Transactional
	//@Rollback(false)
	public void integrateUserWithItemList(){
		List<MarketItem> marketItems = new ArrayList<MarketItem>();
		
		//Inserting first the marketItem
		MarketItem marketItem = new MarketItem();
		marketItem.setItem("Azucar");
		marketItems.add(marketItem);
		
		marketItem = new MarketItem();
		marketItem.setItem("Sal");
		marketItems.add(marketItem);		
				
		//Inserting then the user.
		User user = new User();
		user.setName("Juan David");
		user.setLastame("Zapata Calle");
		user.setEmail("juan.zapata@globant.com");
		user.setPassword("232455");
		user.setItemList(marketItems);
		int userID= userDAO.insertUser(user);
		System.out.println("USER ID: " + userID);
		Assert.assertNotSame(0, userID);		
	}
}