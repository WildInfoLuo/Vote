package com.vote.handler;

import java.io.PrintWriter;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.vote.entity.VUser;
import com.vote.enums.UserStatusEnum;
import com.vote.service.VUservice;
import com.vote.utils.CouldMessage;
import com.vote.utils.PublicKeyMap;
import com.vote.utils.RSAUtils;
import com.vote.utils.SessionAttribute;
import com.vote.utils.UUIDUtil;

@Controller
@RequestMapping("/vuser")
public class VUserhandler {

	@Autowired
	private VUservice uservice;

	/**
	 * 用户登录
	 * 
	 * @param session:用户名验证session
	 * @return：登录页面
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String Login(VUser userLogin, BindingResult result, HttpServletRequest request, PrintWriter out,
			ModelMap map, HttpSession session) {
		// 如果有错误的话，那么将返回注册页面
		String pwd = RSAUtils.decryptStringByJs(userLogin.getVpwd());
		System.out.println(pwd);
		List<VUser> users = uservice.login(userLogin);
		if (users.size() > 0) {
			map.put(SessionAttribute.USERLOGIN, users.get(0));
			// LogManager.getLogger().debug("user==>" + userLogin);
			return "index";
		} else {
			map.put(SessionAttribute.LOGERRORMSG, "用户名或密码输入不正确");
			return "login";
		}
	}

	/**
	 * 生成密钥
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/produceRas", method = RequestMethod.POST)
	public void keyPair(PrintWriter out) {
		PublicKeyMap publicKeyMap = RSAUtils.getPublicKeyMap();// 生成公钥
		Gson gson = new Gson();
		out.println(gson.toJson(publicKeyMap));
		out.flush();
		out.close();
	}

	/**
	 * 进行注册
	 * 
	 * @param out
	 * @param request
	 */
	@RequestMapping(value = "/getKeyMap", method = RequestMethod.POST)
	public String getKeyMap(PrintWriter out, HttpServletRequest request) {
		VUser user = new VUser();
		String phone = request.getParameter("phoneId");// 手机号码
		String userName = request.getParameter("userName");// 用户名
		// 生成密钥
		String encrypttext = request.getParameter("getMapKey");// 前台密文
		String vpwd = RSAUtils.decryptStringByJs(encrypttext);
		
		user.setVuId(UUIDUtil.createUUID());
		user.setVname(userName);
		user.setVpwd(vpwd);
		user.setPhone(phone);
		user.setVersion(0);
		user.setVuStatus(UserStatusEnum.normal);// 用户正常

		int result = uservice.register(user);
		if (result < 0) {// 如果注册失败
			return "register";
		}
		return "reg_success";
	}

	/**
	 * 获取电话号码得出验证码
	 * 
	 * @param user
	 * @param out
	 */
	@RequestMapping(value = "/message", method = RequestMethod.POST)
	public void MessageResiter(PrintWriter out, HttpServletRequest request, HttpSession session) {
		CouldMessage cl = new CouldMessage();
		String tel = request.getParameter("tel");
		String num = getCharAndNumr(6);
		session.setAttribute(SessionAttribute.TELRLOGIN, num);
		cl.CouldMessageContent(tel, num);
		Gson gson = new Gson();
		out.println(gson.toJson(num));
		out.flush();
		out.close();
	}

	/**
	 * java生成随机数字和字母组合
	 * 
	 * @param length[生成随机数的长度]
	 * @return
	 */
	public String getCharAndNumr(int length) {
		String val = "";
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			// 输出字母还是数字
			String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
			// 字符串
			if ("char".equalsIgnoreCase(charOrNum)) {
				// 取得大写字母还是小写字母
				int choice = random.nextInt(2) % 2 == 0 ? 65 : 97;
				val += (char) (choice + random.nextInt(26));
			} else if ("num".equalsIgnoreCase(charOrNum)) { // 数字
				val += String.valueOf(random.nextInt(10));
			}
		}
		return val;
	}

}
