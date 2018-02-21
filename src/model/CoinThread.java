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
    final Serial serial = SerialFactory.createInstance();
    
	@Override
	public void run() {
		super.run();
		
        final Console console = new Console();
        console.title("<-- The Pi4J Project -->", "Serial Communication Example");
        console.promptForExit();

        SerialConfig config = new SerialConfig();
        config.device("/dev/ttyACM0")
              .baud(Baud._9600)
              .dataBits(DataBits._8)
              .parity(Parity.NONE)
              .stopBits(StopBits._1)
              .flowControl(FlowControl.NONE);

        console.box(" Connecting to: " + config.toString(),
                " We are sending ASCII data on the serial port every 1 second.",
                " Data received on serial port will be displayed below.");

        try {
			serial.open(config);
			
	        while(console.isRunning()) {
	            Thread.sleep(1000);
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setSerialDataEventListener(SerialDataEventListener listener) {
		serial.addListener(listener);
	}
}
