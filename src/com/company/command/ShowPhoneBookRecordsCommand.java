package com.company.command;

import com.company.command.base.AbstractUIAwareCommand;
import com.company.model.PhoneRecord;

import java.util.List;
import java.util.function.Supplier;

public class ShowPhoneBookRecordsCommand extends AbstractUIAwareCommand
{
	private final Supplier<List<PhoneRecord>> phoneRecordsSupplier;

	public ShowPhoneBookRecordsCommand(Supplier<List<PhoneRecord>> phoneRecordsSupplier)
	{
		this.phoneRecordsSupplier = phoneRecordsSupplier;
	}

	@Override
	public void execute()
	{
		showRecords(getPhoneRecords());
	}

	protected void showRecords(List<PhoneRecord> phoneRecords)
	{
		ui.showPhoneBookRecords(phoneRecords);
	}

	protected List<PhoneRecord> getPhoneRecords()
	{
		return phoneRecordsSupplier.get();
	}
}
