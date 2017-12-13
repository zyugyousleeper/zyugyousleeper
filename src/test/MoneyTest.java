package test;

import model.Money;

public class MoneyTest {
	public static void main(String[] args) {
		Money money = new Money();
		Money money2 = new Money();
		money.addMoney(Money.HUNDRED_YEN, 5);
		money.addMoney(Money.FIVEHUNDRED_YEN, 1);
		money2.addMoney(Money.HUNDRED_YEN, 8);
		money.plusMoney(money2);
		System.out.println(money.getMoneyKinds().get(Money.HUNDRED_YEN));
	}
}
