package com.company.command.base;

import com.company.ui.PhoneBookUI;

public interface PhoneBookUIAwareCommand extends Command
{
	void setUi(PhoneBookUI ui);
}
