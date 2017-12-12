package ui;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JToolBar;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import java.awt.GridLayout;

public class ModeUi extends JFrame {
	public ModeUi() {
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JLabel fractionLabel = new JLabel("New label");
		getContentPane().add(fractionLabel, BorderLayout.SOUTH);
		fractionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel buttonPanel = new JPanel();
		getContentPane().add(buttonPanel, BorderLayout.NORTH);
		buttonPanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton nextButton = new JButton("next");
		nextButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				next();
			}
		});
		buttonPanel.add(nextButton);
		
		JButton backButton = new JButton("back");
		backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				back();
			}
		});
		buttonPanel.add(backButton);
		
		JButton cancelButton = new JButton("cancel");
		buttonPanel.add(cancelButton);
		
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
