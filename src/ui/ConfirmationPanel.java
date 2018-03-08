package ui;

import wrapper.ButtonWrapper;
import wrapper.LabelWrapper;
import wrapper.PanelWrapper;
import model.items.Product;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.border.EmptyBorder;

public class ConfirmationPanel extends PanelWrapper {
	LabelWrapper nameLabel;
	LabelWrapper praceLabel;
	private PanelWrapper panel;
	private ButtonWrapper okButton;
	
	public ConfirmationPanel() {
		super();
		setLayout(new BorderLayout(0, 0));

		LabelWrapper label = new LabelWrapper();
		label.setFont(new Font("Dialog", Font.BOLD, 40));
		label.setText("以下のものを購入しますか？");
		add(label, BorderLayout.NORTH);
		
		panel = new PanelWrapper();
		add(panel, BorderLayout.CENTER);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(new GridLayout(3,1));
		
		nameLabel = new LabelWrapper();
		panel.add(nameLabel);
		nameLabel.setFont(new Font("Dialog", Font.BOLD, 40));
		
		praceLabel = new LabelWrapper();
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
