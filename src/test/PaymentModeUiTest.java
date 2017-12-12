package test;

import javax.swing.JFrame;

import ui.PaymentModeUi;

public class PaymentModeUiTest {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.add(new PaymentModeUi());
		frame.setVisible(true);
		//paymentModeUi.update();
	}
}