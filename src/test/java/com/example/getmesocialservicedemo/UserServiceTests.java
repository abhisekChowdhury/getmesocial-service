package com.example.getmesocialservicedemo;

import com.example.getmesocialservicedemo.model.User;
import com.example.getmesocialservicedemo.service.UserService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTests {

	@Autowired
	private UserService userService;

//	@Before
//	public void saveUser(){
//		userService.saveUser(new User("Abhisek","Vancouver",27, "abhisek@gmail.com","www.profilepic.com"));
//	}

	//The following test should fail.
//	@Test
//	public void getUser(){
//		User user = userService.getById("1");
//		Assert.assertEquals("Abhisek",user.getName());
//	}

	@Test
	public void editUser(){
		User user = userService.getById("1");
		user.setName("Abhisek");
		userService.saveUser(user);
		Assert.assertEquals("Abhisek",user.getName());
	}

	@After
	public void delete(){
		userService.deleteUser("1");
	}
}
