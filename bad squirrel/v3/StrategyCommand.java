package com.mycompany.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorld;

public class StrategyCommand extends Command {
	private GameWorld gw;
	
	public StrategyCommand(GameWorld gw) {
		super("Strategy");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent evt) {
		gw.switchStrategy();
	}
}