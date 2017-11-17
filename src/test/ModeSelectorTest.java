package test;

import model.Item;
import ui.Container;

public class ModeSelectorTest {
	public static void main(String[] args) {
		Container<Item> frame = new Container<>();
		
		Item mode = new Item();

		frame.addMode(mode);
		frame.addMode(mode);
		frame.addMode(mode);
		frame.addMode(mode);
		frame.addMode(mode);
		
		frame.setVisible(true);
	}
}
