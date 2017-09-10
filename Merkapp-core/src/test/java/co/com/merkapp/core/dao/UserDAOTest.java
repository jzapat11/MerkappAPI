package co.com.merkapp.core.dao;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.com.merkapp.core.entity.MarketItem;
import co.com.merkapp.core.entity.User;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:application-context.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING) //This annotation is to run the test in a specific order.
public class UserDAOTest {
	
	@Autowired
	private UserDAO userDAO;	
	
	@Autowired
	private MarketItemDAO MarketItemDAO;
	
	@Test
	@Transactional
	@Rollback(false)
	public void test1insertUser(){
		User user = new User();
		user.setName("Juan David");
		user.setLastame("Zapata Calle");
		user.setEmail("jzapat11@gmail.com");
		user.setPassword("12345");
		
		int userID = userDAO.insertUser(user);
		
		//If id different to 0, then the record was inserted in DB.
		Assert.assertNotSame(0, userID);
	}
	
	@Test
	@Transactional
	@Rollback(false)
	public void test2integrateUserWithItemList(){
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

	@Test
	@Transactional
	public void test3LoginUser(){

		String user = "juan.zapata@globant.com";
		String password = "232455";
		User user_ = userDAO.getUser(user, password);

		System.out.println("ID Usuario: " + user_.getId());
		System.out.println("Nombre Usuario: " + user_.getName());

		Assert.assertNotNull(user_);
	}
}