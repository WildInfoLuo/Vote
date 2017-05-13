package com.vote.entity;

import java.io.Serializable;

/**
 * 投票选项
 * 
 * @author Wild
 *
 */
public class VoteOption implements Serializable {

	private static final long serialVersionUID = 8446128326834320258L;

	private String Voids;// 投票选项id
	private String Vooption;// 投票选项
	private String Vsid;// 投票id
	private String VOORDER;// 第几个选项

	
	public VoteOption() {
	}

	public VoteOption(String voids, String vooption, String vsid, String vOORDER) {
		super();
		Voids = voids;
		Vooption = vooption;
		Vsid = vsid;
		VOORDER = vOORDER;
	}

	public String getVoids() {
		return Voids;
	}

	public void setVoids(String voids) {
		Voids = voids;
	}

	public String getVooption() {
		return Vooption;
	}

	public void setVooption(String vooption) {
		Vooption = vooption;
	}

	public String getVsid() {
		return Vsid;
	}

	public void setVsid(String vsid) {
		Vsid = vsid;
	}

	public String getVOORDER() {
		return VOORDER;
	}

	public void setVOORDER(String vOORDER) {
		VOORDER = vOORDER;
	}
}
