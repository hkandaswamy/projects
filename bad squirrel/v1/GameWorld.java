package com.mycompany.a1;

import java.util.Vector;

/**
 * Builds the game "board" or world and populates
 * it with the various objects
 *
 * @param Vector gameObjects holds all the child objects
 * within its encapsulated abstract class
 * @param int lives is used to keep track of how many 
 * lives the  player has remaining
 * @param int clock keeps track of the "time" within
 * the game world by ticking up every turn
 */

public class GameWorld {
	private Vector<GameObject> gameObjects = new Vector<GameObject>();
	private static int lives = 3;
	private static int clock = 0;
	
	/**
	 * Calls the initializer method to spawn the
	 * game objects within the world
	 */
	
	public GameWorld() {
		init();
	}
	
	/**
	 * In this version of the game, the world
	 * holds exactly four nuts, two tomatoes,
	 * one squirrel, and two birds
	 */
	
	public void init() {
		gameObjects.add(new Nut());
		gameObjects.add(new Nut());
		gameObjects.add(new Nut());
		gameObjects.add(new Nut());
		gameObjects.add(new Tomato());
		gameObjects.add(new Tomato());
		gameObjects.add(new Squirrel());
		gameObjects.add(new Bird());
		gameObjects.add(new Bird());
	}
	
	/**
	 *  All the methods listed below are described
	 *  in the Game class. They determine the type
 	 *  of the object in the Vector and proceed with
	 *  actions accordingly
	 */
	
	public void acceleratePlayerSquirrel() {
		System.out.println("\nPlayer squirrel accelerating.");
		for(int i = 0; i < gameObjects.size(); i++) {
			if(gameObjects.get(i) instanceof Squirrel) {
				Squirrel curSquirrel = (Squirrel) gameObjects.get(i);
				curSquirrel.setSpeed(2);
			}
		}
	}
	
	public void brakePlayerSquirrel() {
		System.out.println("\nPlayer squirrel braking.");
		for(int i = 0; i < gameObjects.size(); i++) {
			if(gameObjects.get(i) instanceof Squirrel) {
				Squirrel curSquirrel = (Squirrel) gameObjects.get(i);
				curSquirrel.setSpeed(-2);
			}
			else {
				
			}
		}
	}
	
	public void turnPlayerSquirrelLeft() {
		System.out.println("\nPlayer squirrel turning left.");
		for(int i = 0; i < gameObjects.size(); i++) {
			if(gameObjects.get(i) instanceof Squirrel) {
				Squirrel curSquirrel = (Squirrel) gameObjects.get(i);
				curSquirrel.steer(-5);  //  applies a turn of negative 5 degrees
			}
			else {
			}	
		}
	}
		
	public void turnPlayerSquirrelRight() {
		System.out.println("\nPlayer squirrel turning right.");
		for(int i = 0; i < gameObjects.size(); i++) {
			if(gameObjects.get(i) instanceof Squirrel) {
				Squirrel curSquirrel = (Squirrel) gameObjects.get(i);
				curSquirrel.steer(5);  //  applies a turn of positive 5 degrees
			}
			else {
			}	
		}
	}
	
	public void collisionSquirrelWithSquirrel() {
		System.out.println("\nPlayer squirrel has collided with another squirrel.");
		for(int i = 0; i < gameObjects.size(); i++) {
			if(gameObjects.get(i) instanceof Squirrel) {
				Squirrel curSquirrel = (Squirrel) gameObjects.get(i);
				curSquirrel.setDamageLevel(2);
				int curDmg = curSquirrel.getDamageLevel();
				curSquirrel.setColor(140 + (12 * curDmg), 70 + (5 * curDmg), 20 + (3 * curDmg)); //  lightens color based on damage
			}
			else {
			}	
		}
	}
	
	public void collisionSquirrelWithNut(int number) {
		System.out.println("\nPlayer squirrel has collided with Nut #" + number);
		for(int i = 0; i < gameObjects.size(); i++) {
			if(gameObjects.get(i) instanceof Squirrel) {
				Squirrel curSquirrel = (Squirrel) gameObjects.get(i);
				if(number == (curSquirrel.getLastNutReached() + 1)) {    //  checks if the nut reached was one higher than the last
					curSquirrel.setLastNutReached(number);               //  in order to progress the player through the objective
				}
				else {
				}
			}
			else {
			}	
		}
	}
	
	public void collisionSquirrelWithTomato(Tomato t) {
		System.out.println("\nPlayer squirrel has collided with a tomato.");
		for(int i = 0; i < gameObjects.size(); i++) {
			if(gameObjects.get(i) instanceof Squirrel) {
				Squirrel curSquirrel = (Squirrel) gameObjects.get(i);
				curSquirrel.setEnergyLevel(t.getNutrition()/2);  // increases squirrel's energy by half the tomato's nutrition
				t.setColor(255, 200, 200);                       // fades color of the tomato
				Tomato spawnedTomato = new Tomato();
				gameObjects.add(spawnedTomato);
			}
			else {
			}	
		}
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
	}
	
	/**
	 * This method is used to progress the game and move all
	 * the objects that are movable. It keeps track of the time
	 * and also the win/loss conditions upon which it will terminate
	 * the game
	 */
	
	public void clockTick() {                          
		System.out.println("\nClock has ticked once.");
		clock++;
		for(int i = 0; i < gameObjects.size(); i++) {
			if(gameObjects.get(i) instanceof Squirrel) {
				Squirrel curSquirrel = (Squirrel) gameObjects.get(i);
				curSquirrel.setHeading(curSquirrel.getSteeringDirection());  //  applies the steering direction to the heading
				if(curSquirrel.getDamageLevel() == curSquirrel.getMaxDamageLevel() || curSquirrel.getSpeed() == 0 || curSquirrel.getEnergyLevel() == 0) {
					lives--;
					if(lives == 0) {
						System.out.println("\nGame over, you failed!");  //  failed because of no more lives
						System.exit(0);
					}
					gameObjects.set(i,  new Squirrel());			     // instantiates a new Squirrel to replace the lost one
				}
				else if(curSquirrel.getLastNutReached() == 4) {
					System.out.println("\nGame over, you win! Time: " + clock + " ticks"); //  won because of reaching all the nuts
					System.exit(0);
				}
				else {
					curSquirrel.move();                                   //  no win or loss condition progresses the game like normal
					curSquirrel.setEnergyLevel(curSquirrel.energyConsumptionRate);
				}
			}
			else if(gameObjects.get(i) instanceof MovableGameObject) {
				MovableGameObject movingObject = (MovableGameObject) gameObjects.get(i);
				movingObject.move();
			}
			else {
			}
		}
	}
	
	public void displayStats() {                                   //  displays some Squirrel and game state data
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
}
