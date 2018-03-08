package model.items;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.User;
import ui.ConfirmationPanel;
import ui.ContainerPanel;
import ui.ModeFrame;

public class PurchaseMode extends ModeFrame implements Item{
	private User user;
	
	private ContainerPanel<Product> panel = new ContainerPanel<>();
	private ConfirmationPanel panel2 = new ConfirmationPanel();
	Product chocolate = new Product();
	Product coffee = new Product();
	Product cocoa = new Product();
	
	public PurchaseMode(User user) {
		super();
		this.user = user;
		chocolate.setText("ちょこれーと");
		chocolate.setPrice(100);
		chocolate.setlistener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panel2.setProduct(chocolate);
				next();				
			}
		});

		coffee.setText("こーひー");
		coffee.setPrice(10);
		coffee.setlistener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panel2.setProduct(coffee);
				next();				
			}
		});

		cocoa.setText("ここあ");
		cocoa.setPrice(1000);
		cocoa.setlistener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panel2.setProduct(cocoa);
				next();
			}
		});
		
		panel.addItem(chocolate);
		panel.addItem(coffee);
		panel.addItem(cocoa);
		
		addPanel(panel);
		panel2.setUser(user);
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
