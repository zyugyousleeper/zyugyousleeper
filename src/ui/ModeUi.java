package ui;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JToolBar;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Panel;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;

public class ModeUi extends JFrame {
	public ModeUi() {
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JLabel fractionLabel = new JLabel("New label");
		getContentPane().add(fractionLabel, BorderLayout.SOUTH);
		fractionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel buttonPanel = new JPanel();
		getContentPane().add(buttonPanel, BorderLayout.NORTH);
		buttonPanel.setLayout(new BorderLayout(0, 0));
		
		JButton cancelButton = new JButton("New button");
		buttonPanel.add(cancelButton, BorderLayout.EAST);
		
		refresh();
	}

	ArrayList<JPanel> panels = new ArrayList<>();
	int nowPanel = 0;
	
	public void refresh() {
		Iterator<JPanel> i = panels.iterator();
		while(i.hasNext()){
			JPanel bufPanel = i.next();
			bufPanel.setVisible(false);
		}
		if(0<=nowPanel && nowPanel<panels.size()) {
			JPanel bufPanel = panels.get(nowPanel);
			bufPanel.setVisible(true);
			getContentPane().add(bufPanel, BorderLayout.CENTER);
		}
	}
	
	public void next() {
		nowPanel++;
		refresh();
	}
	
	public void back() {
		nowPanel--;
		refresh();
	}
	
	public void addPanel(JPanel panel) {
		this.panels.add(panel);
		refresh();
	}
}
