package ui;

import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import model.items.Item;
import wrapper.PanelWrapper;
import java.awt.Font;
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
			T bufItem = i.next();
			JButton bufButton = new JButton(bufItem.getText());
			bufButton.addActionListener(bufItem.getActionListener());
			bufButton.setFont(new Font("Dialog",Font.BOLD,30));
			add(bufButton);
		}
	}
	
	public void addItem(T mode) {
		this.modes.add(mode);
		refresh();
	}
	
}
