package test.ui;

import java.awt.Color;

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
		paymentModeUi.setNecessaryMoney(necessaryMoney);
		paymentModeUi.setMoneyKinds(Money.HUNDRED_YEN, Money.THOUSAND_YEN);
		frame.add(paymentModeUi);
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setVisible(true);
		remainingMoney.addMoney(Money.TEN_YEN, 50);
		paymentModeUi.update(remainingMoney);
	}
}