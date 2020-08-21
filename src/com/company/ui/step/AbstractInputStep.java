package com.company.ui.step;

import com.company.command.base.Command;
import com.company.command.ShowPromptCommand;

abstract class AbstractInputStep implements Step
{

	@Override
	public Command run()
	{
		return new ShowPromptCommand(getPrompt());
	}

	protected abstract String getPrompt();
}
