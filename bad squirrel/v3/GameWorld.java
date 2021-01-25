package com.mycompany.a3;

import java.util.Observable;

import com.codename1.ui.Dialog;

/**
 * Builds the game "board" or world and populates
 * it with the various objects
 *
 * @param GameObjectCollection gameObjects holds all the child objects
 * within its encapsulated class
 * @param int lives is used to keep track of how many 
 * lives the  player has remaining
 * @param int clock keeps track of the "time" within
 * the game world by ticking up every turn
 * @param boolean sound keeps track of whether 
 * sound is ON or OFF
 * @param double width keeps track of the width of GameWorld
 * @param double height keeps track  of the height of GameWorld
 */

public class GameWorld extends Observable{
	private GameObjectCollection gameObjects;
	private static int lives = 3;
	private static int clock = 0;
	private boolean sound = false;
	private Sound eatingSound = new Sound("Eating Tomato.wav");
	private Sound crashingSound = new Sound("Squirrels Collide.mp3");
	private Sound sadSound = new Sound("Life Lost.wav");
	private double gwHeight;
	private double gwWidth;
	
	/**
	 * Calls the initializer method to spawn the
	 * game objects within the world
	 */
	
	public GameWorld() {
		init();
	}
	
	/**
	 * In this version of the game, the world
	 * holds exactly four Nuts, two Tomatoes,
	 * one PlayerSquirrel, three NonPlayerSquirrels,
	 * and two Birds.
	 */
	
	public void init() {
		gameObjects = new GameObjectCollection();
		gameObjects.add(new Nut(250.0, 250.0, 1));
		gameObjects.add(new Nut(250.0, 750.0, 2));
		gameObjects.add(new Nut(750.0, 750.0, 3));
		gameObjects.add(new Nut(750.0, 250.0, 4));
		gameObjects.add(new Tomato());
		gameObjects.add(new Tomato());
		gameObjects.add(new NonPlayerSquirrel());
		gameObjects.add(new NonPlayerSquirrel());
		gameObjects.add(new NonPlayerSquirrel());
		gameObjects.add(new Bird());
		gameObjects.add(new Bird());
		gameObjects.add(PlayerSquirrel.getPlayerSquirrel());
		setChanged();
		notifyObservers(this);
	}
	
	/**
	 *  These methods determine the type of the object 
 	 *  in the GameObjectCollection and proceed with
	 *  actions accordingly.
	 */
	
	public void acceleratePlayerSquirrel() {
		System.out.println("\nPlayer squirrel accelerating.");
		for(int i = 0; i < gameObjects.size(); i++) {
			if(gameObjects.get(i) instanceof PlayerSquirrel) {
				PlayerSquirrel curSquirrel = (PlayerSquirrel) gameObjects.get(i);
				curSquirrel.setSpeed(2);
			}
		}
		setChanged();
		notifyObservers(this);
	}
	
	public void brakePlayerSquirrel() {
		System.out.println("\nPlayer squirrel braking.");
		for(int i = 0; i < gameObjects.size(); i++) {
			if(gameObjects.get(i) instanceof PlayerSquirrel) {
				PlayerSquirrel curSquirrel = (PlayerSquirrel) gameObjects.get(i);
				curSquirrel.setSpeed(-2);
			}
			else {
				
			}
		}
		setChanged();
		notifyObservers(this);
	}
	
	public void turnPlayerSquirrelLeft() {
		System.out.println("\nPlayer squirrel turning left.");
		for(int i = 0; i < gameObjects.size(); i++) {
			if(gameObjects.get(i) instanceof PlayerSquirrel) {
				PlayerSquirrel curSquirrel = (PlayerSquirrel) gameObjects.get(i);
				curSquirrel.steer(-5);  //  applies a turn of negative 5 degrees
			}
			else {
			}	
		}
		setChanged();
		notifyObservers(this);
	}
		
	public void turnPlayerSquirrelRight() {
		System.out.println("\nPlayer squirrel turning right.");
		for(int i = 0; i < gameObjects.size(); i++) {
			if(gameObjects.get(i) instanceof PlayerSquirrel) {
				PlayerSquirrel curSquirrel = (PlayerSquirrel) gameObjects.get(i);
				curSquirrel.steer(5);  //  applies a turn of positive 5 degrees
			}
			else {
			}	
		}
		setChanged();
		notifyObservers(this);
	}
	
