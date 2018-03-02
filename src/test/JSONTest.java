package test;

import com.mysql.jdbc.Util;

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
		System.exit(0);
		try {
			User user = new User();
			user.setFelicaID("HELLOWORLD");
			user.setName("namenamename");
			user.setStudentNum(15000);
			
			Utils.postUser(user);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
