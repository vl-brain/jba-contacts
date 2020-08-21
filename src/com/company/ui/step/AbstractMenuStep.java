package com.company.ui.step;

import com.company.command.base.Command;
import com.company.command.ShowNewLinePromptCommand;

abstract class AbstractMenuStep extends AbstractInputStep
{

	@Override
	public Command run()
	{
		return getShowPromptCommand();
	}

	protected Command getShowPromptCommand()
	{
		return new ShowNewLinePromptCommand(getPrompt());
	}
}
