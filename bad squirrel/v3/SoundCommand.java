package com.mycompany.commands;

import com.codename1.ui.CheckBox;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorld;

public class SoundCommand extends Command {
	private GameWorld gw;
	private boolean toggle;
	private CheckBox soundBox;
	
	public SoundCommand(GameWorld gw, CheckBox soundBox) {
		super("Sound");
		this.gw = gw;
		this.soundBox = soundBox;
	}
	
	public void actionPerformed(ActionEvent evt) {
		if(soundBox.isSelected()) {
			toggle = true;
			System.out.println("\nSound is now ON.");
		}
		else {
			toggle = false;
			System.out.println("\nSound is now OFF.");
		}
		gw.setSound(toggle);
	}
}