package com.mycompany.a2;

/**
 * Abstract parent class of all non-moving objects
 * in the game. In this program, that includes both 
 * the nuts and the tomatoes. The constructor is the
 * only method and it is used to pass down the "size"
 * variable to the children 
 *
 */

public abstract class FixedGameObject extends GameObject {
	
	public FixedGameObject(int objSize) {
		super(objSize);
	}
	
	public void setLocation() {
	}
}
