package wrapper;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class ButtonWrapper extends JButton{
	public ButtonWrapper() {
		setForeground(Color.LIGHT_GRAY);
		setFont(new Font("Dialog",Font.BOLD,50));
		setBackground(Color.GRAY);
		setBorder(new LineBorder(Color.decode("#606060"),3,true));
	}
}
