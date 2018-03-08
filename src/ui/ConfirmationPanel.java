package ui;

import wrapper.ButtonWrapper;
import wrapper.LabelWrapper;
import wrapper.PanelWrapper;
import model.Money;
import model.User;
import model.items.Product;
import utils.Utils;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;

public class ConfirmationPanel extends PanelWrapper {
	private User user;
	private Product product;
	
	private ButtonWrapper okButton;
	private ButtonWrapper cancelButton;
	private LabelWrapper praceLabel = new LabelWrapper();
	private LabelWrapper nameLabel = new LabelWrapper();
	
	public ConfirmationPanel() {
		super();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		LabelWrapper label = new LabelWrapper();
		label.setText("以下のものを購入しますか？");
		
		PanelWrapper labelPanel = new PanelWrapper();
		labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.Y_AXIS));
		labelPanel.add(nameLabel);
		labelPanel.add(praceLabel);
		
		PanelWrapper buttonPanel = new PanelWrapper();
		buttonPanel.setLayout(new GridLayout(1,2));
				
		okButton = new ButtonWrapper();
		okButton.setText("OK");
		okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Money newMoney = new Money(user.getMoney().getMoney()-product.getPrice());
				user.setMoney(newMoney);
				try {
					Utils.patchUser(user);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		buttonPanel.add(okButton);
		
		cancelButton = new ButtonWrapper();
		cancelButton.setText("Cancel");
		buttonPanel.add(cancelButton);
		
		add(label);
		add(labelPanel);
		add(buttonPanel);
	}
	
	public void setCancelListener(ActionListener listener) {
		cancelButton.addActionListener(listener);
	}
	
	public void setOKListener(ActionListener listener) {
		okButton.addActionListener(listener);
	}
	
	public void setProduct(Product product) {
		this.product = product;
		nameLabel.setText("商品名 : "+product.getText());
		praceLabel.setText("価格 : "+String.valueOf(product.getPrice()));
	}
	
	public void setUser(User user) {
		this.user = user;
	}

}
