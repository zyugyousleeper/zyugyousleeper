package model.items.modes;

import model.items.Item;
import ui.ModeFrame;

public class Mode extends Item{
	ModeFrame ui = new ModeFrame();
	public Mode() {
		setText("Mode");
	}
	
	@Override
	public void onClick() {
		super.onClick();
		ui.setVisible(true);
	}
}
