package com.company.command;

public class ShowNewLinePromptCommand extends ShowPromptCommand
{

	public ShowNewLinePromptCommand(String prompt)
	{
		super(prompt);
	}

	@Override
	public void execute()
	{
		ui.showMessageLine();
		super.execute();
	}
}
