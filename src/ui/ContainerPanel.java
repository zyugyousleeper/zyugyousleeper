package ui;

import javax.swing.border.EmptyBorder;
import model.items.Item;
import wrapper.ButtonWrapper;
import wrapper.PanelWrapper;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Iterator;

public class ContainerPanel<T extends Item> extends PanelWrapper {

	private ArrayList<T> modes = new ArrayList<>();

	public ContainerPanel() {
		super();
		setBounds(100, 100, 450, 300);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new GridLayout(2,3));
	}
	
	public void refresh() {
		removeAll();
		Iterator<T> i = modes.iterator();
		while(i.hasNext()){
			T bufItem = i.next();
			ButtonWrapper bufButton = new ButtonWrapper();
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
