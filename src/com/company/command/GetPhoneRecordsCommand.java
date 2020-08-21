package com.company.command;

import com.company.command.base.AbstractServiceAwareCommand;
import com.company.model.PhoneRecord;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class GetPhoneRecordsCommand extends AbstractServiceAwareCommand
{
	private final Supplier<int[]> indexesSupplier;
	private final Consumer<List<PhoneRecord>> receiver;

	public GetPhoneRecordsCommand(Supplier<int[]> indexesSupplier, Consumer<List<PhoneRecord>> receiver) {
		this.indexesSupplier = indexesSupplier;
		this.receiver = receiver;
	}

	@Override
	public void execute()
	{
		final List<PhoneRecord> phoneBookRecords = service.getPhoneBookRecords(indexesSupplier.get());
		receiver.accept(phoneBookRecords);
	}
}
