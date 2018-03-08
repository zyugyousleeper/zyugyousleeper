package wrapper;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class ButtonWrapper extends JButton{
	public ButtonWrapper() {
		setForeground(Color.GRAY);
		setFont(new Font("Dialog",Font.BOLD,50));
		setBackground(Color.decode("#393939"));
		setBorder(new LineBorder(Color.decode("#303030"),3,true));
	}
}
