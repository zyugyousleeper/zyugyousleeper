package model.items;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.ContainerPanel;
import ui.ModeFrame;

public class PurchaseMode extends ModeFrame implements Item {
	private ContainerPanel<Product> panel = new ContainerPanel<>();
	
	public PurchaseMode() {
		super();
		panel.addItem(new Product());
		panel.addItem(new Product());
		panel.addItem(new Product());
		addPanel(panel);
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
