package com.mycompany.a1;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.geom.Point2D;

/**
 * This is the abstract parent class to all the 
 * other objects in the game. The methods held within
 * are shared across all the child classes. Some
 * have been overriden by the children as needed
 * 
 * @param Point2D location holds a location variable in the 
 * 2D coordinate form of (x,y)
 * @param int size represents the size of the object, bounded by
 * a box
 * @param int color holds the RGB color value of the object
 */

public abstract class GameObject {
	private Point2D location;;
	private int size;
	private int color;
	
	public GameObject(int objSize) {  //  this is done to pass the otherwise untouchable private field "size" 
		size = objSize;               //  down to the child classes where it can be modified
		location = new Point2D(0, 0);
	}
	
	public int getSize() {             // getter for the size variable
		return size;
	}
	
	public Point2D getLocation() {     // returns the 2D point where an object is located
		return location;
	}
	
	public void setLocation(double x, double y) {   //  sets the location of an object after rounding it to 
		location.setX((Math.round(x)*10.0)/10.0);   //  one decimal place
		location.setY((Math.round(y)*10.0)/10.0);
	}
	
	public int getColor() {
		return color;
	}
	
	public void setColor(int r, int g, int b) {
		if(r > 255 || r < 0 || g > 255 || g < 0 || b > 255 || b < 0) {  // checks to ensure RGB values are within bounds
		}
		else {
			color = ColorUtil.rgb(r, g, b);
		}
	}
	
	public String toString() {        // beginning of the toString sequence that is used to output the "map"
		String s = "location=" + location.getX() + "," + location.getY() + " color=[" + ColorUtil.red(color) + "," + 
	                ColorUtil.green(color) + "," + ColorUtil.blue(color) + "] size=" + size;
		return s;
	}
}
