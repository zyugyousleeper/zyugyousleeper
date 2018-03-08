package test;

import java.util.ArrayList;

import model.NFCThread;
import model.NFCThread.NFCTouchListener;
import model.User;
import model.items.ChargeMode;
import model.items.Item;
import model.items.PurchaseMode;
import ui.ContainerPanel;
import ui.WaitingFrame;
import utils.Utils;
import wrapper.FrameWrapper;

public class FullTest {
	static NFCThread nfcThread;
	static WaitingFrame waitingFrame;
	
	public static void main(String[] args) {
		waitingFrame = new WaitingFrame();
		waitingFrame.setVisible(true);
		
		nfcThread = new NFCThread();
		nfcThread.setNFCTouchListener(listener);
		nfcThread.start();
	}
	
	static NFCTouchListener listener = new NFCTouchListener() {
		FrameWrapper frame;
		ContainerPanel<Item> panel;
		ChargeMode chargeMode;
		PurchaseMode purchaseMode;
		
		@Override
		public void onConnect(String id) {
			System.out.println(id);
			User user = null;
			try {
				ArrayList<User> users = Utils.getUsers();
				for(User u : users) {
					System.out.println(u.getFelicaID());
					if(u.getFelicaID().equals(id)) user = u;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(user==null) {
				user=new User();
				System.out.println("userがない");
			}
			
			waitingFrame.setVisible(false);
			
			frame = new FrameWrapper();
			panel = new ContainerPanel<>();
			frame.add(panel);
			
			chargeMode = new ChargeMode(user);
			purchaseMode = new PurchaseMode(user);
			panel.addItem(chargeMode);
			panel.addItem(purchaseMode);
			
			frame.setVisible(true);
		}
		
		@Override
		public void onRelease(String id) {
			waitingFrame.setVisible(true);
			
			frame.setVisible(false);
			chargeMode.finush();
			chargeMode.setVisible(false);
			purchaseMode.setVisible(false);
		}
	};
}
