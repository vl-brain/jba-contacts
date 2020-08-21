package com.company.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class PersonRecord extends PhoneRecord implements Serializable
{
	private static final long serialVersionUID = 1L;
	private String surname;
	private LocalDate birthDay;
	private Gender gender;

	public String getSurname()
	{
		return surname;
	}

	public void setSurname(String surname)
	{
		String prevSurname = this.surname;
		this.surname = surname;
		updateLastModified(prevSurname, surname);
	}

	public boolean hasBirthDay()
	{
		return birthDay != null;
	}

	static boolean isValidBirthDay(String birthDay)
	{
		if (birthDay == null || birthDay.isEmpty())
		{
			return false;
		}
		try
		{
			LocalDate.parse(birthDay);
		}
		catch (DateTimeParseException e)
		{
			return false;
		}
		return true;
	}

	public LocalDate getBirthDay()
	{
		return birthDay;
	}

	public void setBirthDay(String birthDay)
	{
		LocalDate prevBirthday = this.birthDay;
		this.birthDay = isValidBirthDay(birthDay) ? LocalDate.parse(birthDay) : null;
		updateLastModified(prevBirthday, this.birthDay);
	}

	public boolean hasGender()
	{
		return gender != null;
	}

	public Gender getGender()
	{
		return gender;
	}

	public void setGender(String gender)
	{
		Gender prevGender = this.gender;
		this.gender = Gender.fromCode(gender);
		updateLastModified(prevGender, this.gender);
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
		{
			return true;
		}
		if (o == null || getClass() != o.getClass())
		{
			return false;
		}
		PersonRecord that = (PersonRecord) o;
		return getName().equals(that.getName()) &&
			getSurname().equals(that.getSurname()) &&
			Objects.equals(getNumber(), that.getNumber()) &&
			Objects.equals(getBirthDay(), that.getBirthDay()) &&
			getGender() == that.getGender();
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(getName(), getSurname(), getNumber(), getBirthDay(), getGender());
	}

	@Override
	public String toString()
	{
		return "Name: " + getName() + "\n" +
			"Surname: " + getSurname() + "\n" +
			"Birth date: " + (hasBirthDay() ? getBirthDay().toString() : "[no data]") + "\n" +
			"Gender: " + (hasGender() ? getGender().getCode() : "[no data]") + "\n" +
			super.toString();
	}

	@Override
	public String getShortInfo()
	{
		return getName() + " " + getSurname();
	}

	@Override
	public String toIndex()
	{
		return super.toIndex() + getSurname() +
			(hasBirthDay() ? getBirthDay().toString() : "") +
			(hasGender() ? getGender().getCode() : "");
	}

	@Override
	public List<String> getFields()
	{
		return Arrays.asList("name", "surname", "birth", "gender", "number");
	}

	@Override
	public boolean setField(String fieldName, String value)
	{
		if (super.getFields().contains(fieldName))
		{
			return super.setField(fieldName, value);
		}
		switch (fieldName)
		{
			case "surname":
				setSurname(value);
				return true;
			case "birth":
				setBirthDay(value);
				return hasBirthDay();
			case "gender":
				setGender(value);
				return hasGender();
		}
		return false;
	}

}
