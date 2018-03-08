package model;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NFCThread extends Thread{
	private boolean moving = false;
	private String previousID = "";
	private NFCTouchListener listener;
	
	@Override
	public void run() {
		super.run();
		try {
			moving = true;
			while (moving) {
				String[] command = {"python","felica2-3.py"};
		        Runtime r = Runtime.getRuntime();
				Process p = r.exec(command);

				int result = p.waitFor();
				System.out.println(result);
				
				BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
				String buf = null;
				StringBuilder builder = new StringBuilder();
				while ((buf = br.readLine()) != null) {
					builder.append(buf + "\n");
				}
				String buf2 = builder.toString();
				int end = buf2.length()-2;
				end = end< 0 ? 0 : end;
				buf2 = buf2.substring(0, end);
				callListener(buf2);
				
				Thread.sleep(500);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
		}
	}
	
	private void callListener(String output) {
		if(output.equals(previousID) || listener==null) return;
		if(!previousID.equals("")) listener.onRelease(previousID);
		if(!output.equals("")) listener.onConnect(output);
		previousID = output;
	}
	
	public void setNFCTouchListener(NFCTouchListener listener) {
		this.listener = listener;
	}
	
	public void close() {
		moving = false;
	}
	
	public interface NFCTouchListener{
		void onConnect(String id);
		void onRelease(String id);
	}
}
