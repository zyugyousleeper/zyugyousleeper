package test.ui;

import javax.swing.JFrame;

import model.Money;
import ui.PaymentPanel;

public class PaymentPanelTest {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		Money remainingMoney = new Money();
		Money necessaryMoney = new Money();
		necessaryMoney.addMoney(Money.TEN_YEN, 50);
		PaymentPanel paymentModeUi = new PaymentPanel();
		paymentModeUi.setMoneyKinds(Money.HUNDRED_YEN, Money.THOUSAND_YEN);
		frame.add(paymentModeUi);
		frame.setVisible(true);
		remainingMoney.addMoney(Money.TEN_YEN, 50);
		paymentModeUi.update(remainingMoney);
	}
}