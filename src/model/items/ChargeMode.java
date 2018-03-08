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
	private PaymentPanel panel = new PaymentPanel();
	private CoinThread coinThread = new CoinThread();
	
	public ChargeMode(User user_) {
		super();
		this.user = user_;
		panel.update(user.getMoney());
		panel.setMoneyKinds(Money.FIVEHUNDRED_YEN,Money.HUNDRED_YEN,Money.FIFTY_YEN,Money.TEN_YEN);
		addPanel(panel);
		
		coinThread.setSerialDataEventListener(this);
		coinThread.start();
	}
	
	public void finush() {
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
			user.getMoney().addMoney(kind, 1);
			panel.update(user.getMoney());
			Utils.patchUser(user);
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
