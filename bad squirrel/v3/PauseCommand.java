package com.mycompany.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.Game;

public class PauseCommand extends Command{
	Game myGame;
	
	public PauseCommand(Game theGame) {
		super("Pause");
		myGame = theGame;
	}
	
	public void actionPerformed(ActionEvent evt) {
		myGame.pauseSwitch();
	}
}
