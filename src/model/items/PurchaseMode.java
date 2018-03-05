package model.items;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ui.ModeFrame;

public class PurchaseMode extends ModeFrame implements Item {
	public PurchaseMode() {
		super();
	}

	@Override
	public String getText() {
		return "PurchaseMode";
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
