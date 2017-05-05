package com.vote.entity;

import java.io.Serializable;

/**
 * 投票与用户表
 * 
 * @author Wild
 *
 */
public class VoteItem implements Serializable {
	private static final long serialVersionUID = 7389738437443083825L;

	private String Viid;// 主键id
	private String Voids;// 投票选项id
	private String Vsid;// 投票主题编号id
	private String Vuid;// 用户id

	public VoteItem(String viid, String voids, String vsid, String vuid) {
		super();
		Viid = viid;
		Voids = voids;
		Vsid = vsid;
		Vuid = vuid;
	}

	public VoteItem() {
		super();
	}

	public String getViid() {
		return Viid;
	}

	public void setViid(String viid) {
		Viid = viid;
	}

	public String getVoids() {
		return Voids;
	}

	public void setVoids(String voids) {
		Voids = voids;
	}

	public String getVsid() {
		return Vsid;
	}

	public void setVsid(String vsid) {
		Vsid = vsid;
	}

	public String getVuid() {
		return Vuid;
	}

	public void setVuid(String vuid) {
		Vuid = vuid;
	}

}
