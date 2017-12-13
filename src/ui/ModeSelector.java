package ui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.AbstractMode;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Iterator;

public class ModeSelector extends JFrame {

	private JPanel contentPane;
	private ArrayList<AbstractMode> modes = new ArrayList<>();

	/**
	 * Create the frame.
	 */
	public ModeSelector() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(2,3));
	}
	
	public void refresh() {
		contentPane.removeAll();
		Iterator<AbstractMode> i = modes.iterator();
		while(i.hasNext()){
			JButton bufButton = new JButton();
			bufButton.setText((i.next()).getText());
			contentPane.add(bufButton);
		}
	}
	
	public void addMode(AbstractMode mode) {
		this.modes.add(mode);
		refresh();
	}
	
}