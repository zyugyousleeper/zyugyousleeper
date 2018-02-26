package model.items.modes;

import com.pi4j.io.serial.SerialDataEvent;
import com.pi4j.io.serial.SerialDataEventListener;

import model.CoinThread;
import model.Money;
import ui.PaymentPanel;

public class ChargeMode extends Mode {
	public ChargeMode() {
		setText("ChargeMode");
		
		PaymentPanel panel = new PaymentPanel();
		panel.setMoneyKinds(Money.FIVEHUNDRED_YEN,Money.HUNDRED_YEN,Money.FIFTY_YEN,Money.TEN_YEN);
		Money now = new Money();
		
		CoinThread coinThread = new CoinThread();
		coinThread.setSerialDataEventListener(new SerialDataEventListener() {
			@Override
			public void dataReceived(SerialDataEvent arg0) {
				try {
					String inputMoney = arg0.getAsciiString();
					int kindOfMoney = Integer.parseInt(inputMoney);
					now.addMoney(kindOfMoney, 1);
					
					System.out.println(kindOfMoney);
					System.out.println(now.getMoneyKinds().get(kindOfMoney));
				} catch (Exception e) {
					System.out.println(e);
				}
				panel.update(now);
			}
		});
		coinThread.start();
		ui.addPanel(panel);
	}
}
