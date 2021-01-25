package com.mycompany.commands;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;

public class AboutCommand extends Command {	
	public AboutCommand() {
		super("About");
	}
	
	public void actionPerformed(ActionEvent evt) {
		String details = "Harish Kandaswamy\nBad Squirrel! v2.0\nCSUS - CSC 133\nOctober 2020";
		Dialog.show("About", details, "OK", null);
	}
}