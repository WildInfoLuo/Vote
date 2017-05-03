package com.vote.service;

import com.vote.entity.VUser;

public interface VUservice {
	/**
	 * 用户注册
	 * 
	 * @param user
	 * @return
	 */
	public int register(VUser user);

	/**
	 * 用户登录
	 * 
	 * @param user
	 * @return
	 */
	public VUser login(VUser user);

	/**
	 * 查询是否存在该用户
	 * 
	 * @param phone
	 * @return
	 */
	public String selectPhone(String phone);
}
