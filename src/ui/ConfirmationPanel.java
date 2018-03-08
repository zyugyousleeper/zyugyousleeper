package ui;

import wrapper.ButtonWrapper;
import wrapper.LabelWrapper;
import wrapper.PanelWrapper;
import model.User;
import model.items.Product;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;

public class ConfirmationPanel extends PanelWrapper {
	private Product product;
	private User user;
	
	private ButtonWrapper okButton = new ButtonWrapper();
	private ButtonWrapper cancelButton = new ButtonWrapper();
	
	public ConfirmationPanel() {
		super();
	}
	
	public void setCancelListener(ActionListener listener) {
		cancelButton.addActionListener(listener);
	}
	
	public void setOKListener(ActionListener listener) {
		okButton.addActionListener(listener);
	}
	
	public Product getProduct() {
		return this.product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public void setupUI() {
		if(user==null || product==null) {
			System.out.println("userかproductがnull");
		}
		removeAll();
		if(user.getMoney().getMoney()-product.getPrice() > 0) {
			//ちゃんと買える
			setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

			LabelWrapper label = new LabelWrapper();
			label.setText("以下のものを購入しますか？");
			
			PanelWrapper labelPanel = new PanelWrapper();
			labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.Y_AXIS));
			LabelWrapper nameLabel = new LabelWrapper();
			nameLabel.setText("商品 : "+product.getText());
			labelPanel.add(nameLabel);
			LabelWrapper praceLabel = new LabelWrapper();
			praceLabel.setText("価格 : "+product.getPrice());
			labelPanel.add(praceLabel);
			
			PanelWrapper buttonPanel = new PanelWrapper();
			buttonPanel.setLayout(new GridLayout(1,2));
			
			okButton.setText("OK");
			buttonPanel.add(okButton);
			
			cancelButton.setText("Cancel");
			buttonPanel.add(cancelButton);
			
			add(label);
			add(labelPanel);
			add(buttonPanel);
		}else {
			//残額が足りない
			setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

			LabelWrapper label = new LabelWrapper();
			label.setText("残額が足りません お金をチャージしてください");
			
			PanelWrapper buttonPanel = new PanelWrapper();
			buttonPanel.setLayout(new GridLayout(1,2));
			
			cancelButton.setText("Cancel");
			buttonPanel.add(cancelButton);
			
			add(label);
			add(buttonPanel);
		}
	}
}
