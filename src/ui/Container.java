package ui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.items.Item;
import wrapper.FrameWrapper;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

public class Container<Item> extends FrameWrapper {

	private JPanel contentPane;
	private ArrayList<Item> modes = new ArrayList<>();

	public Container() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(2,3));
	}
	
	public void refresh() {
		contentPane.removeAll();
		Iterator<Item> i = modes.iterator();
		while(i.hasNext()){
			JButton bufButton = new JButton();
			Item bufItem = i.next();
//			bufButton.addActionListener(e -> bufItem.());
			bufButton.setText(bufItem.toString());
			contentPane.add(bufButton);
		}
	}
	
	public void addItem(Item mode) {
		this.modes.add(mode);
		refresh();
	}
	
}
