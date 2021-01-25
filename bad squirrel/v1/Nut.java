package com.mycompany.a1;

/**
 * The Nut class represents the main objective of 
 * the game. The Squirrel must go to all the nuts
 * in sequential order to win the game. The Nuts are
 * not eaten by the Squirrel and they cannot change size,
 * location, or color once instantiated
 */

public class Nut extends FixedGameObject {
	private static int identifier;    //  static identifier shared across all instances of the class
	private int sequenceNumber;       //  allows each instantiated Nut object to be assigned an ID sequentially
	
	public Nut() {
		super(10);
		super.setColor(0, 255, 0);    // nuts are green by default
		if(identifier == 0) {
			super.setLocation(250.0, 250.0);  //  locations are fixed, in this instance they are in the four corners of the world
			sequenceNumber = 1;
		}
		else if(identifier == 1) {
			super.setLocation(750.0, 250.0);
			sequenceNumber = 2;
		}
		else if(identifier == 2) {
			super.setLocation(750.0, 750.0);
			sequenceNumber = 3;
		}
		else if(identifier == 3) {
			super.setLocation(250.0, 750.0);
			sequenceNumber = 4;
		}
		else if(identifier > 3) {              //  ignores new requests to make Nut objects if the required 4 are already made
		}
		identifier++;
	}
	
	public int getSequenceNumber() {
		return sequenceNumber;
	}
	
	public void setColor(int r, int g, int b) {
	}
	
	public void setLocation(double x, double y) {
	}
	
	public String toString() {                 // overridden toString method to display relevant data of the object
		String parent = super.toString();
		return "Nut: " + parent + " seqNum=" + sequenceNumber;
	}
}