package com.mycompany.a2;

/**
 * The Nut class represents the main objective of 
 * the game. The Squirrel must go to all the nuts
 * in sequential order to win the game. The Nuts are
 * not eaten by the Squirrel and they cannot change size,
 * location, or color once instantiated
 */

public class Nut extends FixedGameObject {
	private int sequenceNumber;       //  allows each instantiated Nut object to be assigned an ID sequentially
	
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
}