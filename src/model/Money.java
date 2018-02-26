package model;

import java.util.HashMap;
import java.util.Map;

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
	HashMap<Integer, Integer> moneyKinds = new HashMap<>();
			
	public Money() {
		// TODO Auto-generated constructor stub
	}
	
	public void addMoney(int kind,int numberOfCoins) {
		int nowCoins = moneyKinds.get(kind)== null ? 0:moneyKinds.get(kind);
		this.moneyKinds.put(kind, numberOfCoins + nowCoins);
		this.money += kind*numberOfCoins;
	}
	
	public void addMoneyFromAmount(int kind,int amount) throws Exception {
		if(amount % kind == 0) {
			this.moneyKinds.put(kind, amount/kind);
			this.money += amount;
		}else {
			throw new Exception("kingakuto okaneno syuruiga awanai");
		}
	}
	
	public void plusMoney(Money money) {
		this.money += money.money;
		for(Map.Entry<Integer,Integer> map : money.moneyKinds.entrySet()) {
			Integer buf = this.moneyKinds.get(map.getKey()); 
			if(buf != null) {
				this.moneyKinds.put(map.getKey(), map.getValue()+buf);
			}else {
				this.moneyKinds.put(map.getKey(), map.getValue());
			}
		}
	}
	
	public int getMoney() {
		return this.money;
	}
	
	public HashMap<Integer, Integer> getMoneyKinds() {
		return this.moneyKinds;
	}
	
	public void reset() {
		this.money = 0;
		this.moneyKinds.clear();
	}
}
