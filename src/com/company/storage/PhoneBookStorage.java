package com.company.storage;

import com.company.model.PhoneBook;
import com.company.model.PhoneRecord;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PhoneBookStorage
{
	private final File file;

	public PhoneBookStorage(String filePath)
	{
		file = filePath == null || filePath.isEmpty() ? null : createIfNotExist(new File(filePath));
	}

	private File createIfNotExist(File file)
	{
		if (!file.exists()) {
			try
			{
				file.createNewFile();
				save(file, new PhoneBook());
			}
			catch (IOException e)
			{
				throw new IllegalArgumentException("Не могу создать файл " + file.getName(), e);
			}
		}
		return file;
	}

	public PhoneBook load()
	{
		if (file == null)
		{
			return new PhoneBook();
		}
		try (final ObjectInputStream inputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file))))
		{
			final int count = inputStream.readInt();
			final List<PhoneRecord> list = new ArrayList<>(count);
			for (int i = 0; i < count; i++)
			{
				list.add((PhoneRecord) inputStream.readObject());
			}
			return new PhoneBook(list);
		}
		catch (IOException | ClassNotFoundException e)
		{
			throw new IllegalArgumentException("Не могу загрузить контакты из файла " + file.getName(), e);
		}
	}

	public void save(PhoneBook phoneBook)
	{
		save(file, phoneBook);
	}

	private void save(File file, PhoneBook phoneBook)
	{
		if (file == null)
		{
			return;
		}
		final Collection<PhoneRecord> records = phoneBook.getRecords();
		try (final ObjectOutputStream outputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file))))
		{
			final int count = records.size();
			outputStream.writeInt(count);
			for (PhoneRecord record : records)
			{
				outputStream.writeObject(record);
			}
		}
		catch (IOException e)
		{
			throw new IllegalArgumentException("Не могу сохранить контакты в файл " + file.getName(), e);
		}
	}

}