	public void collisionSquirrelWithSquirrel(Squirrel s) {
		System.out.println("\nSquirrel has collided with another squirrel.");
		s.setDamageLevel(2);
		int curDmg = s.getDamageLevel();
		s.setColor(140 + (12 * curDmg), 70 + (5 * curDmg), 20 + (3 * curDmg)); //  lightens color based on damage
		if(sound && !(s.getCollisionVector().contains(this))) {
			crashingSound.play();
		}
		setChanged();
		notifyObservers(this);
	}
	
	public void collisionSquirrelWithNut(Squirrel s, Nut n) {
		System.out.println("\nSquirrel has collided with Nut #" + n.getSequenceNumber());
			if(n.getSequenceNumber() == (s.getLastNutReached() + 1)) {    //  checks if the Nut reached was one higher than the last
				s.setLastNutReached(n.getSequenceNumber());               //  in order to progress the player through the objectives
			}
			else {
			}	
		setChanged();
		notifyObservers(this);
	}
	
	public void collisionSquirrelWithTomato(Squirrel s, Tomato t) {
		if(t.getNutrition() != 0) {
			System.out.println("\nSquirrel has collided with a tomato.");
			s.setEnergyLevel(t.getNutrition());            // increases Squirrel's energy by the Tomato's nutrition
			t.setColor(255, 200, 200);                     // fades color of the Tomato
			t.resetNutrition();
			setChanged();
			notifyObservers(this);
			Tomato spawnedTomato = new Tomato();
			gameObjects.add(spawnedTomato);
			if(sound) {
				eatingSound.play();
			}
			setChanged();
			notifyObservers(this);
		}
	}
	
	public void collisionSquirrelWithBird(Squirrel s) {
		System.out.println("\nSquirrel has collided with a bird.");
		s.setDamageLevel(1);                                                   //  does half the damage of another Squirrel
		int curDmg = s.getDamageLevel();
		s.setColor(140 + (10 * curDmg), 70 + (4 * curDmg), 20 + (2 * curDmg)); //  lightens color based on damage
		setChanged();
		notifyObservers(this);
	}
	
	/**
	 * This method is used to progress the game and move all
	 * the objects that are movable. It keeps track of the time
	 * and also the win/loss conditions upon which it will terminate
	 * the game.
	 */
	
	public void clockTick(int elapsedTime) {                          
		System.out.println("\nClock has ticked once.");
		for(int i = 0; i < gameObjects.size(); i++) {
			if(gameObjects.get(i) instanceof PlayerSquirrel) {
				PlayerSquirrel curSquirrel = (PlayerSquirrel) gameObjects.get(i);
				curSquirrel.setHeading(curSquirrel.getSteeringDirection());  //  applies the steering direction to the heading
				if(curSquirrel.getDamageLevel() == curSquirrel.getMaxDamageLevel() || curSquirrel.getSpeed() == 0 || curSquirrel.getEnergyLevel() == 0) {
					lives--;
					if(lives == 0) {
						System.out.println("\nGame over, you failed!");  //  failed because of no more lives
						Dialog.show("Sorry!", "Game over, you failed!", "OK", null);
						System.exit(0);
					}
					curSquirrel.deleteSquirrel();
					gameObjects.add(PlayerSquirrel.getPlayerSquirrel());			     // adds a new PlayerSquirrel to replace the lost one
					gameObjects.remove(curSquirrel);                                     // removes the old PlayerSquirrel
					if(sound) {
						sadSound.play();
					}
				}
			    else if(curSquirrel.getLastNutReached() == 4) {
					
					System.out.println("\nGame over, you won! Time: " + clock + " ticks"); //  won because of reaching all the nuts
					setChanged();
					notifyObservers(this);
					Dialog.show("Congratulations!", "Game over, you won! Time: " + clock + " ticks", "OK", null);
					System.exit(0);
				}
				else {
					curSquirrel.move(elapsedTime);                                   //  no win or loss condition progresses the game like normal
					curSquirrel.setEnergyLevel(curSquirrel.energyConsumptionRate);
				}
			}
			else if(gameObjects.get(i) instanceof NonPlayerSquirrel) {
				NonPlayerSquirrel curSquirrel = (NonPlayerSquirrel) gameObjects.get(i);
				curSquirrel.setHeading(curSquirrel.getSteeringDirection());
				if(curSquirrel.getDamageLevel() == curSquirrel.getMaxDamageLevel()) {
					gameObjects.remove(curSquirrel);                      // removes this NonPlayerSquirrel if max damage is reached
				}
                else if(curSquirrel.getLastNutReached() == 4) {
					System.out.println("\nGame over, enemy Squirrel won! Time: " + clock + " ticks");
					Dialog.show("Sorry!", "Game over, a non-player Squirrel wins!", "OK", null);
					System.exit(0);
				}
                else {
                	curSquirrel.invokeStrategy();                                // invokes the currently held strategy
                	curSquirrel.setHeading(curSquirrel.getSteeringDirection());  // applies steering direction to heading
                	curSquirrel.move(elapsedTime);
                }
			}
			else if(gameObjects.get(i) instanceof MovableGameObject) {
				MovableGameObject movingObject = (MovableGameObject) gameObjects.get(i);
				movingObject.move(elapsedTime);                                             // moves all MovableGameObjects
			}
			else {
			}
		}
		collisionCheck();
		clock += elapsedTime;
		setChanged();
		notifyObservers(this);
	}
	
