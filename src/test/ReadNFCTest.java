package test;

import model.NFCThread;
import model.NFCThread.NFCTouchListener;

public class ReadNFCTest {
	public static void main(String[] args) {
		try {
			NFCThread nfcThread = new NFCThread();
			nfcThread.setNFCTouchListener(new NFCTouchListener() {
				
				@Override
				public void onRelease(String id) {
					System.out.println("release:"+id);
				}
				
				@Override
				public void onConnect(String id) {
					System.out.println("connect:"+id);
				}
			});
			nfcThread.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
