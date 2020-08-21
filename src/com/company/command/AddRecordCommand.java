package com.company.command;

import com.company.command.base.AbstractUIAndServiceAwareCommand;
import com.company.model.PhoneRecord;

public class AddRecordCommand extends AbstractUIAndServiceAwareCommand
{

	private final PhoneRecord phoneRecord;

	public AddRecordCommand(PhoneRecord phoneRecord) {this.phoneRecord = phoneRecord;}

	@Override
	public void execute()
	{
		service.addPhoneBookRecord(phoneRecord);
		ui.showAddPhoneBookRecord();
	}
}
