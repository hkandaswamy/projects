package com.mycompany.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class CollideBirdCommand extends Command {
	private GameWorld gw;
	
	public CollideBirdCommand(GameWorld gw) {
		super("Collide Bird");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent evt) {
		gw.collisionSquirrelWithBird();
	}
}