package model.items;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.User;
import ui.ModeFrame;
import ui.PaymentPanel;

public class ChargeMode extends ModeFrame implements Item {
	private User user;
	
	public ChargeMode(User user) {
		super();
		this.user = user;
		addPanel(new PaymentPanel());
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
}
