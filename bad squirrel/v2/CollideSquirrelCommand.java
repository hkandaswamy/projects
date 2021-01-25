package com.mycompany.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class CollideSquirrelCommand extends Command {
	private GameWorld gw;
	
	public CollideSquirrelCommand(GameWorld gw) {
		super("Collide Squirrel");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent evt) {
		gw.collisionSquirrelWithSquirrel();
	}
}