package com.wild.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vote.entity.WUser;
import com.vote.service.VUservice;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class ConnTest {

	@Autowired
	private VUservice vservice;

	@Test
	public void testRegister() {
		int user = vservice.register(new WUser("Luodawei","a",2, 0));
		System.out.println("用户名为：" + user);
	}
}
