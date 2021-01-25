package com.mycompany.a1;

import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.events.ActionEvent;
import java.lang.String;

/**
 * Builds an instance of the game
 * using its connections to the other classes.
 *
 * @param GameWorld gw holds the game "board"
 * @param boolean quitting this is used as a flag
 * to signal to the listeners that the user wishes
 * to quit the game, thus locking them out of the
 * other options
 */
public class Game extends Form {
	
	private GameWorld gw;
	boolean quitting = false;
	
	public Game() {
		gw = new GameWorld();
		play();
	}
	
	/**
     * Begins the play sequence for the game and uses
     * listeners to read player input and determine
     * the proper response.
     * 
     * @param Label myLabel used to label the prompt 
     * within the simulator
     */
	
	private void play() {
		Label myLabel = new Label("Enter a Command: ");
		this.addComponent(myLabel);
		final TextField myTextField = new TextField();
		this.addComponent(myTextField);
		this.show();
		myTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				String sCommand = myTextField.getText().toString();
				myTextField.clear();
				if(sCommand.length() != 0) {
					switch (sCommand.charAt(0)) {
						case 'x':
							if(!quitting) {    // user cannot respond with anything other than y/n
								quitting = true;
								System.out.println("\nAre you sure you want to quit? y/n");
							}
							break;
						case 'y':              // program quits with user confirmation
							if(quitting) {  
								gw.exit();
							}
							break;
						case 'n':               // used to return the game from the "quit state"
							if(quitting) {  
								quitting = false;
								System.out.println("\nDid not quit, returning to game.");
								break;
							}
						case 'a':               // used to accelerate the player Squirrel by a small amount
							if(!quitting) {     
								gw.acceleratePlayerSquirrel();
								break;
							}
						case 'b':               // used to brake the player Squirrel by a small amount
							if(!quitting) {
								gw.brakePlayerSquirrel();
								break;
							}
						case 'l':               // turns the Squirrel left 5 degrees
							if(!quitting) {
								gw.turnPlayerSquirrelLeft();
								break;
							}
						case 'r':               //  turns the Squirrel right 5 degrees
							if(!quitting) {
								gw.turnPlayerSquirrelRight();
								break;
							}
						case 'c':               //  calculations for collision with another Squirrel object
							if(!quitting) {
								gw.collisionSquirrelWithSquirrel();
								break;
							}
						case '1':				// calculations for collision with a Nut object
							if(!quitting) {     // the int parameter tells the program which nut it is
								gw.collisionSquirrelWithNut(1);
								break;
							}
						case '2': 
							if(!quitting) {
								gw.collisionSquirrelWithNut(2);
								break;
							}
						case '3':
							if(!quitting) {
								gw.collisionSquirrelWithNut(3);
								break;
							}
						case '4':
							if(!quitting) {
								gw.collisionSquirrelWithNut(4);
								break;
							}
						case '5':
							if(!quitting) {
								gw.collisionSquirrelWithNut(5);
								break;
							}
						case '6':
							if(!quitting) {
								gw.collisionSquirrelWithNut(6);
								break;
							}
						case '7':
							if(!quitting) {
								gw.collisionSquirrelWithNut(7);
								break;
							}
						case '8':
							if(!quitting) {
								gw.collisionSquirrelWithNut(8);
								break;
							}
						case '9':
							if(!quitting) {
								gw.collisionSquirrelWithNut(9);
								break;
							}
						case 'e':
							if(!quitting) {
								gw.collisionSquirrelWithTomato(new Tomato());	
								break;
							}
						case 'g':                 //  calculations for collision with a Bird object
							if(!quitting) {
								gw.collisionSquirrelWithBird();
								break;
							}
						case 't':                 //  ticks the game clock up by one
							if(!quitting) {
								gw.clockTick();
								break;
							}
						case 'd':                 //  displays stats of the Squirrel and some state variables
							if(!quitting) {
								gw.displayStats();
								break;
							}
						case 'm':                 // shows a "map" of locations of all the objects
							if(!quitting) {
								gw.displayMap();
								break;
							}
						default:                  //  if user enters a char not listed above they get an error
							System.out.println("\nInvalid command.");
							break;
					}  //switch
				}  //sCommand null check
			}  //actionPerformed()
		}  //new ActionListener()
		); //addActionListener
	} //play()
}