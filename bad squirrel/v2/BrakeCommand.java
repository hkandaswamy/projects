package com.mycompany.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class BrakeCommand extends Command{
	private GameWorld gw;
	
	public BrakeCommand(GameWorld gw) {
		super("Brake");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent evt) {
		gw.brakePlayerSquirrel();
	}
}