package com.mycompany.a2;

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
}
