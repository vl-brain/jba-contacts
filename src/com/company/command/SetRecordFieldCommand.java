package com.company.command;

import com.company.command.base.AbstractUIAndServiceAwareCommand;
import com.company.model.PhoneRecord;

public class SetRecordFieldCommand extends AbstractUIAndServiceAwareCommand
{

	private final PhoneRecord phoneRecord;
	private final String field;
	private final String value;

	public SetRecordFieldCommand(PhoneRecord phoneRecord, String field, String value)
	{
		this.phoneRecord = phoneRecord;
		this.field = field;
		this.value = value;
	}

	@Override
	public void execute()
	{
		final boolean success = phoneRecord.setField(field, value);
		if (!success)
		{
			ui.showWrongFieldValue(field);
		}
	}
}
