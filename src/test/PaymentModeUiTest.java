package test;

import javax.swing.JFrame;

import model.Money;
import ui.PaymentModeUi;

public class PaymentModeUiTest {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		Money remainingMoney = new Money();
		Money chargeMoney = new Money();
		PaymentModeUi paymentModeUi = new PaymentModeUi(remainingMoney, chargeMoney);
		frame.add(paymentModeUi);
		frame.setVisible(true);
		remainingMoney.addMoney(Money.TEN_YEN, 50);
		chargeMoney.addMoney(Money.HUNDRED_YEN, 15);
	}
}