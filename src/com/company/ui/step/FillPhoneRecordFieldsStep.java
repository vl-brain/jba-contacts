package com.company.ui.step;

import com.company.command.CommandArray;
import com.company.command.SetRecordFieldCommand;
import com.company.command.ShowPromptCommand;
import com.company.command.base.Command;
import com.company.model.PhoneRecord;

import java.util.Iterator;
import java.util.List;

public class FillPhoneRecordFieldsStep extends AbstractInputStep
{
	private final PhoneRecord phoneRecord;
	private final Command completeCommand;
	private final Iterator<String> fieldIterator;
	private String field;

	public FillPhoneRecordFieldsStep(PhoneRecord phoneRecord, List<String> fields, Command completeCommand)
	{
		this.phoneRecord = phoneRecord;
		this.fieldIterator = fields.iterator();
		this.field = fieldIterator.next();
		this.completeCommand = completeCommand;
	}

	@Override
	protected String getPrompt()
	{
		return "Enter " + field + ":";
	}

	@Override
	public Command process(String input)
	{
		String inputField = field;
		if (fieldIterator.hasNext())
		{
			field = fieldIterator.next();
			return new CommandArray(
				new SetRecordFieldCommand(phoneRecord, inputField, input),
				new ShowPromptCommand(getPrompt())
			);
		}
		return new CommandArray(
			new SetRecordFieldCommand(phoneRecord, inputField, input),
			completeCommand
		);
	}
}
