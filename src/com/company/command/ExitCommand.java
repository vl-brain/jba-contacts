package com.company.command;

import com.company.ui.step.OffStep;

public class ExitCommand extends ChangeUIStepCommand
{

	public ExitCommand()
	{
		super(OffStep.INSTANCE);
	}
}
