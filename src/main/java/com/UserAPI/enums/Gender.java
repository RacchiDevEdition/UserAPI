package com.UserAPI.enums;

public enum Gender {

	F(1), M(2);

	private Integer code;

	private Gender(Integer code) {
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}

	public static Gender valueOf(Integer code) {
		for (Gender value : Gender.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid gender");
	}
}
