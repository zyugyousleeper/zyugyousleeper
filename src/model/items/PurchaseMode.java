package model.items;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.ConfirmationPanel;
import ui.ContainerPanel;
import ui.ModeFrame;

public class PurchaseMode extends ModeFrame implements Item {
	private ContainerPanel<Product> panel = new ContainerPanel<>();
	private ConfirmationPanel panel2 = new ConfirmationPanel();
	private ActionListener productlistener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			next();
		}
	};
	
	public PurchaseMode() {
		super();
		Product product = new Product();
		product.setText("product1");
		product.setlistener(productlistener);

		Product product2 = new Product();
		product2.setText("product2");
		product2.setlistener(productlistener);

		Product product3 = new Product();
		product3.setText("product3");
		product3.setlistener(productlistener);
		
		panel.addItem(product);
		panel.addItem(product2);
		panel.addItem(product3);
		
		addPanel(panel);
		addPanel(panel2);
	}

	
	
	@Override
	public String getText() {
		return "ものを購入";
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
