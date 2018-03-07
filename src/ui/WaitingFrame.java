package ui;

import wrapper.FrameWrapper;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.UIManager;

public class WaitingFrame extends FrameWrapper {
	public WaitingFrame() {
		super();
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().setBackground(Color.DARK_GRAY);
		
		JLabel lblNewLabel = new JLabel("カードを置いて下さい");
		lblNewLabel.setForeground(new Color(152, 251, 152));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("IPA Pゴシック", Font.ITALIC, 50));
		getContentPane().add(lblNewLabel, BorderLayout.CENTER);
		
		JLabel lblNewLabel_2 = new JLabel("授業SLEEPER");
		lblNewLabel_2.setForeground(new Color(135, 206, 250));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("IPAゴシック", Font.PLAIN, 20));
		getContentPane().add(lblNewLabel_2, BorderLayout.SOUTH);
	}
}
