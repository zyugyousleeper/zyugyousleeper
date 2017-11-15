package ui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ModeSelector extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		JFrame frame = new ModeSelector();
		frame.add(new JButton());
		frame.setVisible(true);
	}

	
	/**
	 * Create the frame.
	 */
	public ModeSelector() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
