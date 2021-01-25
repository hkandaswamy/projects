package com.mycompany.a1;

import java.util.Random;

/**
 * Birds are randomly spawned and randomly
 * moving objects in the game that act as 
 * obstacles to the Squirrels. They cause damage
 * to the Squirrel when a collision occurs. Bird
 * objects spawn with random sizes and locations
 * but have a fixed color that cannot be changed.
 */

public class Bird extends MovableGameObject{
	private static Random rand = new Random();
	
	public Bird() {
		super(10 + rand.nextInt(31), rand.nextInt(360));   //  random starting size and heading
		super.setColor(0, 0, 255);                         //  Birds are blue by default
		super.setLocation(1000 * rand.nextDouble(), 1000 * rand.nextDouble());
		super.setSpeed(5);
	}
	
	public void move() {
		super.move();
		super.setHeading(-5 + rand.nextInt(11));            // changes heading by a small random amount
		if(getLocation().getX() >= 1000) {                  // checks to make sure the Bird doesn't go out of bounds
			super.setLocation(1000, getLocation().getY());
			super.setHeading(180);
		}
		else if(getLocation().getY() >= 1000) {             //  boundary check in the Y direction
			super.setLocation(getLocation().getX(), 1000);
			super.setHeading(180);
		}
		else if(getLocation().getX() >= 1000 && getLocation().getY() >= 1000) { //  boundary check in both x and y
			super.setLocation(1000, 1000);
			super.setHeading(180);                          //  with all these checks, the Bird will turn around if
		}                                                   //  the game detects it will go out of bounds
	}
	
	public void setSpeed(int speedChange) {                 //  these three methods are overridden here
	}                                                       //  to prevent direct access to their states
	                                                        //  this is also done in several other classes
	public void setHeading(int headingChange) {             //  in this program to enforce encapsulation
	}                                                       //  and increase extendability
	
	public void setColor(int r, int g, int b) {
	}
	
	public String toString() {           //  overridden toString to help display the "map"
		return "Bird: " + super.toString();
	}
}
