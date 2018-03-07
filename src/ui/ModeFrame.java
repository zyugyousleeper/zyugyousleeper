package ui;

import java.awt.BorderLayout;
import wrapper.FrameWrapper;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.util.Iterator;

public class ModeFrame extends FrameWrapper {
	ArrayList<JPanel> panels = new ArrayList<>();
	int nowPanel = 0;
	
	public ModeFrame() {
		super();
		refresh();
	}
	
	public void refresh() {
		Iterator<JPanel> i = panels.iterator();
		while(i.hasNext()){
			JPanel bufPanel = i.next();
			bufPanel.setVisible(false);
		}
		if(0<=nowPanel && nowPanel<panels.size()) {
			JPanel bufPanel = panels.get(nowPanel);
			bufPanel.setVisible(true);
			getContentPane().add(bufPanel, BorderLayout.CENTER);
		}
	}
	
	public void next() {
		if(nowPanel < panels.size()-1) nowPanel++;
		refresh();
	}
	
	public void back() {
		if(nowPanel > 0) nowPanel--;
		refresh();
	}
	
	public void addPanel(JPanel panel) {
		this.panels.add(panel);
		refresh();
	}
}
