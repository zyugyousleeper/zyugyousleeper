package presenter;

import model.AbstractMode;
import view.ModeSelector;

public class ModeManager {
	private ModeSelector selector;
	
	public ModeManager() {
		selector = new ModeSelector();
		selector.setVisible(true);
	}
}
