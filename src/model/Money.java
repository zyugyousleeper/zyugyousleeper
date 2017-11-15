package model;

public class Money {
	public static final int ONE_YEN = 1;
	public static final int FIVE_YEN = 5;
	public static final int TEN_YEN = 10;
	public static final int FIFTY_YEN = 50;
	public static final int HUNDRED_YEN = 100;
	public static final int FIVEHUNDRED_YEN = 500;
	public static final int THOUSAND_YEN = 1000;
	public static final int TWOTHOUSAND_YEN = 2000;
	public static final int FIVETHOUSAND_YEN = 5000;
	
	private int money = 0;
	
	public Money() {
		// TODO Auto-generated constructor stub
	}
	
	public Money(int money) {
		this.money = money;
	}
	
	public int getMoney() {
		return this.money;
	}
}
