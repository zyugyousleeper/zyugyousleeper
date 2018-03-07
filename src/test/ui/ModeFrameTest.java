package test.ui;

import ui.ModeFrame;
import wrapper.PanelWrapper;

public class ModeFrameTest {
	public static void main(String[] args) {
		ModeFrame frame = new ModeFrame();
		
		PanelWrapper panel = new PanelWrapper();
		//panel.setBackground(Color.YELLOW);
		frame.addPanel(panel);
		
		PanelWrapper panel2 = new PanelWrapper();
		//panel2.setBackground(Color.RED);
		frame.addPanel(panel2);
		
		PanelWrapper panel3 = new PanelWrapper();
		//panel3.setBackground(Color.BLUE);
		frame.addPanel(panel3);
		
		frame.setVisible(true);
	}
}
