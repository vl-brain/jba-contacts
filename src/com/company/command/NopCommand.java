package com.company.command;

import com.company.command.base.Command;

public class NopCommand implements Command
{
	public static final Command INSTANCE = new NopCommand();

	private NopCommand()
	{
	}

	@Override
	public void execute()
	{
	}
}
