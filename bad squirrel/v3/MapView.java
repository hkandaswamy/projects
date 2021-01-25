package com.mycompany.a3;

import java.util.Observable;
import java.util.Observer;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.*;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.geom.Point;

public class MapView extends Container implements Observer{
	private GameWorld gwx;
	
	public MapView() {
		this.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.rgb(255, 0, 0)));
		this.setLayout(new BorderLayout());
	}
	
	public void update(Observable o, Object arg) {
		GameWorld gw = (GameWorld) o;
		gw.displayMap();
		gwx = gw;
		repaint();
		
	}
	
	public double getMapHeight() {
		double height = (double) this.getHeight();
		return height;
	}
	
	public double getMapWidth() {
		double width = (double) this.getWidth();
		return width;
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Point pCmpRelPrnt = new Point(this.getX(), this.getY());
		IIterator itr = gwx.getCollection().getIterator();
		while(itr.hasNext()) {
			GameObject curObject = itr.getNext();
			curObject.draw(g, pCmpRelPrnt);
		}
	}
	
	public void pointerPressed(int x, int y) {
		int px = x - getParent().getAbsoluteX();
		int py = y - getParent().getAbsoluteY();
		Point pPtrRelPrnt = new Point(px, py);
		Point pCmpRelPrnt = new Point(getX(), getY());
		IIterator itr = gwx.getCollection().getIterator();
		while(itr.hasNext()) {
			GameObject curObject = itr.getNext();
			if(curObject instanceof ISelectable) {
				ISelectable selObject = (ISelectable) curObject;
				if(selObject.contains(pPtrRelPrnt, pCmpRelPrnt)) {
					selObject.setSelected(true);
				}
				else {
					selObject.setSelected(false);
				}
			}
		}
		repaint();
	}
}