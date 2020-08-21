package com.company.command;

import com.company.command.base.AbstractUIAndServiceAwareCommand;
import com.company.model.PhoneRecord;

public class UpdateRecordCommand extends AbstractUIAndServiceAwareCommand
{

	private final int index;
	private final PhoneRecord phoneRecord;

	public UpdateRecordCommand(int index, PhoneRecord phoneRecord)
	{
		this.index = index;
		this.phoneRecord = phoneRecord;
	}

	@Override
	public void execute()
	{
		service.updatePhoneBookRecord(index, phoneRecord);
		ui.showUpdatePhoneBookRecord();
	}
}
