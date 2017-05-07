package com.vote.entity;

import java.io.Serializable;

/**
 * 投票主题
 * 
 * @author Wild
 *
 */
public class VoteSubject implements Serializable {
	private static final long serialVersionUID = -1114988035267824719L;

	private String Vsid;// 主题id
	private String Vstitle;// 投票主题
	private String Vs_Type;// 投票类型

	public VoteSubject(String vsid, String vstitle, String vs_Type) {
		super();
		Vsid = vsid;
		Vstitle = vstitle;
		Vs_Type = vs_Type;
	}

	public VoteSubject() {
		super();
	}

	public String getVsid() {
		return Vsid;
	}

	public void setVsid(String vsid) {
		Vsid = vsid;
	}

	public String getVstitle() {
		return Vstitle;
	}

	public void setVstitle(String vstitle) {
		Vstitle = vstitle;
	}

	public String getVs_Type() {
		return Vs_Type;
	}

	public void setVs_Type(String vs_Type) {
		Vs_Type = vs_Type;
	}

}
