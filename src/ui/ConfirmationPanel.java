package ui;

import wrapper.ButtonWrapper;
import wrapper.PanelWrapper;
import javax.swing.JLabel;
import model.items.Product;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class ConfirmationPanel extends PanelWrapper {
	JLabel nameLabel;
	JLabel praceLabel;
	private JPanel panel;
	private JButton okButton;
	
	public ConfirmationPanel() {
		super();
		setLayout(new BorderLayout(0, 0));

		JLabel label = new JLabel("以下のものを購入しますか？");
		label.setFont(new Font("Dialog", Font.BOLD, 40));
		add(label, BorderLayout.NORTH);
		
		panel = new PanelWrapper();
		add(panel, BorderLayout.CENTER);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(new GridLayout(3,1));
		
		nameLabel = new JLabel("");
		panel.add(nameLabel);
		nameLabel.setFont(new Font("Dialog", Font.BOLD, 40));
		
		praceLabel = new JLabel("");
		panel.add(praceLabel);
		praceLabel.setFont(new Font("Dialog", Font.BOLD, 40));
		
		okButton = new ButtonWrapper();
		okButton.setFont(new Font("Dialog", Font.BOLD, 40));
		okButton.setText("OK");
		panel.add(okButton);
		
	}
	
	public void setProduct(Product product) {
		nameLabel.setText("商品名 : "+product.getText());
		praceLabel.setText("価格 : "+String.valueOf(product.getPrice()));
	}

}
