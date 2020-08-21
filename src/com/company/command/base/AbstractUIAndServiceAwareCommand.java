package com.company.command.base;

import com.company.service.PhoneBookService;

public abstract class AbstractUIAndServiceAwareCommand extends AbstractUIAwareCommand
	implements PhoneBookServiceAwareCommand
{
	protected PhoneBookService service;

	@Override
	public void setService(PhoneBookService service)
	{
		this.service = service;
	}

}
