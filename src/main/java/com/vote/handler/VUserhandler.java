package com.vote.handler;

import java.io.PrintWriter;
import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.vote.entity.WUser;
import com.vote.service.VUservice;
import com.vote.utils.PublicKeyMap;
import com.vote.utils.RSAUtils;
import com.vote.utils.SessionAttribute;

@Controller
@RequestMapping("/vuser")
@SessionAttributes(SessionAttribute.USERLOGIN)
public class VUserhandler implements Serializable {
	private static final long serialVersionUID = -4796156351894344700L;

	@Autowired
	private VUservice uservice;

	/**
	 * 用户登录
	 * 
	 * @param session:用户名验证session
	 * @return：登录页面
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String Login(WUser userLogin, BindingResult result, HttpServletRequest request, PrintWriter out,
			ModelMap map, HttpSession session) {
		// 如果有错误的话，那么将返回注册页面
		String pwd = RSAUtils.decryptStringByJs(userLogin.getVpwd());
		System.out.println(pwd);
		List<WUser> users = uservice.login(userLogin);
		if (users.size() > 0) {
			map.put(SessionAttribute.USERLOGIN, users.get(0));
			// LogManager.getLogger().debug("user==>" + userLogin);
			return "index";
		} else {
			map.put(SessionAttribute.LOGERRORMSG, "用户名或密码输入不正确");
			return "login";
		}
	}

	public String keyPair() {
		PublicKeyMap publicKeyMap = RSAUtils.getPublicKeyMap();
		System.out.println(publicKeyMap);
		return "login";
	}
}
