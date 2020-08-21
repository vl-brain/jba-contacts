package com.company.ui.step;

import com.company.command.*;
import com.company.command.base.Command;
import com.company.model.PhoneRecord;

import java.util.List;

public class ListMenuStep extends AbstractMenuStep
{
	protected List<PhoneRecord> phoneBookRecords;

	@Override
	public Command run()
	{
		return new CommandArray(
			getPhoneRecordsCommand(),
			getShowPhoneBookRecordsCommand(),
			super.run()
		);
	}

	protected Command getPhoneRecordsCommand()
	{
		return new GetAllPhoneRecordsCommand(this::setPhoneBookRecords);
	}

	protected Command getShowPhoneBookRecordsCommand()
	{
		return new ShowPhoneBookRecordsCommand(this::getPhoneBookRecords);
	}

	@Override
	protected String getPrompt()
	{
		return "[list] Enter action ([number], back):";
	}

	@Override
	public Command process(String input)
	{
		if ("back".equals(input))
		{
			return new ChangeUIStepCommand(new MainMenuStep());
		}
		if (hasListItem(input))
		{
			final int listIndex = getListIndex(input);
			final int phoneRecordIndex = getPhoneRecordIndex(listIndex);
			return new ChangeUIStepCommand(new PhoneRecordMenuStep(phoneRecordIndex));
		}
		return super.run();
	}

	private boolean hasListItem(String number)
	{
		if (number.matches("\\d+"))
		{
			int index = getListIndex(number);
			return 0 <= index && index < phoneBookRecords.size();
		}
		return false;
	}

	private int getListIndex(String number)
	{
		return Integer.parseInt(number) - 1;
	}

	protected int getPhoneRecordIndex(int listIndex)
	{
		return listIndex;
	}

	protected List<PhoneRecord> getPhoneBookRecords()
	{
		return phoneBookRecords;
	}

	protected void setPhoneBookRecords(List<PhoneRecord> phoneBookRecords)
	{
		this.phoneBookRecords = phoneBookRecords;
	}
}
