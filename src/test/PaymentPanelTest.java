package test;

import javax.swing.JFrame;

import model.Money;
import ui.PaymentPanel;

public class PaymentPanelTest {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		Money remainingMoney = new Money();
		Money chargeMoney = new Money();
		PaymentPanel paymentModeUi = new PaymentPanel(remainingMoney, chargeMoney);
		frame.add(paymentModeUi);
		frame.setVisible(true);
		remainingMoney.addMoney(Money.TEN_YEN, 50);
		chargeMoney.addMoney(Money.HUNDRED_YEN, 15);
	}
}