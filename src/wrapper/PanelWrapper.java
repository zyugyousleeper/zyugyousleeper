package wrapper;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PanelWrapper extends JPanel{
	public PanelWrapper() {
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setBackground(Color.decode("#606060"));
	}
}
