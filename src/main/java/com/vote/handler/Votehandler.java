package com.vote.handler;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.vote.entity.VoteSubject;
import com.vote.service.VoteService;
import com.vote.utils.UUIDUtil;

@Controller
@RequestMapping("/vote")
public class Votehandler {

	@Autowired
	private VoteService votesvice;

	@RequestMapping(value = "/insertVote", method = RequestMethod.POST)
	public String insertVote(String titleContent, String subjectType, String options, String mytext[],
			HttpServletRequest request, PrintWriter out, HttpSession session, ModelMap map) {
		VoteSubject subject = new VoteSubject();
		//request.getInputStream();
		// 如果有错误的话，那么将返回注册页面
		if (StringUtils.isNotBlank(titleContent) && StringUtils.isNotBlank(subjectType)) {
			subject.setVsid(UUIDUtil.createUUID());
			subject.setVstitle(titleContent);
			subject.setVs_Type(subjectType);
			int usersResult = votesvice.insertVote(subject);
			if (usersResult > 0) {
				// map.put("usersLogin", users.getVuusername());
				return "index";
			} else {
				map.put("regErrorMsg", "添加失败");
				return "add";
			}
		} else {
			map.put("regErrorMsg", "数据为空");
			return "add";
		}
	}

}
