package test.ui;

import java.awt.Color;
import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ui.ModeFrame;

public class ModeFrameTest {
	public static void main(String[] args) {
		ModeFrame frame = new ModeFrame();
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.YELLOW);
		frame.addPanel(panel);
		
		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.RED);
		frame.addPanel(panel2);
		
		JPanel panel3 = new JPanel();
		panel3.setBackground(Color.BLUE);
		frame.addPanel(panel3);
		
		frame.setVisible(true);
	}
}
