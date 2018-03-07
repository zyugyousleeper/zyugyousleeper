package ui;

import wrapper.ButtonWrapper;
import wrapper.LabelWrapper;
import wrapper.PanelWrapper;
import model.items.Product;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;

public class ConfirmationPanel extends PanelWrapper {

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
		buttonPanel.add(okButton);
		
		cancelButton = new ButtonWrapper();
		cancelButton.setText("Cancel");
		buttonPanel.add(cancelButton);
		
		add(label);
		add(labelPanel);
		add(buttonPanel);
	}
	
	public void setProduct(Product product) {
		nameLabel.setText("商品名 : "+product.getText());
		praceLabel.setText("価格 : "+String.valueOf(product.getPrice()));
	}

}
