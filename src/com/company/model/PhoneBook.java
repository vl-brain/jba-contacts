package com.company.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PhoneBook
{
	private final List<PhoneRecord> records;

	public PhoneBook()
	{
		this(Collections.emptyList());
	}

	public PhoneBook(List<PhoneRecord> records)
	{
		this.records = new ArrayList<>(records);
	}

	public List<PhoneRecord> getRecords()
	{
		return records;
	}

	private boolean hasPhoneRecord(int index)
	{
		return 0 <= index && index < records.size();
	}

	public int getRecordCount()
	{
		return records.size();
	}

	public PhoneRecord get(int index)
	{
		if (hasPhoneRecord(index))
		{
			return records.get(index);
		}
		return null;
	}

	public boolean add(PhoneRecord phoneRecord)
	{
		return phoneRecord != null && records.add(phoneRecord);
	}

	public boolean update(int index, PhoneRecord phoneRecord)
	{
		if (phoneRecord != null && hasPhoneRecord(index))
		{
			records.set(index, phoneRecord);
			return true;
		}
		return false;
	}

	public boolean remove(int index)
	{
		if (hasPhoneRecord(index))
		{
			records.remove(index);
			return true;
		}
		return false;
	}
}
