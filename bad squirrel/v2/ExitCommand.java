package com.mycompany.commands;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;

public class ExitCommand extends Command {
	public ExitCommand() {
		super("Exit");
	}
	
	public void actionPerformed(ActionEvent evt) {
		if(Dialog.show("Exit", "Are you sure you want to exit?", "Yes", "No")) {
			System.exit(0);
		}
	}
}