package com.company.command;

import com.company.command.base.AbstractUIAndServiceAwareCommand;

public class ShowRecordCountCommand extends AbstractUIAndServiceAwareCommand
{

	@Override
	public void execute()
	{
		ui.showPhoneBookRecordCount(service.getPhoneBookRecordCount());
	}
}
