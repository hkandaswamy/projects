package com.mycompany.a3;

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
		this.getDisabledStyle().setBgColor(ColorUtil.GRAY);
		this.getDisabledStyle().setFgColor(ColorUtil.WHITE);
		this.getDisabledStyle().setStrikeThru(true);
		this.setCommand(command);
	}
}
