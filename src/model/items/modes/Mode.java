package model.items.modes;

import model.items.Item;
import ui.ModeUi;

public class Mode extends Item{
	ModeUi ui = new ModeUi();
	public Mode() {
		
	}
	
	@Override
	public void onClick() {
		super.onClick();
		ui.setVisible(true);
	}
}
