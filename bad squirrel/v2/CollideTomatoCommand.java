package com.mycompany.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class CollideTomatoCommand extends Command {
	private GameWorld gw;
	
	public CollideTomatoCommand(GameWorld gw) {
		super("Collide Tomato");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent evt) {
		gw.collisionSquirrelWithTomato();
	}
}