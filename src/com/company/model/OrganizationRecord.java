package com.company.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class OrganizationRecord extends PhoneRecord implements Serializable
{
	private static final long serialVersionUID = 1L;
	private String address;

	@Override
	public List<String> getFields()
	{
		return Arrays.asList("name", "address", "number");
	}

	@Override
	public boolean setField(String fieldName, String value)
	{
		if (super.getFields().contains(fieldName))
		{
			return super.setField(fieldName, value);
		}
		if ("address".equals(fieldName))
		{
			setAddress(value);
			return true;
		}
		return false;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		String prevAddress = this.address;
		this.address = address;
		updateLastModified(prevAddress, address);
	}

	@Override
	public String getShortInfo()
	{
		return getName();
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
		OrganizationRecord that = (OrganizationRecord) o;
		return getName().equals(that.getName()) &&
			getAddress().equals(that.getAddress()) &&
			Objects.equals(getNumber(), that.getNumber());
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(getName(), getAddress(), getNumber());
	}

	@Override
	public String toString()
	{
		return "Organization name: " + getName() + "\n" +
			"Address: " + getAddress() + "\n" +
			super.toString();
	}

	@Override
	public String toIndex()
	{
		return super.toIndex() + getAddress();
	}
}
