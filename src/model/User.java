package model;

public class User {
	private String name;
	private int userID;
	private String felicaID;
	private Money money;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStudentNum() {
		return userID;
	}
	public void setStudentNum(int studentNum) {
		this.userID = studentNum;
	}
	public String getFelicaID() {
		return felicaID;
	}
	public void setFelicaID(String felicaID) {
		this.felicaID = felicaID;
	}
	public Money getMoney() {
		return this.money;
	}
	public void setMoney(Money money) {
		this.money = money;
	}
}
