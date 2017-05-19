package com.vote.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vote.entity.VUser;
import com.vote.service.VUservice;

@Controller
@RequestMapping("/admin")
public class VAdminhandler {
	@Autowired
	private VUservice uservice;

	@ResponseBody
	@RequestMapping(value = "/findAllUsersByPages", method = RequestMethod.POST)
	public List<VUser> findAllUsersByPages() {
		return uservice.findAllUsersByPages();
	}
}
