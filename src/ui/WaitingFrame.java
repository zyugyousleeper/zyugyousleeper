package ui;

import wrapper.FrameWrapper;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;

public class WaitingFrame extends FrameWrapper {
	public WaitingFrame() {
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("カードをおいてください");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 40));
		getContentPane().add(lblNewLabel, BorderLayout.CENTER);
	}
}
