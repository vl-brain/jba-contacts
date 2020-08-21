package com.company;

import com.company.handler.CommandHandler;
import com.company.service.PhoneBookService;
import com.company.storage.PhoneBookStorage;
import com.company.ui.PhoneBookUI;

import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		final PhoneBookStorage storage = new PhoneBookStorage(findStorageFilePathArg(args));
		final PhoneBookService service = new PhoneBookService(storage);
		final PhoneBookUI phoneBookUI = new PhoneBookUI();
		final CommandHandler handler = new CommandHandler(service, phoneBookUI);
		final Scanner scanner = new Scanner(System.in);
		while (phoneBookUI.isActive())
		{
			handler.process(scanner.nextLine());
		}
	}

	private static String findStorageFilePathArg(String[] args)
	{
		String filename = null;
		for (int i = 0; i < args.length; i++)
		{
			if ("open".equals(args[i]) && i + 1 < args.length)
			{
				filename = args[i + 1];
				break;
			}
		}
		return filename;
	}
}
