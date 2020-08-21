package com.company.handler;

import com.company.command.base.Command;
import com.company.command.base.CompositeCommand;
import com.company.command.base.PhoneBookServiceAwareCommand;
import com.company.command.base.PhoneBookUIAwareCommand;
import com.company.service.PhoneBookService;
import com.company.ui.PhoneBookUI;

public class CommandHandler
{
	private final PhoneBookService service;
	private final PhoneBookUI ui;

	public CommandHandler(PhoneBookService service, PhoneBookUI ui)
	{
		this.service = service;
		this.ui = ui;
		execute(ui.run());
	}

	public void process(String input)
	{
		execute(ui.process(input));
	}

	private Command init(Command command)
	{
		if (command instanceof PhoneBookUIAwareCommand)
		{
			((PhoneBookUIAwareCommand) command).setUi(ui);
		}
		if (command instanceof PhoneBookServiceAwareCommand)
		{
			((PhoneBookServiceAwareCommand) command).setService(service);
		}
		if (command instanceof CompositeCommand)
		{
			for (Command internalCommand : ((CompositeCommand) command).getCommands())
			{
				init(internalCommand);
			}
		}
		return command;
	}

	private void execute(Command command)
	{

		init(command).execute();
	}
}
