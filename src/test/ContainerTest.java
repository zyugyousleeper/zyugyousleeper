package test;

import model.Item;
import ui.Container;

public class ContainerTest {
	public static void main(String[] args) {
		Container<Item> frame = new Container<>();
		
		Item mode = new Item();
		mode.setText("hello");

		frame.addItem(mode);
		frame.addItem(mode);
		frame.addItem(mode);
		frame.addItem(mode);
		frame.addItem(mode);
		
		frame.setVisible(true);
	}
}
