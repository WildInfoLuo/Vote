package com.wild.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vote.entity.VUser;
import com.vote.service.VService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class ConnTest {

	@Autowired
	private VService vservice;

	@Test
	public void testRegister() {
		int user = vservice.register(new VUser("Luodawei","a",2, 0));
		System.out.println("用户名为：" + user);
	}
}
