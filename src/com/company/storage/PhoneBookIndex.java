package com.company.storage;

import com.company.model.PhoneRecord;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PhoneBookIndex
{
	private final List<String> indexes;

	public PhoneBookIndex(List<PhoneRecord> records)
	{
		this.indexes = records.stream()
			.map(PhoneRecord::toIndex)
			.collect(Collectors.toList());
	}

	public void add(PhoneRecord phoneRecord)
	{
		indexes.add(phoneRecord.toIndex());
	}

	public void update(int index, PhoneRecord phoneRecord)
	{
		indexes.set(index, phoneRecord.toIndex());
	}

	public void remove(int index)
	{
		indexes.remove(index);
	}

	public int[] search(String regex)
	{
		final Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		return IntStream.range(0, indexes.size())
			.filter(i -> pattern.matcher(indexes.get(i)).find())
			.toArray();
	}
}
