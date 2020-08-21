package com.company.ui.step;

import com.company.command.AddRecordCommand;
import com.company.command.ChangeUIStepCommand;
import com.company.command.CommandArray;
import com.company.command.base.Command;
import com.company.model.OrganizationRecord;
import com.company.model.PersonRecord;
import com.company.model.PhoneRecord;

public class AddPhoneRecordMenuStep extends AbstractInputStep
{
	@Override
	protected String getPrompt()
	{
		return "Enter the type (person, organization):";
	}

	@Override
	public Command process(String input)
	{
		switch (input)
		{
			case "person":
				return getFillRecordCommand(new PersonRecord());
			case "organization":
				return getFillRecordCommand(new OrganizationRecord());
			default:
				return run();
		}
	}

	private Command getFillRecordCommand(PhoneRecord phoneRecord)
	{
		return new ChangeUIStepCommand(
			new FillPhoneRecordFieldsStep(
				phoneRecord,
				phoneRecord.getFields(),
				new CommandArray(new AddRecordCommand(phoneRecord),
				                 new ChangeUIStepCommand(new MainMenuStep())))
		);
	}
}
