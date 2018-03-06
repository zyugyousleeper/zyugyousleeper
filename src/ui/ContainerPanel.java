package ui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.items.Item;
import wrapper.FrameWrapper;
import wrapper.PanelWrapper;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Iterator;

public class ContainerPanel<T extends Item> extends PanelWrapper {

	private ArrayList<T> modes = new ArrayList<>();

	public ContainerPanel() {
		setBounds(100, 100, 450, 300);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new GridLayout(2,3));
	}
	
	public void refresh() {
		removeAll();
		Iterator<T> i = modes.iterator();
		while(i.hasNext()){
			JButton bufButton = new JButton();
			T bufItem = i.next();
			bufButton.addActionListener(bufItem.getActionListener());
			bufButton.setText(bufItem.getText());
			add(bufButton);
		}
	}
	
	public void addItem(T mode) {
		this.modes.add(mode);
		refresh();
	}
	
}
