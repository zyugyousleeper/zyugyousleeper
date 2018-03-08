package wrapper;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

public class FrameWrapper extends JFrame{
	public FrameWrapper() {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setBackground(Color.decode("#303030"));
	}
}
