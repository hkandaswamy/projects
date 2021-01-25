package com.mycompany.a3;

import com.codename1.util.MathUtil;

public class NutStrategy implements IStrategy{   // strategy to update heading of NonPlayerSquirrels to reach Nuts
	private NonPlayerSquirrel npc;
	private double npcX;
	private double npcY;
	private double neededHeading;
	
	public NutStrategy(NonPlayerSquirrel squirrel) {
		npc = squirrel;
	}
	
	public void apply() {
		npcX = npc.getLocation().getX();
		npcY = npc.getLocation().getY();
		if(npc.getLastNutReached() == 0) {
			neededHeading = Math.toDegrees(MathUtil.atan2(250.0 - npcX, 250.0 - npcY));
			npc.steer(-(npc.getSteeringDirection()));           // resets the steering direction to 0
			npc.setHeading(-(npc.getHeading()));                // resets the heading to 0
			npc.steer((int) neededHeading);                     // applies the change needed to the steering direction
		}
		else if(npc.getLastNutReached() == 1) {
			neededHeading = Math.toDegrees(MathUtil.atan2(250.0 - npcX, 750.0 - npcY));
			npc.steer(-(npc.getSteeringDirection()));
			npc.steer((int) neededHeading);
		}
		else if(npc.getLastNutReached() == 2) {
			neededHeading = Math.toDegrees(MathUtil.atan2(750.0 - npcX, 750.0 - npcY));
			npc.steer(-(npc.getSteeringDirection()));
			npc.steer((int) neededHeading);
		}
		else if(npc.getLastNutReached() == 3) {
			neededHeading = Math.toDegrees(MathUtil.atan2(750.0 - npcX, 250.0 - npcY));
			npc.steer(-(npc.getSteeringDirection()));
			npc.steer((int) neededHeading);
		}
		else {
		}
	}
	
	public String toString() {
		return "NutStrategy";
	}
}
