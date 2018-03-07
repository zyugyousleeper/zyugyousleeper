package model.items;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import com.sun.corba.se.spi.orbutil.fsm.Action;
import com.sun.xml.internal.ws.api.pipe.Fiber.Listener;

public class Product implements Item {
	
	private String name = "";
	private ActionListener listener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
	};
	
	public void setText(String name) {
		this.name = name;
	}
	
	public void setlistener(ActionListener listener) {
		this.listener = listener;
	}

	@Override
	public String getText() {
		return name;
	}

	@Override
	public ActionListener getActionListener() {
		// TODO Auto-generated method stub
		return listener;
	}

}
