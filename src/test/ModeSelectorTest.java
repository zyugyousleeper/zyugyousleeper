package test;

import model.AbstractMode;
import ui.ModeSelector;

public class ModeSelectorTest {
	public static void main(String[] args) {
		ModeSelector frame = new ModeSelector();
		
		AbstractMode mode = new AbstractMode(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		};

		frame.addMode(mode);
		frame.addMode(mode);
		frame.addMode(mode);
		frame.addMode(mode);
		frame.addMode(mode);
		
		frame.setVisible(true);
	}
}
