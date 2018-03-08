package test;

import java.io.IOException;

import com.pi4j.io.serial.SerialDataEvent;
import com.pi4j.io.serial.SerialDataEventListener;

import model.CoinThread;

public class ReadSignalTest {
    public static void main(String args[]) throws InterruptedException, IOException {
    	System.out.println("hello world");
    	CoinThread coinThread = new CoinThread();
    	coinThread.setSerialDataEventListener(new SerialDataEventListener() {
			@Override
			public void dataReceived(SerialDataEvent arg0) {
				try {
					System.out.println(arg0.getAsciiString());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
    	coinThread.start();
    }
}
