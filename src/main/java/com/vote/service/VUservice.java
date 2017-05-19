package com.vote.service;

import java.util.List;

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
	
	/**
	 * 查询所有用户
	 * @return
	 */
	public List<VUser> findAllUsersByPages();
}