	public void switchStrategy() {                     // this method switches the strategy of NonPlayerSquirrels
		for(int i = 0; i < gameObjects.size(); i++) {
			if(gameObjects.get(i) instanceof NonPlayerSquirrel) {
				NonPlayerSquirrel curSquirrel = (NonPlayerSquirrel) gameObjects.get(i);
				if(curSquirrel.getStrategy() instanceof AttackStrategy) {
					curSquirrel.setStrategy(new NutStrategy(curSquirrel));
				}
				else {
					curSquirrel.setStrategy(new AttackStrategy(curSquirrel));
				}
			}
		}
		setChanged();
		notifyObservers(this);
	}
	
	public void displayStats() {                                   //  displays some Squirrel and game state data (deprecated)
		System.out.println("\nLives remaining: " + lives);
		if(clock == 1) {
			System.out.println("Elapsed time: " + clock + " tick");
		}
		else {
			System.out.println("Elapsed time: " + clock + " ticks");

		}
		int latestNutNumber = 0;
		int energyLevel = 0;
		int damageLevel = 0;
		for(int i = 0; i < gameObjects.size(); i++) {
			if(gameObjects.get(i) instanceof Squirrel) {
				Squirrel curSquirrel = (Squirrel) gameObjects.get(i);  //  obtains the most current values held in the Squirrel
				latestNutNumber = curSquirrel.getLastNutReached();
				energyLevel = curSquirrel.getEnergyLevel();
				damageLevel = curSquirrel.getDamageLevel();
			}
			else {
			}
		}
		System.out.println("Highest sequential nut reached: Nut #" + latestNutNumber);
		System.out.println("Squirrel's energy level: " + energyLevel);
		System.out.println("Squirrel's damage level: " + damageLevel);
	}
	
	public void displayMap() {                //  prints a  "map" showing the coordinates of all the game objects
		System.out.println();
		for(int i = 0; i < gameObjects.size(); i++) {
			System.out.println(gameObjects.get(i));
		}
	}
	
	public void exit() {                      // shuts down the game
		System.out.print("\nGoodbye, thanks for playing! :-)");
		System.exit(0);
	}
	
