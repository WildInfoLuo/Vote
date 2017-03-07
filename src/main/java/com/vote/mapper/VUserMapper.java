package com.vote.mapper;

import java.util.List;

import com.vote.entity.VUser;

public interface VUserMapper {
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
	public List<VUser> login(VUser user);
}
