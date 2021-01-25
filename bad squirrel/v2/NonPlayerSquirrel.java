package com.mycompany.a2;

public class NonPlayerSquirrel extends Squirrel{      // controlled by game AI
	private IStrategy curStrategy;
	private int coinFlip;
	
	public NonPlayerSquirrel() {
		energyConsumptionRate = 0;  // NonPlayerSquirrels do not lose energy
		maxDamageLevel = 20;        // NonPlayerSquirrels have more health
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
}
