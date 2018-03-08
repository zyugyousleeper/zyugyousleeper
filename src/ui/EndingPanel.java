package ui;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.SwingConstants;

import wrapper.LabelWrapper;
import wrapper.PanelWrapper;

public class EndingPanel extends PanelWrapper {
	public EndingPanel() {
		setLayout(new BorderLayout(0, 0));
		

		LabelWrapper lblNewLabel = new LabelWrapper();
		lblNewLabel.setText("引き落としました\nカードを離してください");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 60));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel, BorderLayout.CENTER);
	}
}
