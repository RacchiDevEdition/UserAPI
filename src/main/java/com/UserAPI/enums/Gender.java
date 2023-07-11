package com.UserAPI.enums;

public enum Gender {

	F(1), M(2);

	private Integer code;

	Gender(Integer code) {
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}
	
}
