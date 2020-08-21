package com.company.command;

import com.company.command.base.AbstractUIAwareCommand;
import com.company.ui.step.Step;

public class ChangeUIStepCommand extends CommandArray
{
	public ChangeUIStepCommand(Step nextStep)
	{
		super(new SetUIStepCommand(nextStep), nextStep.run());
	}

	private static class SetUIStepCommand extends AbstractUIAwareCommand
	{
		private final Step nextStep;

		private SetUIStepCommand(Step nextStep) {this.nextStep = nextStep;}

		@Override
		public void execute()
		{
			ui.setStep(nextStep);
		}
	}

}

