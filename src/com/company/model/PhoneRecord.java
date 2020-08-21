package com.company.model;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public abstract class PhoneRecord
{
	private String number;
	private String name;
	private LocalDateTime created;
	private LocalDateTime lastModified;

	public PhoneRecord()
	{
		lastModified = created = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);
	}

	public boolean hasNumber()
	{
		return number != null;
	}

	static boolean isValidPhoneNumber(String number)
	{
		return number.matches("\\+?([0-9a-zA-Z]+([ -]\\([0-9a-zA-Z]{2,}\\))?|\\([0-9a-zA-Z]+\\))([ -][0-9a-zA-Z]{2,})*");
	}

	public String getNumber()
	{
		return number;
	}

	void setNumber(String number)
	{
		String prevNumber = this.number;
		this.number = isValidPhoneNumber(number) ? number : null;
		updateLastModified(prevNumber, number);
	}

	public String getName()
	{
		return name;
	}

	void setName(String name)
	{
		String prevName = this.name;
		this.name = name;
		updateLastModified(prevName, name);
	}

	public LocalDateTime getCreated()
	{
		return created;
	}

	void setCreated(LocalDateTime created)
	{
		this.created = created.truncatedTo(ChronoUnit.MINUTES);
	}

	public LocalDateTime getLastModified()
	{
		return lastModified;
	}

	void setLastModified(LocalDateTime lastModified)
	{
		this.lastModified = lastModified.truncatedTo(ChronoUnit.MINUTES);
	}

	void updateLastModified(Object prevValue, Object nextValue)
	{
		if (!Objects.equals(prevValue, nextValue))
		{
			setLastModified(LocalDateTime.now());
		}
	}

	public abstract String getShortInfo();

	public List<String> getFields()
	{
		return Arrays.asList("name", "number");
	}

	public boolean setField(String fieldName, String value)
	{
		switch (fieldName)
		{
			case "name":
				setName(value);
				return true;
			case "number":
				setNumber(value);
				return hasNumber();
		}
		return false;
	}

	@Override
	public String toString()
	{
		return "Number: " + (hasNumber() ? getNumber() : "[no number]") + "\n" +
			"Time created: " + getCreated() + "\n" +
			"Time last edit: " + getLastModified() + "\n";
	}

	public String toIndex()
	{
		return (hasNumber() ? getNumber() : "") + getName();
	}
}
