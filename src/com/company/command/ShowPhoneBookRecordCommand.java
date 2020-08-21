package com.company.command;

import com.company.command.base.AbstractUIAndServiceAwareCommand;

public class ShowPhoneBookRecordCommand extends AbstractUIAndServiceAwareCommand
{
	private final int index;

	public ShowPhoneBookRecordCommand(int index) {this.index = index;}

	@Override
	public void execute()
	{
		ui.showPhoneBookRecord(service.getPhoneBookRecord(index));
	}
}
