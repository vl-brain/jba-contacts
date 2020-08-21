package com.company.command;

import com.company.command.base.AbstractServiceAwareCommand;

import java.util.function.Consumer;

public class SearchPhoneRecordsCommand extends AbstractServiceAwareCommand
{
	private final String query;
	private final Consumer<int[]> receiver;

	public SearchPhoneRecordsCommand(String query, Consumer<int[]> receiver) {
		this.query = query;
		this.receiver = receiver;
	}

	@Override
	public void execute()
	{
		final int[] indexes = service.searchPhoneBookRecords(query);
		receiver.accept(indexes);
	}
}
