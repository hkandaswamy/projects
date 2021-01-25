package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.plaf.Border;

public class CustomButton extends Button{   // customized button for GUI
	public CustomButton(Command command) {
		this.getAllStyles().setBgTransparency(255);
		this.getAllStyles().setBgColor(ColorUtil.rgb(0, 0, 255));
		this.getAllStyles().setFgColor(ColorUtil.WHITE);
		this.getAllStyles().setBorder(Border.createDoubleBorder(2, ColorUtil.BLACK));
		this.setCommand(command);
	}
}
