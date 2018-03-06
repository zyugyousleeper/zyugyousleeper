package test.ui;

import model.items.ChargeMode;
import model.items.Item;
import model.items.PurchaseMode;
import ui.ContainerPanel;
import wrapper.FrameWrapper;

public class ContainerTest {
	public static void main(String[] args) {
		FrameWrapper frameWrapper = new FrameWrapper();
		ContainerPanel<Item> frame = new ContainerPanel<>();
		
		frame.addItem(new ChargeMode());
		frame.addItem(new PurchaseMode());
		
		frameWrapper.add(frame);
		frameWrapper.setVisible(true);
	}
}
