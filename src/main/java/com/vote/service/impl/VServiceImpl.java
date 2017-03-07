package com.vote.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vote.entity.VUser;
import com.vote.mapper.VUserMapper;
import com.vote.service.VService;

@Service("vCUserService")
public class VServiceImpl implements VService {

	@Autowired
	private VUserMapper vmapper;

	@Override
	public int register(VUser user) {
		return vmapper.register(user);
	}

	@Override
	public List<VUser> login(VUser user) {
		return null;
	}

}
