package com.mycompany.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorld;

public class LeftTurnCommand extends Command {
	private GameWorld gw;
	
	public LeftTurnCommand(GameWorld gw) {
		super("Left");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent evt) {
		gw.turnPlayerSquirrelLeft();
	}
}