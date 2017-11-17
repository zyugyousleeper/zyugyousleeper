package test;

import model.Item;
import ui.ModeSelector;

public class ModeSelectorTest {
	public static void main(String[] args) {
		ModeSelector frame = new ModeSelector();
		
		Item mode = new Item(){
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
