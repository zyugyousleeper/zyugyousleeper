package ui;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JToolBar;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;

public class ModeUi extends JFrame {
	public ModeUi() {
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.YELLOW);
		getContentPane().add(panel, BorderLayout.CENTER);
		
		JLabel fractionLabel = new JLabel("New label");
		getContentPane().add(fractionLabel, BorderLayout.SOUTH);
		fractionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel buttonPanel = new JPanel();
		getContentPane().add(buttonPanel, BorderLayout.NORTH);
		buttonPanel.setLayout(new BorderLayout(0, 0));
		
		JButton cancelButton = new JButton("New button");
		buttonPanel.add(cancelButton, BorderLayout.EAST);
	}

}
