package com.company.ui.step;

import com.company.command.ChangeUIStepCommand;
import com.company.command.CommandArray;
import com.company.command.ExitCommand;
import com.company.command.ShowRecordCountCommand;
import com.company.command.base.Command;

public class MainMenuStep extends AbstractMenuStep
{

	@Override
	protected String getPrompt()
	{
		return "[menu] Enter action (add, list, search, count, exit):";
	}

	@Override
	public Command process(String input)
	{
		switch (input)
		{
			case "add":
				return new ChangeUIStepCommand(new AddPhoneRecordMenuStep());
			case "list":
				return new ChangeUIStepCommand(new ListMenuStep());
			case "search":
				return new ChangeUIStepCommand(new SearchMenuStep());
			case "exit":
				return new ExitCommand();
			case "count":
				return new CommandArray(
					new ShowRecordCountCommand(),
					run()
				);
			default:
				return run();
		}
	}
}
