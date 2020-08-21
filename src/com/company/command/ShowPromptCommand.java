package com.company.command;

import com.company.command.base.AbstractUIAwareCommand;

public class ShowPromptCommand extends AbstractUIAwareCommand
{
	protected final String prompt;

	public ShowPromptCommand(String prompt) {this.prompt = prompt;}

	@Override
	public void execute()
	{
		ui.showMessage(prompt);
	}
}
