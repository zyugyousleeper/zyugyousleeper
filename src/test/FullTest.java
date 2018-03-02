package test;

import model.items.ChargeMode;
import model.items.Item;
import model.items.PurchaseMode;
import ui.Container;

public class FullTest {
	public static void main(String[] args) {
		Container<Item> container = new Container<>(); 
		container.addItem(new ChargeMode());
		container.addItem(new PurchaseMode());
		container.setVisible(true);
	}
}
