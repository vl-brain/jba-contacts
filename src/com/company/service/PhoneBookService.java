package com.company.service;

import com.company.model.PhoneBook;
import com.company.model.PhoneRecord;
import com.company.storage.PhoneBookIndex;
import com.company.storage.PhoneBookStorage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PhoneBookService
{
	private final PhoneBookStorage storage;
	private final PhoneBook phoneBook;
	private final PhoneBookIndex phoneBookIndex;

	public PhoneBookService(PhoneBookStorage storage) {
		this.storage = storage;
		phoneBook = storage.load();
		phoneBookIndex = new PhoneBookIndex(phoneBook.getRecords());

	}

	public int getPhoneBookRecordCount()
	{
		return phoneBook.getRecordCount();
	}

	public PhoneRecord getPhoneBookRecord(int index)
	{
		return phoneBook.get(index);
	}

	public void addPhoneBookRecord(PhoneRecord phoneRecord)
	{
		if (phoneBook.add(phoneRecord))
		{
			phoneBookIndex.add(phoneRecord);
			storage.save(phoneBook);
		}
	}

	public void updatePhoneBookRecord(int index, PhoneRecord phoneRecord)
	{
		if (phoneBook.update(index, phoneRecord))
		{
			phoneBookIndex.update(index, phoneRecord);
			storage.save(phoneBook);
		}
	}

	public void removePhoneBookRecord(int index)
	{
		if (phoneBook.remove(index))
		{
			phoneBookIndex.remove(index);
			storage.save(phoneBook);
		}
	}

	public List<PhoneRecord> getPhoneBookRecords()
	{
		return phoneBook.getRecords();
	}

	public List<PhoneRecord> getPhoneBookRecords(int[] indexes)
	{
		final List<PhoneRecord> records = phoneBook.getRecords();
		return Arrays.stream(indexes).mapToObj(records::get)
			.collect(Collectors.toList());
	}

	public int[] searchPhoneBookRecords(String regex)
	{
		return phoneBookIndex.search(regex);
	}
}
