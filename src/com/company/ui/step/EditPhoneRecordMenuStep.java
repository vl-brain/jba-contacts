package com.company.ui.step;

import com.company.command.*;
import com.company.command.base.Command;
import com.company.model.PhoneRecord;

import java.util.Collections;

public class EditPhoneRecordMenuStep extends AbstractMenuStep
{
	private final int index;
	private PhoneRecord phoneRecord;

	public EditPhoneRecordMenuStep(int index) {this.index = index;}

	@Override
	public Command run()
	{
		return new CommandArray(
			new GetPhoneRecordCommand(index, this::setPhoneRecord),
			super.run()
		);
	}

	@Override
	protected Command getShowPromptCommand()
	{
		return new ShowPromptLazyCommand(this::getPrompt);
	}

	@Override
	protected String getPrompt()
	{
		return "Select a field (" + String.join(", ", phoneRecord.getFields()) + "):";
	}

	@Override
	public Command process(String input)
	{
		if (phoneRecord.getFields().contains(input))
		{
			return new ChangeUIStepCommand(
				new FillPhoneRecordFieldsStep(
					phoneRecord,
					Collections.singletonList(input),
					new CommandArray(
						new UpdateRecordCommand(index, phoneRecord),
						new ChangeUIStepCommand(new PhoneRecordMenuStep(index))
					)
				)
			);
		}
		return super.run();
	}

	private void setPhoneRecord(PhoneRecord phoneRecord)
	{
		this.phoneRecord = phoneRecord;
	}
}
