package model;

import com.pi4j.io.serial.Baud;
import com.pi4j.io.serial.DataBits;
import com.pi4j.io.serial.FlowControl;
import com.pi4j.io.serial.Parity;
import com.pi4j.io.serial.Serial;
import com.pi4j.io.serial.SerialConfig;
import com.pi4j.io.serial.SerialDataEventListener;
import com.pi4j.io.serial.SerialFactory;
import com.pi4j.io.serial.StopBits;
import com.pi4j.util.Console;

public class CoinThread extends Thread {
    private final Serial serial = SerialFactory.createInstance();
    private boolean isrunning = false;
	@Override
	public void run() {
		super.run();
		
		isrunning = true;
		
        SerialConfig config = new SerialConfig();
        config.device("/dev/ttyACM0")
              .baud(Baud._9600)
              .dataBits(DataBits._8)
              .parity(Parity.NONE)
              .stopBits(StopBits._1)
              .flowControl(FlowControl.NONE);

        try {
			serial.open(config);
			
	        while(isrunning) {
	            Thread.sleep(1000);
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void close() {
		isrunning = false;
	}
	
	public void setSerialDataEventListener(SerialDataEventListener listener) {
		serial.addListener(listener);
	}
}
