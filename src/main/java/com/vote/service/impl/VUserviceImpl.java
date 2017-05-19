package com.vote.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vote.entity.VUser;
import com.vote.mapper.VUserMapper;
import com.vote.service.VUservice;

@Service("vUService")
public class VUserviceImpl implements VUservice {

	@Autowired
	private VUserMapper vmapper;

	@Override
	public int register(VUser user) {
		return vmapper.register(user);
	}

	@Override
	public VUser login(VUser user) {
		return vmapper.login(user);
	}

	@Override
	public String selectPhone(String phone) {
		return vmapper.selectPhone(phone);
	}

	@Override
	public List<VUser> findAllUsersByPages() {
		return vmapper.findAllUsersByPages();
	}

}
