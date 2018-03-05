package test;

import model.Money;
import model.User;
import utils.Utils;

public class JSONTest {
	public static void main(String[] args) {
		try {
			User user = new User();
			user.setFelicaID("SYARO");
			user.setName("シャロ");
			user.setStudentNum(16009);
			user.setMoney(new Money(0));
			
			Utils.deleteUser(user.getStudentNum());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
