package com.company.ui.step;

import com.company.command.base.Command;

public interface Step
{
	Command run();

	Command process(String input);
}
