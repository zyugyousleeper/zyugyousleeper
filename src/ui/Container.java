package ui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.items.Item;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Iterator;

public class Container<T extends Item> extends JFrame {

	private JPanel contentPane;
	private ArrayList<T> modes = new ArrayList<>();

	/**
	 * Create the frame.
	 */
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
		Iterator<T> i = modes.iterator();
		while(i.hasNext()){
			JButton bufButton = new JButton();
			bufButton.setText((i.next()).getText());
			contentPane.add(bufButton);
		}
	}
	
	public void addItem(T mode) {
		this.modes.add(mode);
		refresh();
	}
	
}
