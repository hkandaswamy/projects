package com.mycompany.a3;

import java.util.Random;
import com.codename1.ui.geom.Point;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;

/**
 * Tomatoes are randomly spawned objects in
 * the game that are used to provide energy to
 * the Squirrels when eaten. They spawn with random size
 * and nutrition proportional to that size. Once
 * they are spawned, the size of the object
 * cannot be changed but the color can be
 * faded to indicate that it has been consumed.
 * 
 * @param int nutrition increases the energyLevel of Squirrel
 * objects proportional to the Tomato's size
 * @param Random rand used to generate random values
 * for the size of the Tomato
 */

public class Tomato extends FixedGameObject implements ISelectable{
	private static Random rand = new Random();
	private int nutrition;
	private int colorHolder;        // holds the color of the object temporarily
	
	public Tomato() {
		super(10 + rand.nextInt(41));
		super.setColor(255, 0, 0);  //  Tomatoes are red by default
		nutrition = getSize();
		super.setLocation(1000 * rand.nextDouble(), 1000 * rand.nextDouble());  //  used to set random spawn locations within the world
	}
	
	public int getNutrition() {
		return nutrition;
	}
	
	public void resetNutrition() {
		nutrition = 0;
	}
	
	public String toString() {      // overridden toString method
		String parent = super.toString();
		return "Tomato: " + parent + " nutrition=" + nutrition;
	}
	
	public void draw(Graphics g, Point pCmpRelPrnt) {
		g.setColor(getColor());
		colorHolder = getColor();
		int xLoc = (int) getLocation().getX() + pCmpRelPrnt.getX();
		int yLoc = (int) getLocation().getY() + pCmpRelPrnt.getX();
		if(isSelected()) {
			g.drawArc(xLoc, yLoc, getSize() + 40, getSize() + 40, 0, 360);
		}
		else {
			g.drawArc(xLoc, yLoc, getSize() + 40, getSize() + 40, 0, 360);
			g.fillArc(xLoc, yLoc, getSize() + 40, getSize() + 40, 0, 360);
		}
		g.setColor(ColorUtil.BLACK);
		g.drawString("" + nutrition, xLoc + (getSize() / 2), yLoc + (getSize() / 2));
		g.setColor(colorHolder);
	}
	
	public void handleCollision(GameObject otherObject) {
	}
}
