package com.company.command;

import com.company.command.base.AbstractServiceAwareCommand;
import com.company.model.PhoneRecord;

import java.util.function.Consumer;

public class GetPhoneRecordCommand extends AbstractServiceAwareCommand
{
	private final int index;
	private final Consumer<PhoneRecord> receiver;

	public GetPhoneRecordCommand(int index, Consumer<PhoneRecord> receiver) {
		this.index = index;
		this.receiver = receiver;
	}

	@Override
	public void execute()
	{
		final PhoneRecord phoneBookRecord = service.getPhoneBookRecord(index);
		receiver.accept(phoneBookRecord);
	}
}
