package test;

import model.NFCThread;

public class ReadNFCTest {
	public static void main(String[] args) {
		try {
			NFCThread nfcThread = new NFCThread();
			nfcThread.start();
			System.out.println("hello");
			Thread.sleep(5000);
			nfcThread.close();
			System.out.println("hello");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
