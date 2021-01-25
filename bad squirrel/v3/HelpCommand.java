package com.mycompany.commands;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;

public class HelpCommand extends Command {	
	public HelpCommand() {
		super("Help");
	}
	
	public void actionPerformed(ActionEvent evt) {
		String details = "a - Accelerate\nb - Brake\nl - Left Turn\nr - RightTurn \ne - Collide Tomato \ng - Collide Bird \nt - Tick";
		Dialog.show("Help", details, "OK", null);
	}
}