package com.company.model;

import java.util.Arrays;

public enum Gender
{
	MALE,
	FEMALE;

	public static Gender fromCode(String code)
	{
		return code.isEmpty() ? null : Arrays.stream(values())
			.filter(it -> it.name().startsWith(code))
			.findAny()
			.orElse(null);
	}

	public String getCode()
	{
		return name().substring(0, 1);
	}
}
