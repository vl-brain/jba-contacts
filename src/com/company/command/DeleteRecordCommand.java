package com.company.command;

import com.company.command.base.AbstractUIAndServiceAwareCommand;

public class DeleteRecordCommand extends AbstractUIAndServiceAwareCommand
{

	private final int index;

	public DeleteRecordCommand(int index) {this.index = index;}

	@Override
	public void execute()
	{
		service.removePhoneBookRecord(index);
		ui.showDeletePhoneBookRecord();
	}
}
