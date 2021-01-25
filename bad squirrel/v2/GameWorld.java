package com.mycompany.a2;

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
	private boolean sound = false;;
	private double width;
	private double height;
	
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
	
	public void collisionSquirrelWithSquirrel() {
		System.out.println("\nSquirrel has collided with another squirrel.");
		boolean flag = true;
		for(int i = 0; i < gameObjects.size(); i++) {
			if(gameObjects.get(i) instanceof PlayerSquirrel) {
				PlayerSquirrel curSquirrel = (PlayerSquirrel) gameObjects.get(i);
				curSquirrel.setDamageLevel(2);
				int curDmg = curSquirrel.getDamageLevel();
				curSquirrel.setColor(140 + (12 * curDmg), 70 + (5 * curDmg), 20 + (3 * curDmg)); //  lightens color based on damage
			}
			else if(gameObjects.get(i) instanceof NonPlayerSquirrel){
				NonPlayerSquirrel curSquirrel = (NonPlayerSquirrel) gameObjects.get(i);
				if(flag) {
					if(curSquirrel.getDamageLevel() != 20) {
						curSquirrel.setDamageLevel(2);
						flag = false;
					}
					else {
					}
					int curDmg = curSquirrel.getDamageLevel();
					curSquirrel.setColor(140 + (12 * curDmg), 70 + (5 * curDmg), 20 + (3 * curDmg));
				}
			}	
		}
		setChanged();
		notifyObservers(this);
	}
	
	public void collisionSquirrelWithNut(int number) {
		System.out.println("\nPlayer squirrel has collided with Nut #" + number);
		for(int i = 0; i < gameObjects.size(); i++) {
			if(gameObjects.get(i) instanceof PlayerSquirrel) {
				PlayerSquirrel curSquirrel = (PlayerSquirrel) gameObjects.get(i);
				if(number == (curSquirrel.getLastNutReached() + 1)) {    //  checks if the Nut reached was one higher than the last
					curSquirrel.setLastNutReached(number);               //  in order to progress the player through the objectives
				}
				else {
				}
			}
			else {
			}	
		}
		setChanged();
		notifyObservers(this);
	}
	
	public void collisionSquirrelWithTomato() {
		System.out.println("\nPlayer squirrel has collided with a tomato.");
		Tomato curTomato = new Tomato();
		for(int i = 0; i < gameObjects.size(); i++) {
			if(gameObjects.get(i) instanceof Tomato) {
				curTomato = (Tomato) gameObjects.get(i);
				break;
			}
		}
		for(int i = 0; i < gameObjects.size(); i++) {
			if(gameObjects.get(i) instanceof PlayerSquirrel) {
				PlayerSquirrel curSquirrel = (PlayerSquirrel) gameObjects.get(i);
				curSquirrel.setEnergyLevel(curTomato.getNutrition());  // increases Squirrel's energy by the Tomato's nutrition
				curTomato.setColor(255, 200, 200);                     // fades color of the Tomato
				curTomato.resetNutrition();
				Tomato spawnedTomato = new Tomato();
				gameObjects.add(spawnedTomato);
			}
			else {
			}	
		}
		setChanged();
		notifyObservers(this);
	}
	
	public void collisionSquirrelWithBird() {
		System.out.println("\nPlayer squirrel has collided with a bird.");
		for(int i = 0; i < gameObjects.size(); i++) {
			if(gameObjects.get(i) instanceof Squirrel) {
				Squirrel curSquirrel = (Squirrel) gameObjects.get(i);
				curSquirrel.setDamageLevel(1);                   //  does half the damage of another Squirrel
				int curDmg = curSquirrel.getDamageLevel();
				curSquirrel.setColor(140 + (10 * curDmg), 70 + (4 * curDmg), 20 + (2 * curDmg)); //  lightens color based on damage
			}
			else {
			}	
		}
		setChanged();
		notifyObservers(this);
	}
	
	/**
	 * This method is used to progress the game and move all
	 * the objects that are movable. It keeps track of the time
	 * and also the win/loss conditions upon which it will terminate
	 * the game.
	 */
	
	public void clockTick() {                          
		System.out.println("\nClock has ticked once.");
		clock++;
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
				}
			    else if(curSquirrel.getLastNutReached() == 4) {
					
					System.out.println("\nGame over, you won! Time: " + clock + " ticks"); //  won because of reaching all the nuts
					setChanged();
					notifyObservers(this);
					Dialog.show("Congratulations!", "Game over, you won! Time: " + clock + " ticks", "OK", null);
					System.exit(0);
				}
				else {
					curSquirrel.move();                                   //  no win or loss condition progresses the game like normal
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
                	curSquirrel.move();
                }
			}
			else if(gameObjects.get(i) instanceof MovableGameObject) {
				MovableGameObject movingObject = (MovableGameObject) gameObjects.get(i);
				movingObject.move();                    // moves all MovableGameObjects
			}
			else {
			}
		}
		setChanged();
		notifyObservers(this);
	}
	
	public void switchStrategy() {                     // this method switches the strategy of NonPlayerSquirrels
		for(int i = 0; i < gameObjects.size(); i++) {
			if(gameObjects.get(i) instanceof NonPlayerSquirrel) {
				NonPlayerSquirrel curSquirrel = (NonPlayerSquirrel) gameObjects.get(i);
				curSquirrel.setLastNutReached(curSquirrel.getLastNutReached() + 1);
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
	
	public void setSound(boolean toggle) {
		sound = toggle;
		setChanged();
		notifyObservers(this);
	}
	
	public boolean getSound() {
		return sound;
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
		height = mapHeight;
	}
	
	public void setWidth(double mapWidth) {
		width = mapWidth;
	}
}
