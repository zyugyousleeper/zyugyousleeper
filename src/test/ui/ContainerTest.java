package test.ui;

import model.User;
import model.items.ChargeMode;
import model.items.Item;
import model.items.PurchaseMode;
import ui.ContainerPanel;
import utils.Utils;
import wrapper.FrameWrapper;

public class ContainerTest {
	public static void main(String[] args) {
		FrameWrapper frameWrapper = new FrameWrapper();
		ContainerPanel<Item> frame = new ContainerPanel<>();
		User user = null;
		try {
			user = Utils.getUser(16001);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		frame.addItem(new ChargeMode(user));
		frame.addItem(new PurchaseMode(user));
		
		frameWrapper.add(frame);
		frameWrapper.setVisible(true);
	}
}
