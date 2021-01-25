package com.mycompany.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.TextField;
import com.codename1.ui.Dialog;
import com.mycompany.a2.GameWorld;

public class CollideNutCommand extends Command {
	private GameWorld gw;
	
	public CollideNutCommand(GameWorld gw) {
		super("Collide Nut");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent evt) {
		Command cOk = new Command("OK");
		Command cCancel = new Command("Cancel");
		Command[] commands = new Command[]{cOk, cCancel};
		TextField textField = new TextField();
		Command c = Dialog.show("Enter last nut reached:", textField, commands);
		if(c == cOk) {
			if(textField.getText().equals("1")) {
				gw.collisionSquirrelWithNut(1);
			}
			else if(textField.getText().equals("2")) {
				gw.collisionSquirrelWithNut(2);
			}
			else if(textField.getText().equals("3")) {
				gw.collisionSquirrelWithNut(3);
			}
			else if(textField.getText().equals("4")) {
				gw.collisionSquirrelWithNut(4);
			}
			else {
				System.out.println("\nThat nut does not exist!");
			}
		}
		else {
		}
	}
}