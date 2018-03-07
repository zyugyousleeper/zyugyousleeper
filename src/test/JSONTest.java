package test;

import java.util.Arrays;

import model.Money;
import model.User;
import utils.Utils;

public class JSONTest {
	public static final int GET = 0;
	public static final int POST = 1;
	public static final int PATCH = 2;
	public static final int DELETE = 3;
	public static final java.util.List<String> REQUEST = Arrays.asList("GET", "POST", "PATCH", "DELETE");
	
	public static void main(String[] args) {
		try {
			User user = new User();
			user.setFelicaID("SYARO");
			user.setName("シャロ");
			user.setStudentNum(16009);
			user.setMoney(new Money(0));
			
			//printLog(user, DELETE);
			printLog(user, POST);
			printLog(user, GET);
			user.getMoney().addMoney(Money.HUNDRED_YEN, 100);
			printLog(user, PATCH);
			printLog(user, GET);
			printLog(user, DELETE);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void printUser(User user) {
		System.out.println("{名前：" + user.getName() + ", 学籍番号：" + user.getStudentNum() + ", フェリカID：" + user.getFelicaID() + ", 所持金：" + user.getMoney().getMoney() + "}");
	}
	public static User goRequest(User user, int mode) {
		User reUser = new User();
		try {
			if(mode == GET) reUser = Utils.getUser(user.getStudentNum());
			else if(mode == POST) reUser = Utils.postUser(user);
			else if (mode == PATCH) reUser = Utils.patchUser(user);
			else if (mode == DELETE) {
				Utils.deleteUser(user.getStudentNum());
				reUser = user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reUser;
	}
	public static User printLog(User user, int mode) {
		System.out.println(REQUEST.get(mode) + "：");
		User reUser = goRequest(user, mode);
		printUser(reUser);
		System.out.println("");
		return reUser;
	}
}
