package model;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NFCThread extends Thread{
	boolean moving = false;
	@Override
	public void run() {
		super.run();
		try {
			moving = true;
			while (moving) {
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
			e.printStackTrace();
		}finally {
			
		}
	}
	public void close() {
		moving = false;
	}
}
