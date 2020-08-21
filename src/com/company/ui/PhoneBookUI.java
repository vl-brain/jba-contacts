package com.company.ui;

import com.company.command.base.Command;
import com.company.model.PhoneRecord;
import com.company.ui.step.MainMenuStep;
import com.company.ui.step.OffStep;
import com.company.ui.step.Step;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PhoneBookUI
{
	private Step step = new MainMenuStep();

	public void setStep(Step step)
	{
		this.step = step;
	}

	public Command run()
	{
		return step.run();
	}

	public Command process(String input)
	{
		return step.process(input);
	}

	public void showMessage(String message)
	{
		System.out.print(message);
	}

	public void showMessageLine()
	{
		System.out.println();
	}

	public void showMessageLine(String message)
	{
		System.out.println(message);
	}

	public void showPhoneBookRecord(PhoneRecord phoneRecord)
	{
		if (phoneRecord != null)
		{
			showMessage(phoneRecord.toString());
		}
	}

	public void showPhoneBookRecords(List<PhoneRecord> phoneRecords)
	{
		showMessageLine(phoneRecords.isEmpty() ? "No records!" :
			IntStream.range(0, phoneRecords.size())
				.mapToObj(i -> (i + 1) + ". " + phoneRecords.get(i).getShortInfo())
				.collect(Collectors.joining("\n")));
	}

	public void showPhoneBookRecordCount(int count)
	{
		showMessageLine("The Phone Book has " + count + " records.");
	}

	public void showWrongFieldValue(String fieldName)
	{
		switch (fieldName)
		{
			case "number":
				showWrongNumberFormat();
				break;
			case "birth":
				showBadBirthDay();
				break;
			case "gender":
				showBadGender();
				break;
		}
	}

	public void showWrongNumberFormat()
	{
		showMessageLine("Wrong number format!");
	}

	public void showBadBirthDay()
	{
		showMessageLine("Bad birth date!");
	}

	public void showBadGender()
	{
		showMessageLine("Bad gender!");
	}

	public void showAddPhoneBookRecord()
	{
		showMessageLine("The record added.");
	}

	public void showDeletePhoneBookRecord()
	{
		showMessageLine("The record removed!");
	}

	public void showUpdatePhoneBookRecord()
	{
		showMessageLine("Saved");
	}

	public void showFoundSearchPhoneBookRecordCount(int count)
	{
		showMessageLine("Found " + count + " results:");
	}

	public boolean isActive()
	{
		return step != OffStep.INSTANCE;
	}
}
