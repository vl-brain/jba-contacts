package com.company.command;

import com.company.command.base.Command;
import com.company.command.base.CompositeCommand;

public class CommandArray implements CompositeCommand
{
	private final Command[] commands;

	public CommandArray(Command... commands) {this.commands = commands;}

	@Override
	public Command[] getCommands()
	{
		return commands;
	}
}
