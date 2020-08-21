package com.company.ui.step;

import com.company.command.ChangeUIStepCommand;
import com.company.command.CommandArray;
import com.company.command.SearchPhoneRecordsCommand;
import com.company.command.base.Command;

public class SearchMenuStep extends AbstractInputStep
{
	private int[] foundPhoneRecordIndexes;

	@Override
	protected String getPrompt()
	{
		return "Enter search query:";
	}

	@Override
	public Command process(String input)
	{
		return new CommandArray(
			new SearchPhoneRecordsCommand(input, this::setFoundPhoneRecordIndexes),
			new ChangeUIStepCommand(new SearchResultsMenuStep(this::getFoundPhoneRecordIndexes))
		);
	}

	public int[] getFoundPhoneRecordIndexes()
	{
		return foundPhoneRecordIndexes;
	}

	private void setFoundPhoneRecordIndexes(int[] foundPhoneRecordIndexes)
	{
		this.foundPhoneRecordIndexes = foundPhoneRecordIndexes;
	}
}
