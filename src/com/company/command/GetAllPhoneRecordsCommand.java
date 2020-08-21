package com.company.command;

import com.company.command.base.AbstractServiceAwareCommand;
import com.company.model.PhoneRecord;

import java.util.List;
import java.util.function.Consumer;

public class GetAllPhoneRecordsCommand extends AbstractServiceAwareCommand
{
	private final Consumer<List<PhoneRecord>> receiver;

	public GetAllPhoneRecordsCommand(Consumer<List<PhoneRecord>> receiver) {
		this.receiver = receiver;
	}

	@Override
	public void execute()
	{
		final List<PhoneRecord> phoneBookRecords = service.getPhoneBookRecords();
		receiver.accept(phoneBookRecords);
	}
}
