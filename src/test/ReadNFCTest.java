package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ReadNFCTest {
	public static void main(String[] args) {
		MyThread myThread = new MyThread();
		myThread.run();
	}
}

class MyThread extends Thread{
	@Override
	public void run() {
		super.run();
		try {
			while (true) {
				String[] command = {"python","felica2-2.py"};
		        Runtime r = Runtime.getRuntime();
				Process p = r.exec(command);

				int result = p.waitFor();
				System.out.println(result);
				
				BufferedReader r_std = new BufferedReader(new InputStreamReader(p.getInputStream()));
				
				String line_std = null;
				StringBuilder stdOutput = new StringBuilder();
				while ((line_std = r_std.readLine()) != null) {
					stdOutput.append(line_std + "\n");
				}
				System.out.println(stdOutput.toString());
				
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}