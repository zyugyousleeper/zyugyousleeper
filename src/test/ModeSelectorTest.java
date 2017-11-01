package test;

import javax.swing.JButton;
import javax.swing.JFrame;

import model.AbstractMode;
import ui.ModeSelector;

class ModeSelectorTest {
	public static void main(String[] args) {
		ModeSelector frame = new ModeSelector();
		
		frame.addMode(new AbstractMode() {
			@Override
			public void run() {
				System.out.println("hello");
			}
		});
		
		frame.setVisible(true);
	}
}
