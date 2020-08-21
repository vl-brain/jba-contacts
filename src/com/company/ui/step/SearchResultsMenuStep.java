package com.company.ui.step;

import com.company.command.ChangeUIStepCommand;
import com.company.command.GetPhoneRecordsCommand;
import com.company.command.ShowSearchResultsCommand;
import com.company.command.base.Command;

import java.util.function.Supplier;

public class SearchResultsMenuStep extends ListMenuStep
{
	private final Supplier<int[]> indexesSupplier;

	public SearchResultsMenuStep(Supplier<int[]> indexesSupplier) {this.indexesSupplier = indexesSupplier;}

	@Override
	protected Command getPhoneRecordsCommand()
	{
		return new GetPhoneRecordsCommand(indexesSupplier, this::setPhoneBookRecords);
	}

	@Override
	protected Command getShowPhoneBookRecordsCommand()
	{
		return new ShowSearchResultsCommand(this::getPhoneBookRecords);
	}

	@Override
	protected String getPrompt()
	{
		return "[search] Enter action ([number], back, again):";
	}

	@Override
	public Command process(String input)
	{
		if ("again".equals(input))
		{
			return new ChangeUIStepCommand(new SearchMenuStep());
		}
		return super.process(input);
	}

	@Override
	public int getPhoneRecordIndex(int listIndex)
	{
		return indexesSupplier.get()[listIndex];
	}
}
