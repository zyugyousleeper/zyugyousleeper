package test.ui;

import model.items.ChargeMode;
import model.items.Item;
import model.items.PurchaseMode;
import ui.Container;

public class ContainerTest {
	public static void main(String[] args) {
		Container<Item> frame = new Container<>();
		
		frame.addItem(new ChargeMode());
		frame.addItem(new PurchaseMode());
		
		frame.setVisible(true);
	}
}
