package test;

import javax.swing.JFrame;

import model.Money;
import ui.PaymentModeUi;

public class PaymentModeUiTest {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		Money remainingMoney = new Money();
		Money chargeMoney = new Money();
		frame.add(new PaymentModeUi(remainingMoney, chargeMoney));
		frame.setVisible(true);
		//paymentModeUi.update();
	}
}