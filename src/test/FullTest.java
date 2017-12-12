package test;

import model.items.modes.ChargeMode;
import model.items.modes.Mode;
import ui.Container;

public class FullTest {
	public static void main(String[] args) {
		Container<Mode> container = new Container<>(); 
		container.addItem(new ChargeMode());
		
		container.setVisible(true);
	}
}
