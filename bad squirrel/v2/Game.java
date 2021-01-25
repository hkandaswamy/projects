package com.mycompany.a2;

import com.codename1.ui.Form;

import com.codename1.ui.CheckBox;
import com.codename1.ui.Container;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import com.mycompany.commands.*;
import java.lang.String;

/**
 * Builds an instance of the game
 * using its connections to the other classes.
 *
 * @param GameWorld gw holds the game "board"
 * @param boolean quitting this is used as a flag
 * to signal to the listeners that the user wishes
 * to quit the game, thus locking them out of the
 * other options
 */
public class Game extends Form {
	
	private GameWorld gw;
	private MapView mv;
	private ScoreView sv;
	private static String gameTitle = "Bad Squirrel!";
	boolean quitting = false;
	
	public Game() {
		this.setLayout(new BorderLayout());
		gw = new GameWorld();
		mv = new MapView();
		sv = new ScoreView();
		gw.addObserver(mv);
		gw.addObserver(sv);
		
		Toolbar titleBar = new Toolbar();
		this.setToolbar(titleBar);
		titleBar.setTitle(gameTitle);	
		
		Container westContainer = new Container();
		westContainer.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
		
		Container eastContainer = new Container();
		eastContainer.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
		
		Container southContainer = new Container();
		southContainer.setLayout(new FlowLayout(southContainer.CENTER));
		southContainer.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.BLACK));
		
		Container northContainer = new Container();
		northContainer.setLayout(new FlowLayout(northContainer.CENTER));		
		
		this.addComponent(BorderLayout.NORTH, northContainer);
		northContainer.addComponent(sv);
		this.addComponent(BorderLayout.WEST, westContainer);
		this.addComponent(BorderLayout.EAST, eastContainer);
		this.addComponent(BorderLayout.SOUTH, southContainer);
		this.addComponent(BorderLayout.CENTER, mv);
		
		AccelerateCommand accelerateCommand = new AccelerateCommand(gw);
		addKeyListener('a', accelerateCommand);
		titleBar.addCommandToSideMenu(accelerateCommand);
		CustomButton accelerateButton = new CustomButton(accelerateCommand);
		accelerateButton.getAllStyles().setPadding(10, 10, 10, 10);		
		southContainer.add(accelerateButton);
		
		CheckBox soundBox = new CheckBox("Sound");
		soundBox.getAllStyles().setBgTransparency(255);
		SoundCommand soundCommand = new SoundCommand(gw, soundBox);
		soundBox.setCommand(soundCommand);
		titleBar.addComponentToSideMenu(soundBox);
		
		AboutCommand aboutCommand = new AboutCommand();
		titleBar.addCommandToSideMenu(aboutCommand);
		
		HelpCommand helpCommand = new HelpCommand();
		titleBar.addCommandToRightBar(helpCommand);
		
		ExitCommand exitCommand = new ExitCommand();
		titleBar.addCommandToSideMenu(exitCommand);
		
		BrakeCommand brakeCommand = new BrakeCommand(gw);
		addKeyListener('b', brakeCommand);
		CustomButton brakeButton = new CustomButton(brakeCommand);
		brakeButton.getAllStyles().setPadding(10, 10, 10, 10);
		southContainer.add(brakeButton);
		
		LeftTurnCommand leftTurnCommand = new LeftTurnCommand(gw);
		addKeyListener('l', leftTurnCommand);
		CustomButton leftTurnButton = new CustomButton(leftTurnCommand);
		leftTurnButton.getAllStyles().setPadding(5, 5, 5, 5);		
		westContainer.add(leftTurnButton);
		
		RightTurnCommand rightTurnCommand = new RightTurnCommand(gw);
		addKeyListener('r', rightTurnCommand);
		CustomButton rightTurnButton = new CustomButton(rightTurnCommand);
		rightTurnButton.getAllStyles().setPadding(5, 5, 5, 5);		
		eastContainer.add(rightTurnButton);
		
		CollideSquirrelCommand collideSquirrelCommand = new CollideSquirrelCommand(gw);
		CustomButton collideSquirrelButton = new CustomButton(collideSquirrelCommand);
		collideSquirrelButton.getAllStyles().setPadding(5, 5, 5, 5);
		westContainer.add(collideSquirrelButton);
		
		CollideNutCommand collideNutCommand = new CollideNutCommand(gw);
		CustomButton collideNutButton = new CustomButton(collideNutCommand);
		collideNutButton.getAllStyles().setPadding(5, 5, 5, 5);
		westContainer.add(collideNutButton);
		
		CollideTomatoCommand collideTomatoCommand = new CollideTomatoCommand(gw);
		addKeyListener('e', collideTomatoCommand);
		CustomButton collideTomatoButton = new CustomButton(collideTomatoCommand);
		collideTomatoButton.getAllStyles().setPadding(5, 5, 5, 5);
		westContainer.add(collideTomatoButton);
		
		CollideBirdCommand collideBirdCommand = new CollideBirdCommand(gw);
		addKeyListener('g', collideBirdCommand);
		CustomButton collideBirdButton = new CustomButton(collideBirdCommand);
		collideBirdButton.getAllStyles().setPadding(5, 5, 5, 5);
		westContainer.add(collideBirdButton);
		
		TickCommand tickCommand = new TickCommand(gw);
		addKeyListener('t', tickCommand);
		CustomButton tickButton = new CustomButton(tickCommand);
		tickButton.getAllStyles().setPadding(5, 5, 5, 5);
		eastContainer.add(tickButton);
		
		StrategyCommand strategyCommand = new StrategyCommand(gw);
		CustomButton strategyButton = new CustomButton(strategyCommand);
		strategyButton.getAllStyles().setPadding(5, 5, 5, 5);
		eastContainer.add(strategyButton);
				
		this.show();
		gw.setHeight(mv.getMapHeight());
		gw.setWidth(mv.getMapWidth());
		gw.init();
	}
}