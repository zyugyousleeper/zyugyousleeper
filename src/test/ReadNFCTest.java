package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ReadNFCTest {
	public static void main(String[] args) {
		try {
			String[] command = {"python", "felica2.py"};
	        Runtime r = Runtime.getRuntime();
			Process p = r.exec(command);
			
			System.out.println("hello");

			BufferedReader r_std = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line_std = null;
			StringBuilder stdOutput = new StringBuilder();
			while ((line_std = r_std.readLine()) != null) {
				stdOutput.append(line_std + "\n");
			}
			System.out.println(stdOutput.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
		}
	}
}

