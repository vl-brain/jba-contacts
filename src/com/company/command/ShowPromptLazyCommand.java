package com.company.command;

import com.company.command.base.AbstractUIAwareCommand;

import java.util.function.Supplier;

public class ShowPromptLazyCommand extends AbstractUIAwareCommand
{
	protected final Supplier<String> promptSupplier;

	public ShowPromptLazyCommand(Supplier<String> promptSupplier) {this.promptSupplier = promptSupplier;}

	@Override
	public void execute()
	{
		ui.showMessage(getPrompt());
	}

	protected String getPrompt()
	{
		return promptSupplier.get();
	}
}
