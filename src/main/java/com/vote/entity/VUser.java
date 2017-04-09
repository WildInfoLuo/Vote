package com.vote.entity;

import com.vote.enums.UserStatusEnum;

/**
 * 用户
 * 
 * @author Wild
 *
 */
public class VUser {
	private String vuId;// 用户id
	private String vname;// 用户名字
	private String vpwd;// 用户密码
	private String vphone;// 用户电话号码
	private UserStatusEnum vuStatus;// 用户状态
	private int version;// 用户角色

	public VUser(String vname, String vpwd, UserStatusEnum vuStatus, int version) {
		this.vname = vname;
		this.vpwd = vpwd;
		this.vuStatus = vuStatus;
		this.version = version;
	}

	public VUser() {
	}

	public String getVuId() {
		return vuId;
	}

	public void setVuId(String vuId) {
		this.vuId = vuId;
	}

	public String getVname() {
		return vname;
	}

	public void setVname(String vname) {
		this.vname = vname;
	}

	public String getVpwd() {
		return vpwd;
	}

	public void setVpwd(String vpwd) {
		this.vpwd = vpwd;
	}

	public UserStatusEnum getVuStatus() {
		return vuStatus;
	}

	public void setVuStatus(UserStatusEnum vuStatus) {
		this.vuStatus = vuStatus;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "VUser [vuId=" + vuId + ", vname=" + vname + ", vpwd=" + vpwd + ", vuStatus=" + vuStatus + ", version="
				+ version + "]";
	}

	public String getPhone() {
		return vphone;
	}

	public void setPhone(String vphone) {
		this.vphone = vphone;
	}
}
