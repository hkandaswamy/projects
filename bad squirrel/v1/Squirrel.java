package com.mycompany.a1;

import java.util.Random;

/**
 * The Squirrel class contains the object that
 * will be controlled by the player during the 
 * game. It interacts with all of the other objects
 * and has some unique properties. For example, the
 * Squirrel can be steered by a player (due to implementing
 * the ISteerable interface) whereas the others cannot.
 * Squirrels have many attributes which keep track of its
 * health throughout the course of the game and provide 
 * a challenge to the player.
 * 
 * @param int steeringDirection holds the "steer" value applied to
 * the Squirrel so it can update its heading on the next clock tick
 * @param int maximumSpeed the limit on how high the Squirrel's speed
 * can go. Determined randomly during instantiation
 * @param int energyLevel the energy attribute of the Squirrel
 * which allows it to move. If it reaches 0, it can no longer move
 * @param int energyConsumptionRate determines how much energy
 * the Squirrel drains with each move. Standardized to -1 across
 * all Squirrel objects
 * @param int damageLevel keeps track of how much damage
 * the Squirrel has sustained
 * @param maxDamageLevel the upper limit on how much damage the
 * Squirrel can sustain
 * @param int lastNutReached keeps track of the sequential order
 * of the nuts reached in order to determine the win condition
 */

public class Squirrel extends MovableGameObject implements ISteerable{
	Random rand = new Random();
	int steeringDirection;
	int maximumSpeed;
	int energyLevel;
	int energyConsumptionRate;
	int damageLevel;
	int maxDamageLevel;
	int lastNutReached;
	
	public Squirrel() {
		super(40, 0);              //  all squirrels are size 40 by default
		steeringDirection = 0;
		maximumSpeed = 5 + rand.nextInt(6);    //  different squirrels have different maximum speeds
		energyLevel = 10;
		energyConsumptionRate = -1;
		damageLevel = 0;
		maxDamageLevel = 10;
		lastNutReached = 1;        
		setColor(140, 70, 20);     //  Squirrels are brown by default
		setLocation(250.0, 250.0); //  all Squirrels spawn at the location of Nut #1
		setSpeed(5);
	}
	
	public int getSteeringDirection() {
		return steeringDirection;
	}
	
	public int getMaximumSpeed() {
		return maximumSpeed;
	}
	
	public int getEnergyLevel() {
		return energyLevel;
	}
	
	public void setEnergyLevel(int energyChange) {   // changes energy by adding or subtracting onto the existing value
		energyLevel += energyChange;
	}
	
	public int getDamageLevel() {
		return damageLevel;
	}
	
	public void setDamageLevel(int damage) {
		damageLevel += damage;
		if(damageLevel >= maxDamageLevel) { //  made the max damage a variable so it is easier to change later on if needed
			damageLevel = maxDamageLevel;
			setSpeed(-(getSpeed()));        //  sets speed to 0
		}
		else if(damageLevel > 0 && damageLevel < maxDamageLevel) {
			maximumSpeed -= damageLevel;  //  reduces maximum speed by amount of damage taken, 1:1 ratio
			if(maximumSpeed < 0) {
				maximumSpeed = 0;         // ensures maximum speed doesn't become negative
			}
			super.setSpeed(maximumSpeed - super.getSpeed());  //  ensures speed doesn't exceed max
		}
	}
	
	public int getMaxDamageLevel() {
		return maxDamageLevel;
	}
	
	public void setLastNutReached(int nutNumber) { // sets the last nut reached according to the Nut number
		lastNutReached = nutNumber;
	}
	
	public int getLastNutReached() {
		return lastNutReached;
	}
	
	public void steer(int degrees) {
		steeringDirection += degrees;
		}
	
	public void setSpeed(int speedChange) {
		super.setSpeed(speedChange);
		if(super.getSpeed() > maximumSpeed) {             //  adjusts properly if speed goes past max allowed
			super.setSpeed(maximumSpeed - super.getSpeed());    //  sets speed equal to max speed
		}
		else if(super.getSpeed() < 0) {                   // adjusts properly if speed drops below zero
			super.setSpeed(-(super.getSpeed()));                // sets speed to zero
		}
	}
	
	public void setHeading(int headingChange) {
	}
	
	public String toString() {                    // overridden toString method that displays all the various
		String parent = super.toString();         // attributes of the Squirrel to view on the "map"
		String child = " maxSpeed=" + maximumSpeed + " steeringDirection=" + steeringDirection + " energyLevel=" + energyLevel +
					   " damageLevel=" + damageLevel + " lastNutReached=" + lastNutReached;
		return "Squirrel: " + parent + child;
	}
}
