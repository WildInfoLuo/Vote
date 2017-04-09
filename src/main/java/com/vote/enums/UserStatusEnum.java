package com.vote.enums;

public enum UserStatusEnum {
	// 年龄就四个选项 70 80 90 00
	normal("1"), cancel("2");

	private String desc;

	private UserStatusEnum(String desc) {
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public static boolean contain(String value) {
		UserStatusEnum[] status = UserStatusEnum.values();
		for (int i = 0; i < status.length; i++) {
			if (status[i].toString().equals(value)) {
				return true;
			}
		}
		return false;
	}

}
