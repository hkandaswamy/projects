package com.mycompany.a2;

import java.util.Observable;
import java.util.Observer;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.*;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.plaf.Border;

public class MapView extends Container implements Observer{
	
	public MapView() {
		this.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.rgb(255, 0, 0)));
		this.setLayout(new BorderLayout());
	}
	
	public void update(Observable o, Object arg) {
		GameWorld gw = (GameWorld) o;
		gw.displayMap();
	}
	
	public double getMapHeight() {
		double height = (double) this.getHeight();
		return height;
	}
	
	public double getMapWidth() {
		double width = (double) this.getWidth();
		return width;
	}
}
