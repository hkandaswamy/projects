package com.mycompany.a3;

import com.codename1.ui.Form;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Container;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.util.UITimer;
import com.mycompany.commands.*;
import java.lang.String;

/**
 * Builds an instance of the game
 * using its connections to the other classes.
 *
 * @param GameWorld gw holds the game "board"
 * to signal to the listeners that the user wishes
 * to quit the game, thus locking them out of the
 * other options
 */
public class Game extends Form implements Runnable {
	
	private final int TICKRATE = 20;
	private UITimer timer;
	private BGSound bg;
	private GameWorld gw;
	private MapView mv;
	private ScoreView sv;
	private static String gameTitle = "Bad Squirrel!";
	private CustomButton accelerateButton;
	private CustomButton brakeButton;
	private CustomButton leftTurnButton;
	private CustomButton rightTurnButton;
	private CustomButton strategyButton;
	private CustomButton pauseButton;
	private CustomButton positionButton;
	private AccelerateCommand accelerateCommand;
	private BrakeCommand brakeCommand;
	private LeftTurnCommand leftTurnCommand;
	private RightTurnCommand rightTurnCommand;
	private StrategyCommand strategyCommand;
	private PauseCommand pauseCommand;
	private PositionCommand positionCommand;
	private boolean paused;
	
	public Game() {
		this.setLayout(new BorderLayout());
		gw = new GameWorld();
		mv = new MapView();
		sv = new ScoreView();
		gw.addObserver(mv);
		gw.addObserver(sv);	
		paused = false;
		
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
		
		accelerateCommand = new AccelerateCommand(gw);
		addKeyListener('a', accelerateCommand);
		titleBar.addCommandToSideMenu(accelerateCommand);
		accelerateButton = new CustomButton(accelerateCommand);
		accelerateButton.getAllStyles().setPadding(5, 5, 5, 5);		
		westContainer.add(accelerateButton);
		
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
		
		brakeCommand = new BrakeCommand(gw);
		addKeyListener('b', brakeCommand);
		brakeButton = new CustomButton(brakeCommand);
		brakeButton.getAllStyles().setPadding(5, 5, 5, 5);
		eastContainer.add(brakeButton);
		
		leftTurnCommand = new LeftTurnCommand(gw);
		addKeyListener('l', leftTurnCommand);
		leftTurnButton = new CustomButton(leftTurnCommand);
		leftTurnButton.getAllStyles().setPadding(5, 5, 5, 5);		
		westContainer.add(leftTurnButton);
		
		rightTurnCommand = new RightTurnCommand(gw);
		addKeyListener('r', rightTurnCommand);
		rightTurnButton = new CustomButton(rightTurnCommand);
		rightTurnButton.getAllStyles().setPadding(5, 5, 5, 5);		
		eastContainer.add(rightTurnButton);
		
		strategyCommand = new StrategyCommand(gw);
		strategyButton = new CustomButton(strategyCommand);
		strategyButton.getAllStyles().setPadding(5, 5, 5, 5);
		westContainer.add(strategyButton);
		
		positionCommand = new PositionCommand(gw);
		positionButton = new CustomButton(positionCommand);
		positionButton.getAllStyles().setPadding(10, 10, 10, 10);
		southContainer.add(positionButton);
		positionButton.setEnabled(false);
		
		pauseCommand = new PauseCommand(this);
		pauseButton = new CustomButton(pauseCommand);
		pauseButton.getAllStyles().setPadding(10, 10, 10, 10);
		southContainer.add(pauseButton);
				
		this.show();
		gw.setHeight(mv.getMapHeight());
		gw.setWidth(mv.getMapWidth());
		gw.init();
		timer = new UITimer(this);
		timer.schedule(TICKRATE, true, this);
		bg = new BGSound("Background Music.mp3");
	}
	
	public void pauseSwitch() {
		paused = !paused;
		accelerateButton.setEnabled(!accelerateButton.isEnabled());
		brakeButton.setEnabled(!brakeButton.isEnabled());
		leftTurnButton.setEnabled(!leftTurnButton.isEnabled());
		rightTurnButton.setEnabled(!rightTurnButton.isEnabled());
		strategyButton.setEnabled(!strategyButton.isEnabled());
		if(paused) {
			timer.cancel();
			bg.pause();
			pauseButton.setText("Play");
			removeKeyListener('a', accelerateCommand);
			removeKeyListener('b', brakeCommand);
			removeKeyListener('l', leftTurnCommand);
			removeKeyListener('r', rightTurnCommand);
			positionButton.setEnabled(true);
		}
		else {
			timer.schedule(TICKRATE, true, this);
			if(gw.getSound()) {
				bg.play();
			}
			pauseButton.setText("Pause");
			addKeyListener('a', accelerateCommand);
			addKeyListener('b', brakeCommand);
			addKeyListener('l', leftTurnCommand);
			addKeyListener('r', rightTurnCommand);
			positionButton.setEnabled(false);
		}
	}
	
	public void run() {
		gw.clockTick(TICKRATE);
		if(gw.getLives() == 0) {
			bg.pause();
			timer.cancel();
			gw.exit();
		}
	}
}