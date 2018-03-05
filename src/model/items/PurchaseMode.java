package model.items;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.Container;

public class PurchaseMode extends Container<Product> implements Item {
	public PurchaseMode() {
		super();
		addItem(new Product());
		addItem(new Product());
		addItem(new Product());
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