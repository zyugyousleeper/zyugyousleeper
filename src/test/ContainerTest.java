package test;

import model.Item;
import ui.Container;

public class ContainerTest {
	public static void main(String[] args) {
		Container<Item> frame = new Container<>();
		
		Item mode = new Item();
		mode.setText("hello");

		frame.addMode(mode);
		frame.addMode(mode);
		frame.addMode(mode);
		frame.addMode(mode);
		frame.addMode(mode);
		
		frame.setVisible(true);
	}
}
