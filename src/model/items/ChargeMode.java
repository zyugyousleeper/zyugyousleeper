package model.items;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import com.pi4j.io.serial.SerialDataEvent;
import com.pi4j.io.serial.SerialDataEventListener;

import model.CoinThread;
import model.Money;
import model.User;
import ui.ModeFrame;
import ui.PaymentPanel;
import utils.Utils;

public class ChargeMode extends ModeFrame implements Item ,SerialDataEventListener {
	private User user;
	private Money money = new Money();
	private PaymentPanel panel = new PaymentPanel();
	private CoinThread coinThread = new CoinThread();
	
	public ChargeMode(User user) {
		super();
		this.user = user;
		panel.setMoneyKinds(Money.FIVEHUNDRED_YEN,Money.HUNDRED_YEN,Money.FIFTY_YEN,Money.TEN_YEN);
		addPanel(panel);
		
		coinThread.setSerialDataEventListener(this);
		coinThread.start();
	}
	
	public void finush() {
		user.setMoney(money);
		try {
			Utils.patchUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		coinThread.close();
	}

	@Override
	public String getText() {
		return "お金をチャージ";
	}

	@Override
	public ActionListener getActionListener() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(true);
			}
		};
	}

	@Override
	public void dataReceived(SerialDataEvent arg0) {
		try {
			int kind = Integer.valueOf(arg0.getAsciiString());
			money.addMoney(kind, 1);
			panel.update(money);
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
