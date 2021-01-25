package com.mycompany.a2;

import com.codename1.ui.geom.Point2D;

/**
 * Abstract parent class of all the movable
 * objects in the game. In this program that
 * includes the squirrels and the birds. They
 * all inherit the default move() function which
 * determines how objects change their position
 * within the game world
 * 
 * @param int heading describes the angle (in degrees)
 * that an object is facing as it moves
 * @param int speed describes how quickly the object
 * changes position, or in other words, how much the
 * object's location changes from one clock tick to another
 */

public abstract class MovableGameObject extends GameObject {
	private int heading;
	private int speed;
	
	public MovableGameObject(int objSize, int originalHeading) {  //  size is still being passed down, however
		super(objSize);                                           //  the child class is given direct access to
		heading = originalHeading;                                //  the heading in their constructor
	}
	
	public void move() {                                          //  moves the objects
		Point2D oldLocation = getLocation();
		int angle = 90 - heading;
		double deltaX = 0;
		double deltaY = 0;
		
		if(heading == 90 || heading == 270) {
			deltaX = Math.cos(Math.toRadians(angle)) * speed * 2;  //  this calculation determines how the object's
		}                                                          //  x and y values change as they move around
		else if(heading == 0 || heading == 180) {
			deltaY = Math.sin(Math.toRadians(angle)) * speed * 2;
		}
		else {
			deltaX = Math.cos(Math.toRadians(angle)) * speed * 2;
			deltaY = Math.sin(Math.toRadians(angle)) * speed * 2;
		}
		setLocation(oldLocation.getX() + deltaX, oldLocation.getY() + deltaY);  //  updates the x and y values of the location variable
	}
	
	public void setSpeed(int speedChange) {                        // changes the object's speed by modifying its previous speed
		speed += speedChange;
		if(speed < 0) {
			speed = 0;
		}
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public void setHeading(int headingChange) {
		heading += headingChange;
	}
	
	public int getHeading() {
		return heading;
	}
	
	public String toString() {                          //  toString method that overrides the default method
		String parent = super.toString();               //  will be passed down to all movable objects to make printing easier
		String child = " heading=" + heading + " speed=" + speed;
		return parent + child;
	}
}
