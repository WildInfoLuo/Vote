package com.vote.entity;

import com.vote.enums.UserStatusEnum;
import com.vote.enums.UserVersioniEnum;

/**
 * 用户
 * 
 * @author Wild
 *
 */
public class VUser {
	private String vuId;// 用户id
	private String vuusername;// 用户名字
	private String vupassword;// 用户密码
	private UserStatusEnum Vustatus;// 用户状态
	private UserVersioniEnum vuversion;// 用户角色
	private String vphone;// 用户电话号码

	public VUser(String vuId, String vuusername, String vupassword, String vphone, UserStatusEnum vustatus,
			UserVersioniEnum vuversion) {
		this.vuId = vuId;
		this.vuusername = vuusername;
		this.vupassword = vupassword;
		this.vphone = vphone;
		this.Vustatus = vustatus;
		this.vuversion = vuversion;
	}

	public String getVuId() {
		return vuId;
	}

	public void setVuId(String vuId) {
		this.vuId = vuId;
	}

	public String getVuusername() {
		return vuusername;
	}

	public void setVuusername(String vuusername) {
		this.vuusername = vuusername;
	}

	public String getVupassword() {
		return vupassword;
	}

	public void setVupassword(String vupassword) {
		this.vupassword = vupassword;
	}

	public String getVphone() {
		return vphone;
	}

	public void setVphone(String vphone) {
		this.vphone = vphone;
	}

	public UserStatusEnum getVustatus() {
		return Vustatus;
	}

	public void setVustatus(UserStatusEnum vustatus) {
		Vustatus = vustatus;
	}

	public UserVersioniEnum getVuversion() {
		return vuversion;
	}

	public void setVuversion(UserVersioniEnum vuversion) {
		this.vuversion = vuversion;
	}

	@Override
	public String toString() {
		return "VUser [vuId=" + vuId + ", vuusername=" + vuusername + ", vupassword=" + vupassword + ", Vustatus="
				+ Vustatus + ", vuversion=" + vuversion + ", vphone=" + vphone + "]";
	}
}
