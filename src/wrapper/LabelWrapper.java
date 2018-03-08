package wrapper;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class LabelWrapper extends JLabel{
	public LabelWrapper() {
		setFont(new Font("Dialog", Font.BOLD, 40));
		setForeground(Color.GRAY);
	}
}
