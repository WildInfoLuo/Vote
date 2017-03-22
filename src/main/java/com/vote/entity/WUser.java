package com.vote.entity;

/**
 * 用户
 * 
 * @author Wild
 *
 */
public class WUser {
	private int vuId;// 用户id
	private String vname;// 用户名字
	private String vpwd;// 用户密码
	private int vuStatus;// 用户状态
	private int version;// 用户角色

	public WUser(String vname, String vpwd, int vuStatus, int version) {
		this.vname = vname;
		this.vpwd = vpwd;
		this.vuStatus = vuStatus;
		this.version = version;
	}

	public int getVuId() {
		return vuId;
	}

	public void setVuId(int vuId) {
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

	public int getVuStatus() {
		return vuStatus;
	}

	public void setVuStatus(int vuStatus) {
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
}
