package test;

import javax.swing.JFrame;

import model.Money;
import ui.PaymentModeUi;

public class PaymentModeUiTest {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		Money remainingMoney = new Money();
		Money necessaryMoney = new Money();
		necessaryMoney.addMoney(Money.TEN_YEN, 50);
		PaymentModeUi paymentModeUi = new PaymentModeUi();
		paymentModeUi.setNecessaryMoney(necessaryMoney);
		paymentModeUi.setMoneyKinds(Money.HUNDRED_YEN, Money.THOUSAND_YEN);
		frame.add(paymentModeUi);
		frame.setVisible(true);
		remainingMoney.addMoney(Money.TEN_YEN, 50);
		paymentModeUi.update(remainingMoney);
	}
}