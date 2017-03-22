package com.vote.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vote.entity.WUser;
import com.vote.mapper.VUserMapper;
import com.vote.service.VUservice;

@Service("vUService")
public class VUserviceImpl implements VUservice {

	@Autowired
	private VUserMapper vmapper;

	@Override
	public int register(WUser user) {
		return vmapper.register(user);
	}

	@Override
	public List<WUser> login(WUser user) {
		return null;
	}

}
