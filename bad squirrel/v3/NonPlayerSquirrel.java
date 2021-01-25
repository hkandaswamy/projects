package com.mycompany.a3;

import com.codename1.ui.geom.Point;
import com.codename1.ui.Graphics;

public class NonPlayerSquirrel extends Squirrel{      // controlled by game AI
	private IStrategy curStrategy;
	private int coinFlip;
	
	public NonPlayerSquirrel() {
		energyConsumptionRate = 0;  // NonPlayerSquirrels do not lose energy
		maxDamageLevel = 50;        // NonPlayerSquirrels have more health
		lastNutReached = 0;         // NonPlayerSquirrels do not start at Nut #1
		coinFlip = rand.nextInt(2);
		if(coinFlip == 0) {         // randomly assigns a strategy based on a coin flip
			curStrategy = new AttackStrategy(this);
		}
		else if(coinFlip == 1) {
			curStrategy = new NutStrategy(this);
		}
		setLocation(350.0 + (200 * rand.nextDouble()), 350.0 + (200 * rand.nextDouble())); //  all NonPlayerSquirrels spawn near Nut #1
	}
	
	public IStrategy getStrategy() {
		return curStrategy;
	}
	
	public void setStrategy(IStrategy s) {           // Strategy design pattern
		curStrategy = s;
	}
	
	public void invokeStrategy() {
		curStrategy.apply();
	}
	
	public String toString() {                    // overridden toString method that displays all the various
		String parent = super.toString();         // attributes of the NonPlayerSquirrel to view on the "map"
		String child = " maxSpeed=" + maximumSpeed + " steeringDirection=" + steeringDirection + " energyLevel=" + energyLevel +
					   " damageLevel=" + damageLevel + " lastNutReached=" + lastNutReached + " strategy=" + curStrategy;
		return "NPC Squirrel: " + parent + child;
	}
	
	public void draw(Graphics g, Point pCmpRelPrnt) {
		g.setColor(getColor());
		int xLoc = (int) getLocation().getX() + pCmpRelPrnt.getX();
		int yLoc = (int) getLocation().getY() + pCmpRelPrnt.getX();
		g.drawRect(xLoc, yLoc, getSize() + 20, getSize() + 20);
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
