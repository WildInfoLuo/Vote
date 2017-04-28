package com.vote.handler;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
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
import com.vote.enums.UserVersioniEnum;
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
	public String getKeyMap(PrintWriter out, HttpServletRequest request, HttpSession session) {
		Gson gson = new Gson();
		Map<String, Object> map = new HashMap<>();
		String phone = request.getParameter("phoneId");// 手机号码
		String userName = request.getParameter("userName");// 用户名
		String messages = request.getParameter("messages");// 前台输入验证码
		// 生成密钥
		String encrypttext = request.getParameter("getMapKey");// 前台密文
		String vpwd = RSAUtils.decryptStringByJs(encrypttext);
		String messagenum = (String) session.getAttribute(SessionAttribute.TELRLOGIN);
		if (StringUtils.isNotBlank(userName) && StringUtils.isNotBlank(phone) && StringUtils.isNotBlank(messages)
				&& StringUtils.isNotBlank(vpwd)) {
			// 不为空
			VUser user = new VUser(UUIDUtil.createUUID(), userName, vpwd.trim(), phone, UserStatusEnum.normal,
					UserVersioniEnum.common);
			String resultPhone = uservice.selectPhone(phone);
			if (StringUtils.isNotBlank(resultPhone)) {
				map.put("result", 0);
				map.put("desc", "该电话号码已经存在");
				out.println(gson.toJson(map));
				out.flush();
				out.close();
			} else {
				if (!messages.equalsIgnoreCase(messagenum)) {
					map.put("result", 0);
					map.put("desc", "您输入的验证码不正确！");
					out.println(gson.toJson(map));
					out.flush();
					out.close();
				} else {
					int result = uservice.register(user);
					if (result > 0) {// 如果注册失败
						map.put("result", 1);
						map.put("desc", "注册成功！");
						out.println(gson.toJson(map));
						out.flush();
						out.close();
						return "reg_success";
					} else {
						map.put("result", 0);
						map.put("desc", "注册失败！");
						out.println(gson.toJson(map));
						out.flush();
						out.close();
					}
				}
			}
		} else {
			map.put("result", 0);
			map.put("desc", "数据不能为空！");
			out.println(gson.toJson(map));
			out.flush();
			out.close();
		}
		return "reg_success";
	}

	/**
	 * 获取电话号码得出验证码
	 * 
	 * @param user
	 * @param out
	 */
	@ResponseBody
	@RequestMapping(value = "/message", method = RequestMethod.POST)
	public void MessageResiter(PrintWriter out, HttpServletRequest request, HttpSession session) {
		Gson gson = new Gson();
		Map<String, Object> map = new HashMap<>();
		Map<String, Object> map2 = new HashMap<>();

		String phone = request.getParameter("tel");
		String resultPhone = uservice.selectPhone(phone);
		if (StringUtils.isNotBlank(resultPhone)) {
			map.put("result", 0);
			map.put("desc", "该电话号码已经存在！");
			out.println(gson.toJson(map));
			out.flush();
			out.close();
		} else {
			CouldMessage cl = new CouldMessage();
			String num = getCharAndNumr(4);
			session.setAttribute(SessionAttribute.TELRLOGIN, num);// 存入电话号码
			cl.CouldMessageContent(phone, num);
			System.out.println(num);
			map2.put("verificationCode", num);
			map.put("result", 1);
			map.put("desc", "验证码发送成功！");
			map.put("data", map2);

			out.println(gson.toJson(map));
			out.flush();
			out.close();
		}
	}

	/**
	 * java生成随机数字和字母组合
	 * 
	 * @param length[生成随机数的长度]
	 * @return
	 */
	public String getCharAndNumr(int length) {
		String val = "";// 定义两变量
		Random ne = new Random();// 实例化一个random的对象ne
		val = ne.nextInt(9999 - 1000 + 1) + 1000 + "";// 为变量赋随机值1000-9999
		return val;
	}
}
