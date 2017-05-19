package com.vote.handler;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.vote.entity.VoteItem;
import com.vote.entity.VoteOption;
import com.vote.entity.VoteSubject;
import com.vote.service.VoteService;
import com.vote.utils.SessionAttribute;
import com.vote.utils.UUIDUtil;

@Controller
@RequestMapping("/vote")
public class Votehandler {

	@Autowired
	private VoteService votesvice;

	/**
	 * 增加投票
	 * 
	 * @param titleContent
	 * @param map
	 * @return
	 * @return
	 */
	@RequestMapping(value = "/insertVote", method = RequestMethod.POST)
	public String insertVote(HttpServletRequest request, PrintWriter out, HttpSession session, ModelMap map) {
		VoteSubject subject = new VoteSubject();
		VoteOption option = new VoteOption();
		VoteItem item = new VoteItem();
		Gson gson = new Gson();
		String titleContents = request.getParameter("titleContent");// 投票标题
		String subjectType = request.getParameter("subjectType");// 单选还是多选
		String vote = request.getParameter("vote");// 选项内容
		// 如果有错误的话，那么将返回注册页面
		if (StringUtils.isNotBlank(titleContents) && StringUtils.isNotBlank(subjectType)
				&& StringUtils.isNotBlank(vote)) {
			subject.setVsid(UUIDUtil.createUUID());
			subject.setVstitle(titleContents);
			subject.setVs_Type(subjectType);
			String voteSubOne[] = vote.split(":");
			for (int i = 0; i < voteSubOne.length; i++) {
				if (voteSubOne.length > 0) {
					String ones = voteSubOne[i];
					String voteSubTwo[] = ones.split("=");
					option.setVoids(UUIDUtil.createUUID());
					option.setVooption(voteSubTwo[0]);
					option.setVOORDER(i + 1 + "");
					option.setVsid(subject.getVsid());
					votesvice.insertVoteOption(option);
				} else {
					map.put("desc", "系统错误,请重试!");
					out.println(gson.toJson(map));
					out.flush();
					out.close();
					return "add";
				}
			}
			votesvice.insertVote(subject);
			item.setViid(UUIDUtil.createUUID());
			item.setVuid(session.getAttribute(SessionAttribute.USERLOGINID).toString());
			item.setVoids(option.getVoids());
			item.setVsid(subject.getVsid());
			votesvice.insertVoteitem(item);
			map.put("data", "1");
			map.put("desc", "投票成功");
			return "vote_success";
		} else {
			map.put("data", "0");
			map.put("desc", "数据为空");
			out.close();
			return "add";
		}
	}

	/**
	 * 查询所有投票
	 * 
	 * @param request
	 * @param out
	 * @param session
	 * @param map
	 */
	@ResponseBody
	@RequestMapping(value = "/selectVote", method = RequestMethod.POST)
	public void selectVote(PrintWriter out, HttpServletRequest request, HttpSession session) {
		VoteSubject suVoteSubject = new VoteSubject();
		VoteOption option = new VoteOption();
		VoteItem voteItem = new VoteItem();
		Gson gson = new Gson();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> map2 = new HashMap<String, Object>();
		String voteSubuject = request.getParameter("voteId");
		if (StringUtils.isNotBlank(voteSubuject)) {
			suVoteSubject.setVsid(voteSubuject);
			option.setVsid(voteSubuject);
			voteItem.setVsid(voteSubuject);
			List<VoteSubject> voteSubject = votesvice.selectAllVote();
			int voteOption = votesvice.selectVoteOption(option);
			VoteSubject subject = votesvice.selectVote(suVoteSubject);
			VoteItem itemList = votesvice.selectVoteitem(voteItem);
			map2.put("voteOption", voteOption);// 查询选项
			map2.put("subject", subject);// 查询本条主题
			map2.put("voteSubject", voteSubject);// 查询所有的
			map2.put("itemList", itemList);// 查询多少人投票
			out.println(gson.toJson(map2));
			out.flush();
			out.close();
		}
	}

	/**
	 * 查询所有投票
	 * 
	 * @param out
	 * @param request
	 * @param session
	 */
	@ResponseBody
	@RequestMapping(value = "/selectAllVote", method = RequestMethod.POST)
	public void selectAllVote(PrintWriter out, HttpServletRequest request, HttpSession session) {
		Gson gson = new Gson();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> map2 = new HashMap<String, Object>();
		List<VoteSubject> subject = votesvice.selectAllVote();
		List<VoteSubject> voteIdes=votesvice.selectAllVoteId();
		//map2.put("voteIdes", voteIdes);
		map2.put("subject", subject);
		map.put("data", map2);
		out.println(gson.toJson(map2));
		out.flush();
		out.close();
	}

	/**
	 * 
	 * @param out
	 * @param request
	 * @param session
	 */
	@ResponseBody
	@RequestMapping(value = "/selectVoteitem", method = RequestMethod.POST)
	public void selectVoteitem(PrintWriter out, HttpServletRequest request, HttpSession session) {
		Gson gson = new Gson();
		Map<String, Object> map = new HashMap<String, Object>();
		List<VoteSubject> subject = votesvice.selectAllVote();
		map.put("subject", subject);
		out.println(gson.toJson(map));
		out.flush();
		out.close();
	}
}
