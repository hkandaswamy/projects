package com.mycompany.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class AccelerateCommand extends Command {
	private GameWorld gw;
	
	public AccelerateCommand(GameWorld gw) {
		super("Accelerate");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent evt) {
		gw.acceleratePlayerSquirrel();
	}
}