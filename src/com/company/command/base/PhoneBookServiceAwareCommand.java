package com.company.command.base;

import com.company.service.PhoneBookService;

public interface PhoneBookServiceAwareCommand extends Command
{
	void setService(PhoneBookService service);
}
