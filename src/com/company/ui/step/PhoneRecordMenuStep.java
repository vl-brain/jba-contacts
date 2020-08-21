package com.company.ui.step;

import com.company.command.ChangeUIStepCommand;
import com.company.command.CommandArray;
import com.company.command.DeleteRecordCommand;
import com.company.command.ShowPhoneBookRecordCommand;
import com.company.command.base.Command;

public class PhoneRecordMenuStep extends AbstractMenuStep
{
	private final int index;

	public PhoneRecordMenuStep(int index) {this.index = index;}

	@Override
	public Command run()
	{
		return new CommandArray(
			new ShowPhoneBookRecordCommand(index),
			super.run()
		);
	}

	@Override
	protected String getPrompt()
	{
		return "[record] Enter action (edit, delete, menu):";
	}

	@Override
	public Command process(String input)
	{
		switch (input)
		{
			case "menu":
				return new ChangeUIStepCommand(new MainMenuStep());
			case "edit":
				return new ChangeUIStepCommand(
					new EditPhoneRecordMenuStep(index)
				);
			case "delete":
				return new CommandArray(
					new DeleteRecordCommand(index),
					new ChangeUIStepCommand(new MainMenuStep())
				);
			default:
				return super.run();
		}
	}

}
