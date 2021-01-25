package com.mycompany.a1;

import java.util.Random;

/**
 * Tomatoes are randomly spawned objects in
 * the game that are used to provide energy to
 * the Squirrels when eaten. They spawn with random size
 * and nutrition proportional to that size. Once
 * they are spawned, the size and nutrition
 * values cannot be changed but the color can be
 * faded to indicate that it has been consumed
 * 
 * @param int nutrition increases the energyLevel of Squirrel
 * objects proportional to the Tomato's size
 * @param Random rand used to generate random values
 * for the size of the Tomato
 */

public class Tomato extends FixedGameObject {
	private static Random rand = new Random();
	private int nutrition;
	
	public Tomato() {
		super(10 + rand.nextInt(41));
		super.setColor(255, 0, 0);  //  Tomatoes are red by default
		nutrition = getSize()/2;
		super.setLocation(1000 * rand.nextDouble(), 1000 * rand.nextDouble());  //  used to set random spawn locations within the world
	}
	
	public int getNutrition() {
		return nutrition;
	}
	
	public void setLocation(double x, double y) {
	}
	
	public String toString() {      // overridden toString method
		String parent = super.toString();
		return "Tomato: " + parent + " nutrition=" + nutrition;
	}
}
