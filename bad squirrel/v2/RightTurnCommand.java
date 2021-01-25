package com.mycompany.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class RightTurnCommand extends Command {
	private GameWorld gw;
	
	public RightTurnCommand(GameWorld gw) {
		super("Right");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent evt) {
		gw.turnPlayerSquirrelRight();
	}
}