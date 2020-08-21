package com.company.command.base;

import com.company.ui.PhoneBookUI;

public abstract class AbstractUIAwareCommand implements PhoneBookUIAwareCommand
{
	protected PhoneBookUI ui;

	@Override
	public void setUi(PhoneBookUI ui)
	{
		this.ui = ui;
	}

}
