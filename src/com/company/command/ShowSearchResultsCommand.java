package com.company.command;

import com.company.model.PhoneRecord;

import java.util.List;
import java.util.function.Supplier;

public class ShowSearchResultsCommand extends ShowPhoneBookRecordsCommand
{

	public ShowSearchResultsCommand(Supplier<List<PhoneRecord>> phoneRecordsSupplier)
	{
		super(phoneRecordsSupplier);
	}

	@Override
	public void execute()
	{
		final List<PhoneRecord> phoneRecords = getPhoneRecords();
		ui.showFoundSearchPhoneBookRecordCount(phoneRecords.size());
		showRecords(phoneRecords);
	}
}
