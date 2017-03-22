package com.vote.service;

import java.util.List;

import com.vote.entity.WUser;

public interface VUservice {
	/**
	 * 用户注册
	 * 
	 * @param user
	 * @return
	 */
	public int register(WUser user);

	/**
	 * 用户登录
	 * 
	 * @param user
	 * @return
	 */
	public List<WUser> login(WUser user);
}
