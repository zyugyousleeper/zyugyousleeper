package test;

import model.User;
import utils.Utils;

public class JSONTest {
	public static void main(String[] args) {
		try {
			User user = Utils.getUser(16000);
			System.out.println(user.getName()+user.getFelicaID()+user.getStudentNum());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
