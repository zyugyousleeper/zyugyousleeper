package model.items;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.ModeFrame;

public class ChargeMode extends ModeFrame implements Item {
	public ChargeMode() {
		super();
	}

	@Override
	public String getText() {
		return "ChargeMode";
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
