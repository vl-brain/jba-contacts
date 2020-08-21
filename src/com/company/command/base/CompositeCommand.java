package com.company.command.base;

public interface CompositeCommand extends Command
{
	Command[] getCommands();

	default void execute()
	{
		for (Command command : getCommands())
		{
			command.execute();
		}
	}
}
