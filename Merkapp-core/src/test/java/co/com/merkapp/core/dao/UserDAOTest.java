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
	public void test2LoginUser(){

		String user = "jzapat11@gmail.com";
		String password = "12345";
		User user_ = userDAO.getUser(user, password);

		System.out.println("ID Usuario: " + user_.getId());
		System.out.println("Nombre Usuario: " + user_.getName());

		Assert.assertNotNull(user_);
	}

	@Test
	@Transactional
	@Rollback(false)
	public void test3integrateUserWithItemList(){

		//Loading user to set market items to.
		String user = "jzapat11@gmail.com";
		String password = "12345";
		User user_ = userDAO.getUser(user, password);
		user_.setName("Lina Marcela");
		user_.setLastame("Parra Zuniga");

		List<MarketItem> marketItems = new ArrayList<MarketItem>();

		//Inserting first the marketItem
		MarketItem marketItem = new MarketItem();
		marketItem.setItem("Azucar");
		marketItems.add(marketItem);
		//This will update user and create record in marketList table.
		user_.addMarketItem(marketItem);

		marketItem = new MarketItem();
		marketItem.setItem("Sal");
		marketItems.add(marketItem);
		//This will update user and create record in marketList table.
		user_.addMarketItem(marketItem);
	}

	@Test
	@Transactional
	public void test4LoginUser(){

		String user = "jzapat11@gmail.com";
		String password = "12345";
		User user_ = userDAO.getUser(user, password);

		System.out.println("ID Usuario: " + user_.getId());
		System.out.println("Nombre Usuario: " + user_.getName());

		System.out.println("Lista de Item de mercado; " + user_.getItemList().size());

		Assert.assertNotNull(user_);
	}
}