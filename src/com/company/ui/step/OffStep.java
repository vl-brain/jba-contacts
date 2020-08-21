package com.company.ui.step;

import com.company.command.base.Command;
import com.company.command.NopCommand;

public class OffStep implements Step
{

	public static final OffStep INSTANCE = new OffStep();

	private OffStep()
	{
	}

	@Override
	public Command run()
	{
		return NopCommand.INSTANCE;
	}

	@Override
	public Command process(String input)
	{
		return NopCommand.INSTANCE;
	}
}
