package test;

import model.Money;

public class MoneyTest {
	public static void main(String[] args) {
		Money money = new Money();
		try {
			money.addMoney(Money.FIFTY_YEN, 150);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(money.getMoneyKinds().get(Money.FIFTY_YEN));
	}
}
