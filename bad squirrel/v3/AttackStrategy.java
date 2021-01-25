package com.mycompany.a3;

import com.codename1.util.MathUtil;

public class AttackStrategy implements IStrategy{ // strategy to update heading of NonPlayerSquirrels to attack PlayerSquirrel
	private PlayerSquirrel playerSquirrel;
	private NonPlayerSquirrel npc;
	private double targetX;
	private double targetY;
	private double npcX;
	private double npcY;
	private double neededHeading;
	
	public AttackStrategy(NonPlayerSquirrel squirrel) {
		npc = squirrel;
	}
	
	public void apply() {
		playerSquirrel = PlayerSquirrel.getPlayerSquirrel();
		targetX = playerSquirrel.getLocation().getX();
		targetY = playerSquirrel.getLocation().getY();
		npcX = npc.getLocation().getX();
		npcY = npc.getLocation().getY();
		neededHeading = Math.toDegrees(MathUtil.atan2(targetX - npcX, targetY - npcY));
		npc.steer(-(npc.getSteeringDirection()));           // resets the steering direction to 0
		npc.setHeading(-(npc.getHeading()));                // resets the heading to 0
		npc.steer((int) neededHeading);                     // applies the change needed to the steering direction
	}
	
	public String toString() {
		return "AttackStrategy";
	}
}
