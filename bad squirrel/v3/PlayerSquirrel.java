package com.mycompany.a3;

import com.codename1.ui.geom.Point;
import com.codename1.ui.Graphics;

public class PlayerSquirrel extends Squirrel{     // controlled by the player
	private static PlayerSquirrel mySquirrel;
	
	private PlayerSquirrel() {
		energyConsumptionRate = -2;
		maxDamageLevel = 10;
		lastNutReached = 1;
		setLocation(250.0, 250.0); //  all PlayerSquirrels spawn at the location of Nut #1
	}
	
	public void deleteSquirrel() {
		mySquirrel = null;
	}
	
	public static PlayerSquirrel getPlayerSquirrel() {   // Singleton design pattern
		if(mySquirrel == null) {
			mySquirrel = new PlayerSquirrel();
		}
		return mySquirrel;
	}
	
	public String toString() {                    // overridden toString method that displays all the various
		String parent = super.toString();         // attributes of the PlayerSquirrel to view on the "map"
		String child = " maxSpeed=" + maximumSpeed + " steeringDirection=" + steeringDirection + " energyLevel=" + energyLevel +
					   " damageLevel=" + damageLevel + " lastNutReached=" + lastNutReached;
		return "Player Squirrel: " + parent + child;
	}
	
	public void draw(Graphics g, Point pCmpRelPrnt) {
		g.setColor(getColor());
		int xLoc = (int) getLocation().getX() + pCmpRelPrnt.getX();
		int yLoc = (int) getLocation().getY() + pCmpRelPrnt.getX();
		g.drawRect(xLoc, yLoc, getSize() + 20, getSize() + 20);
		g.fillRect(xLoc, yLoc, getSize() + 20, getSize() + 20);
	}
	
	public void handleCollision(GameObject otherObject) {
		if(otherObject instanceof Squirrel) {
			setCollided('s');
		}
		else if(otherObject instanceof Bird) {
			setCollided('b');
		}
		else if(otherObject instanceof Nut) {
			setCollided('n');
		}
		else if(otherObject instanceof Tomato) {
			setCollided('t');
		}
	}
}
