package com.mycompany.a3;

import com.codename1.ui.geom.Point;

/**
 * Abstract parent class of all non-moving objects
 * in the game. In this program, that includes both 
 * the nuts and the tomatoes. The constructor is the
 * only method and it is used to pass down the "size"
 * variable to the children 
 *
 */

public abstract class FixedGameObject extends GameObject implements ISelectable{
	private boolean selected = false;
	
	public FixedGameObject(int objSize) {
		super(objSize);
	}
	
	public void setLocation() {
	}
	
	public void setSelected(boolean b) {
		selected = b;
	}
	
	public boolean isSelected() {
		return selected;
	}
	
	public boolean contains(Point pPtrRelPrnt, Point pCmpRelPrnt) {
		int px = pPtrRelPrnt.getX();
		int py = pPtrRelPrnt.getY();
		int xLoc = (int) getLocation().getX() + pCmpRelPrnt.getX();
		int yLoc = (int) getLocation().getY() + pCmpRelPrnt.getY();
		int size = getSize() / 2;
		if((px >= xLoc - size) && (px <= xLoc - size) && (py >= yLoc - size) && (py <= yLoc + size)) {
			return true;
		}
		return false;
	}
}