	private void collisionCheck() {
		IIterator itr = gameObjects.getIterator();
		while(itr.hasNext()) {
			GameObject thisObject = itr.getNext();
			IIterator tempItr = gameObjects.getIterator();
			while(tempItr.hasNext()) {
				GameObject otherObject = tempItr.getNext();
				if(!(thisObject.equals(otherObject))) {
					if(thisObject.collidesWith(otherObject)) {
						thisObject.handleCollision(otherObject);
						if(thisObject instanceof PlayerSquirrel) {
							if(thisObject.getCollided() == 's') {
								NonPlayerSquirrel otherSquirrel = (NonPlayerSquirrel) otherObject;
								collisionSquirrelWithSquirrel(otherSquirrel);
							}
							else if(thisObject.getCollided() == 'b') {
								PlayerSquirrel thisSquirrel = (PlayerSquirrel) thisObject;
								collisionSquirrelWithBird(thisSquirrel);
							}
							else if(thisObject.getCollided() == 'n') {
								Nut otherNut = (Nut) otherObject;
								PlayerSquirrel thisSquirrel = (PlayerSquirrel) thisObject;
								collisionSquirrelWithNut(thisSquirrel, otherNut);
							}
							else if(thisObject.getCollided() == 't') {
								Tomato otherTomato = (Tomato) otherObject;
								PlayerSquirrel thisSquirrel = (PlayerSquirrel) thisObject;
								collisionSquirrelWithTomato(thisSquirrel, otherTomato);
							}
						}
						else if(thisObject instanceof NonPlayerSquirrel) {
							if(thisObject.getCollided() == 's') {
								Squirrel otherSquirrel = (Squirrel) otherObject;
								collisionSquirrelWithSquirrel(otherSquirrel);
							}
							else if(thisObject.getCollided() == 'b') {
								NonPlayerSquirrel thisSquirrel = (NonPlayerSquirrel) thisObject;
								collisionSquirrelWithBird(thisSquirrel);
							}
							else if(thisObject.getCollided() == 'n') {
								Nut otherNut = (Nut) otherObject;
								NonPlayerSquirrel thisSquirrel = (NonPlayerSquirrel) thisObject;
								collisionSquirrelWithNut(thisSquirrel, otherNut);
							}
							else if(thisObject.getCollided() == 't') {
								Tomato otherTomato = (Tomato) otherObject;
								NonPlayerSquirrel thisSquirrel = (NonPlayerSquirrel) thisObject;
								collisionSquirrelWithTomato(thisSquirrel, otherTomato);
							}
						}
					}
				}
			}
		}
		setChanged();
		notifyObservers(this);
	}
	
	public void positionChanger() {
		IIterator itr = gameObjects.getIterator();
		while(itr.hasNext()) {
			GameObject thisObject = itr.getNext();
			if(thisObject instanceof ISelectable) {
				ISelectable selObject = (ISelectable) thisObject;
				//  remainder of code here to obtain the pointer pressed location and move the object there
			}
		}
		setChanged();
		notifyObservers(this);
	}
	
	public boolean getSound() {
		return sound;
	}
	
	public void setSound(boolean toggle) {
		sound = toggle;
		setChanged();
		notifyObservers(this);
	}
	
	public int getLives() {
		return lives;
	}
	
	public int getClock() {
		return clock;
	}
	
	public int getLastNut() {
		for(int i = 0; i < gameObjects.size(); i++) {
			if(gameObjects.get(i) instanceof PlayerSquirrel) {
				PlayerSquirrel curSquirrel = (PlayerSquirrel) gameObjects.get(i);
				return curSquirrel.getLastNutReached();
			}
		}
		return 0;
	}
	
	public int getEnergy() {
		for(int i = 0; i < gameObjects.size(); i++) {
			if(gameObjects.get(i) instanceof PlayerSquirrel) {
				PlayerSquirrel curSquirrel = (PlayerSquirrel) gameObjects.get(i);
				return curSquirrel.getEnergyLevel();
			}
		}
		return 0;
	}
	
	public int getDamage() {
		for(int i = 0; i < gameObjects.size(); i++) {
			if(gameObjects.get(i) instanceof PlayerSquirrel) {
				PlayerSquirrel curSquirrel = (PlayerSquirrel) gameObjects.get(i);
				return curSquirrel.getDamageLevel();
			}
		}
		return 0;
	}
	
	public GameObjectCollection getCollection() {
		return gameObjects;
	}
	
	public void setHeight(double mapHeight) {
		gwHeight = mapHeight;
	}
	
	public void setWidth(double mapWidth) {
	    gwWidth = mapWidth;
	}
}
