package com.mycompany.a3;

import com.codename1.ui.geom.Point;
import com.codename1.ui.Graphics;
import com.codename1.charts.util.ColorUtil;

/**
 * The Nut class represents the main objective of 
 * the game. The Squirrel must go to all the nuts
 * in sequential order to win the game. The Nuts are
 * not eaten by the Squirrel and they cannot change size,
 * location, or color once instantiated
 */

public class Nut extends FixedGameObject{
	private int sequenceNumber;       //  allows each instantiated Nut object to be assigned an ID sequentially
	private int colorHolder;          //  holds the color of the object temporarily
	
	public Nut(double x, double y, int sequence) {
		super(10);
		super.setColor(0, 255, 0);    // nuts are green by default
		super.setLocation(x, y);
		sequenceNumber = sequence;
	}
	
	public int getSequenceNumber() {
		return sequenceNumber;
	}
	
	public void setColor(int r, int g, int b) {
	}
	
	public String toString() {                 // overridden toString method to display relevant data of the object
		String parent = super.toString();
		return "Nut: " + parent + " seqNum=" + sequenceNumber;
	}
	
	public void draw(Graphics g, Point pCmpRelPrnt) {
		g.setColor(getColor());
		colorHolder = getColor();
		int xLoc = (int) getLocation().getX() + pCmpRelPrnt.getX();
		int yLoc = (int) getLocation().getY() + pCmpRelPrnt.getX();
		int[] xVal = {xLoc, xLoc - 40, xLoc + 40, xLoc};
		int[] yVal = {yLoc + 50, yLoc - 50, yLoc - 50, yLoc + 50};
		int zVal = 4;
		if(isSelected()) {
			g.drawPolygon(xVal, yVal, zVal);
		}
		else {
			g.drawPolygon(xVal, yVal, zVal);
			g.fillPolygon(xVal, yVal, zVal);
		}
		g.setColor(ColorUtil.BLACK);
		g.drawString("" + sequenceNumber, xLoc - 10, yLoc - 30);
		g.setColor(colorHolder);
	}
	
	public void handleCollision(GameObject otherObject) {
	}
}