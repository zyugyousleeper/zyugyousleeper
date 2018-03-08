package ui;

import wrapper.FrameWrapper;
import wrapper.LabelWrapper;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class WaitingFrame extends FrameWrapper {
	public WaitingFrame() {
		super();
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		LabelWrapper lblNewLabel = new LabelWrapper();
		lblNewLabel.setText("カードを置いて下さい");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblNewLabel, BorderLayout.CENTER);
		
		LabelWrapper lblNewLabel_2 = new LabelWrapper();
		lblNewLabel_2.setText("授業SLEEPER");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblNewLabel_2, BorderLayout.SOUTH);
	}
}
