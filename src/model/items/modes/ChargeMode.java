package model.items.modes;

import java.awt.Color;

import javax.swing.JPanel;

public class ChargeMode extends Mode {
	public ChargeMode() {
		JPanel panel = new JPanel();
		panel.setBackground(Color.YELLOW);
		ui.addPanel(panel);
		
		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.RED);
		ui.addPanel(panel2);
		
		JPanel panel3 = new JPanel();
		panel3.setBackground(Color.BLUE);
		ui.addPanel(panel3);
		
		JPanel panel4 = new JPanel();
		panel4.setBackground(Color.GREEN);
		ui.addPanel(panel4);
		
		JPanel panel5 = new JPanel();
		panel5.setBackground(Color.BLACK);
		ui.addPanel(panel5);
	}
}
