package com.mycompany.a3;

import java.util.Observable;
import java.util.Observer;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.FlowLayout;

public class ScoreView extends Container implements Observer {
	private Label clockTicks;
	private Label livesRemaining;
	private Label lastNut;
	private Label energyLevel;
	private Label damageLevel;
	private Label soundToggle;
	private GameWorld gw;
	
	public ScoreView()
	{
		this.setLayout(new FlowLayout(LEFT));
		
		Label timeLabel = new Label("Time:");
		timeLabel.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
		timeLabel.getAllStyles().setPadding(LEFT, 5);
		clockTicks = new Label("0");
		clockTicks.getAllStyles().setPadding(RIGHT, 5);
		this.add(timeLabel);
		this.add(clockTicks);
		
		Label livesLabel = new Label("Lives Left:");
		livesLabel.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
		livesRemaining = new Label("0");
		livesRemaining.getAllStyles().setPadding(RIGHT, 5);
		this.add(livesLabel);
		this.add(livesRemaining);
		
		Label lastNutLabel = new Label("Player Last Nut Reached:");
		lastNutLabel.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
		lastNut = new Label("0");
		lastNut.getAllStyles().setPadding(RIGHT, 5);
		this.add(lastNutLabel);
		this.add(lastNut);
		
		Label energyLabel = new Label("Player Energy Level:");
		energyLabel.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
		energyLevel = new Label("0");
		energyLevel.getAllStyles().setPadding(RIGHT, 5);
		this.add(energyLabel);
		this.add(energyLevel);
		
		Label damageLabel = new Label("Player Damage Level:");
		damageLabel.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
		damageLevel = new Label("0");
		damageLevel.getAllStyles().setPadding(RIGHT, 5);
		this.add(damageLabel);
		this.add(damageLevel);
		
		Label soundLabel = new Label("Sound:");
		soundLabel.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
		soundToggle = new Label("OFF");
		soundToggle.getAllStyles().setPadding(RIGHT, 5);
		this.add(soundLabel);
		this.add(soundToggle);
	}

	public void update(Observable o, Object arg) {
		gw = (GameWorld) o;
		clockTicks.setText(""+Integer.toString(gw.getClock()));
		livesRemaining.setText(""+Integer.toString(gw.getLives()));
		lastNut.setText(""+Integer.toString(gw.getLastNut()));
		energyLevel.setText(""+Integer.toString(gw.getEnergy()));
		damageLevel.setText(""+Integer.toString(gw.getDamage()));
		if(gw.getSound()) {
			soundToggle.setText("ON");
		}
		else {
			soundToggle.setText("OFF");
		}	
	}
}
